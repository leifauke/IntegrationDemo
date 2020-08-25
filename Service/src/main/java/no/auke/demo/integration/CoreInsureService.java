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

	public ServiceReponse createContract(Contract contract) {
		
        if(contracts.containsKey(contract.getContractid())) {
            return new ServiceReponse(400,"contract exists");
        }
        
        //TODO more fiddling with users etc, but for now ok
        contracts.put(contract.getContractid(), contract);
        
		return new ServiceReponse(contract);
	}

	public void deleteContract(Contract contract) {
		// TODO Auto-generated method stub
		
	}

	
	
}
