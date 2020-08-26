package no.auke.demo.controller;

import java.net.URISyntaxException;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.auke.demo.domains.Contract;
import no.auke.demo.domains.Contracts;
import no.auke.demo.integration.ServiceResponse;
 


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
    public ResponseEntity<ServiceResponse> createContract(@RequestBody Contract contract) {
    	
    	ServiceResponse resp = insureServ.createContract(contract);
    	if(resp.isError()) {    	
    		return new ResponseEntity<ServiceResponse>(resp, HttpStatus.BAD_REQUEST);
    	} else {
    		return new ResponseEntity<ServiceResponse>(resp, HttpStatus.CREATED);
    	}

    }
  
    @PostMapping("/updateContract")
    public ResponseEntity<ServiceResponse> updateContract(@RequestBody Contract contract) {

    	ServiceResponse resp = insureServ.updateContract(contract);
    	if(resp.isError()) {    	
    		return new ResponseEntity<ServiceResponse>(resp, HttpStatus.BAD_REQUEST);
    	} else {
    		return new ResponseEntity<ServiceResponse>(resp, HttpStatus.CREATED);
    	}
    }
 
}
