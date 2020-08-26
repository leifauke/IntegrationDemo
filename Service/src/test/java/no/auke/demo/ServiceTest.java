package no.auke.demo;

import static org.junit.Assert.*;

import org.junit.Test;

import no.auke.demo.controller.ContractService;
import no.auke.demo.domains.Contract;
import no.auke.demo.integration.ServiceResponse;

public class ServiceTest {

	@Test
	public void testCreate() {
		
		ContractService service = new ContractService();
		Contract contract = new Contract(1,"leif");
		ServiceResponse resp = service.createContract(contract);
		
		assertNull(resp.getErrorMsg());
		assertNotNull(resp.getRetContract());
		assertTrue(((Contract)resp.getRetContract()).getContractid()>0);
	
	}

}
