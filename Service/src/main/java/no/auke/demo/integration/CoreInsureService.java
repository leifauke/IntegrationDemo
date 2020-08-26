package no.auke.demo.integration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.auke.demo.domains.Contract;

public class CoreInsureService {
	
    private static Map<Integer, String> users = new HashMap<>(); 
    private static Map<Integer, Contract> contracts = new HashMap<>(); 
    
	public CoreInsureService(){}
	
	public List<Contract> allContracts() {
		return new ArrayList<>(contracts.values());
	}

    static {
    	
    	for(int i = 1;i<10;i++) {
    		users.put(i, "Leif " + i);
            Contract contract = new Contract();
            contract.setCustId(i);
            contract.setName("Leif " + i);
            contract.setContractid(contracts.size());
            contracts.put(contract.getContractid(), contract);    		
    	}
         
    }

	public boolean userExists(int custId, String name) {
		
		if(users.containsKey(custId)) {
			return true;
		} else {
			for(String u:users.values()) {
				if(name.equals(u)) {
					return true;
				}
			}
		}
		
		return false;
	}

	public ServiceResponse createContract(Contract contract) {
		
        if(contract.getContractid()>0 && contracts.containsKey(contract.getContractid())) {
            return new ServiceResponse(1,"contract exists");
        }
        
        contract.setContractid(contracts.size());
        contracts.put(contract.getContractid(), contract);        

        return new ServiceResponse(contract);
	
	}

	public void deleteContract(Contract contract) {
		// TODO Auto-generated method stub
		
	}

	
	
}
