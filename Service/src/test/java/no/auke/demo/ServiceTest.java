package no.auke.demo;

import static org.junit.Assert.*;

import org.junit.Test;

import no.auke.demo.controller.ContractService;
import no.auke.demo.domains.Contract;
import no.auke.demo.integration.ServiceReponse;

public class ServiceTest {

	@Test
	public void testCreate() {
		
		ContractService service = new ContractService();
		Contract contract = new Contract(1,"leif");
		ServiceReponse resp = service.createContract(contract);
		
		assertNull(resp.getErrorMsg());
		assertNotNull(resp.getRetObject());
		assertTrue(((Contract)resp.getRetObject()).getContractid()>0);
	
	}

}
