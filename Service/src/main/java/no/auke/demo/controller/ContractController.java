package no.auke.demo.controller;

import java.net.URISyntaxException;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

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
        return new Contracts(insureServ.allContracts());
    }
     
    @PostMapping("/createContract")
    public ResponseEntity<ServiceReponse> createContract(@RequestBody Contract contract) {
    	
    	ServiceReponse resp = insureServ.createContract(contract);
    	if(resp.isError()) {    		
    		return ResponseEntity.badRequest().body(resp);
    	} else {
    		return ResponseEntity.ok().body(resp);
    	}

    }
  
    @PostMapping("/updateContract")
    public ResponseEntity<ServiceReponse> updateContract(@RequestBody Contract contract) {

    	ServiceReponse resp = insureServ.updateContract(contract);
    	if(resp.isError()) {
    		return ResponseEntity.badRequest().body(resp);
    	} else {
    		return ResponseEntity.ok().body(resp);
    	}
    }
 
}
