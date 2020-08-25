package no.auke.demo.client;

import static org.junit.Assert.*;

import org.junit.Test;

import no.auke.demo.domains.Contract;
import no.auke.demo.domains.Contracts;
import no.auke.demo.integration.ServiceReponse;

public class ClientTest {


	@Test
	public void testGetAll() {
		ClientApp app = new ClientApp();
		try {
			Contracts res = app.getAllContracts();
			assertNotNull(res);	
			assertTrue(res.getContracts().size()>0);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}
	
	@Test
	public void testCreateContract() {
		
		ClientApp app = new ClientApp();
		Contract contract = new Contract(1,"leif");
		try {
			
			ServiceReponse res = app.createContract(contract);
			assertNotNull(res);
			if(res.isError()) {
				fail(res.getErrorMsg());
			} 
			assertNotNull(res.getRetObject());		
			
			Contract ret_contract = (Contract)res.getRetObject();			
			assertEquals(ret_contract.getCustId(),contract.getCustId());
			assertTrue(ret_contract.getContractid()>0);
			
			
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}	

}
