package no.auke.demo.controller;

import java.util.List;

import no.auke.demo.domains.Contract;
import no.auke.demo.integration.ClientMailerService;
import no.auke.demo.integration.CoreInsureService;
import no.auke.demo.integration.ServiceReponse;

public class ContractService {	
	
	CoreInsureService insure = new CoreInsureService();
	ClientMailerService messageSender = new ClientMailerService();

	public ContractService() {} 	
	public List<Contract> allContracts() {
		return insure.allContracts();
	}
	
	public ServiceReponse createContract(Contract contract) {
		
        if(contract == null) {
            return new ServiceReponse(400,"No contract in request");
        } else if(contract.getName() == null || contract.getName() == null) {
			return new ServiceReponse(400,"Please provide all mandatory inputs");
        } else if(!insure.userExists(contract.getCustId(),contract.getName())) {
			return new ServiceReponse(400,"Customer not existing");			
		};

		ServiceReponse resp = insure.createContract(contract);

		if(!resp.isError()) {
			if(messageSender.sendMessage(contract.getName(), "ny kontrat er oppretttet")) {
				return resp;				
			} else {
				// delete contract
				insure.deleteContract(contract);
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
