package no.auke.demo.client;


import org.springframework.web.client.RestTemplate;

import no.auke.demo.domains.Contract;
import no.auke.demo.domains.Contracts;
import no.auke.demo.integration.ServiceReponse;


public class ClientApp {

	private static final String REST_URI = "http://localhost:8080/";
	
	RestTemplate restTemplate = new RestTemplate();

    public Contracts getAllContracts() {
    	return restTemplate.getForObject(REST_URI + "/contracts", Contracts.class);
    }

    public ServiceReponse createContract(Contract contract) {
    	return restTemplate.postForObject(REST_URI + "/createContract", contract, ServiceReponse.class);
    }

}
