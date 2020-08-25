package no.auke.demo.controller;

import java.util.List;

import no.auke.demo.domains.Contract;
import no.auke.demo.integration.ClientMailerService;
import no.auke.demo.integration.CoreInsureService;
import no.auke.demo.integration.ServiceReponse;

public class ContractService {	
	
	private CoreInsureService coreSystem = new CoreInsureService();
	private ClientMailerService messageSender = new ClientMailerService();

	public CoreInsureService getCoreSystem() {
		return coreSystem;
	}
	public ClientMailerService getMessageSender() {
		return messageSender;
	}
		
	public ContractService() {} 	
	public List<Contract> allContracts() {
		return getCoreSystem().allContracts();
	}
	
	public ServiceReponse createContract(Contract contract) {
		
        if(contract == null) {
            return new ServiceReponse(400,"No contract in request");
        } else if(contract.getCustId() == 0 || contract.getName() == null) {
			return new ServiceReponse(400,"Please provide all mandatory inputs");
        } else if(!getCoreSystem().userExists(contract.getCustId(),contract.getName())) {
			return new ServiceReponse(400,"Customer not existing");			
		};

		ServiceReponse resp = getCoreSystem().createContract(contract);

		if(!resp.isError()) {
			if(getMessageSender().sendMessage(contract.getName(), "ny kontrakt er opprettet")) {
				return resp;				
			} else {
				// delete contract
				getCoreSystem().deleteContract(contract);
				new ServiceReponse(400,"Message service down, contract could not be created");
			}
		} 
		return resp;

	}
	public ServiceReponse updateContract(Contract contract) {
		// TODO Auto-generated method stub
		return null;
	}

}
