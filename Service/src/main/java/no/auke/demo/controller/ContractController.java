package no.auke.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.auke.demo.domains.Contract;
import no.auke.demo.domains.Contracts;
import no.auke.demo.integration.ServiceReponse;
 
@RestController()
@RequestMapping("/")
public class ContractController {
	
	ContractService insureServ = new ContractService();
	
    @GetMapping("/contracts")
    public Contracts getAllContracts() {
    	System.out.println("getall");
        return new Contracts(insureServ.allContracts());
    }
     
    @PostMapping("/createContract")
    public ResponseEntity<ServiceReponse> createContract(@RequestBody Contract contract) {
    	
    	ServiceReponse resp = insureServ.createContract(contract);
    	if(resp.isError()) {    	
    		return new ResponseEntity<ServiceReponse>(resp, HttpStatus.BAD_REQUEST);
    	} else {
    		return new ResponseEntity<ServiceReponse>(resp, HttpStatus.CREATED);
    	}

    }
  
    @PostMapping("/updateContract")
    public ResponseEntity<ServiceReponse> updateContract(@RequestBody Contract contract) {

    	ServiceReponse resp = insureServ.updateContract(contract);
    	if(resp.isError()) {    	
    		return new ResponseEntity<ServiceReponse>(resp, HttpStatus.BAD_REQUEST);
    	} else {
    		return new ResponseEntity<ServiceReponse>(resp, HttpStatus.CREATED);
    	}
    }
 
}
