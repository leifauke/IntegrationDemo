package no.auke.demo;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.spy;


import no.auke.demo.controller.ContractService;
import no.auke.demo.domains.Contract;
import no.auke.demo.integration.ClientMailerService;
import no.auke.demo.integration.CoreInsureService;
import no.auke.demo.integration.ServiceReponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

@SuppressWarnings("unused")
public class ServiceMockTest {
	
	ContractService service = new ContractService();
	
	CoreInsureService ins;
	ClientMailerService mail;
	ContractService spyservice;
	
	@Before
	public void setUp() throws Exception {
		
		ins = mock(CoreInsureService.class);
		when(ins.userExists(anyInt(), anyString())).thenReturn(false);

		mail = mock(ClientMailerService.class);
		when(mail.sendMessage(anyString(),anyString())).thenReturn(true);		
	
		spyservice = spy(service);

		doReturn(ins).when(spyservice).getCoreSystem();

	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test
	public void testCreateeErrorEmpty() {
		assertEquals("No contract in request",service.createContract(null).getErrorMsg());
	}
	
	@Test
	public void testCreateErrorMandatory() {
		assertEquals("Please provide all mandatory inputs",service.createContract(new Contract()).getErrorMsg());
	}
	
	@Test
	public void testCreateNotExists() {
		when(ins.userExists(anyInt(), anyString())).thenReturn(false);
		assertEquals("Customer not existing",spyservice.createContract(new Contract(100,"pettersen")).getErrorMsg());
	}

	@Test
	public void testCreateExists() {

		when(ins.userExists(anyInt(), anyString())).thenReturn(true);
		when(ins.createContract(any())).thenReturn(new ServiceReponse(new Contract(100,"pettersen")));
		
		assertEquals(false,spyservice.createContract(new Contract(100,"pettersen")).isError());
		assertEquals("pettersen",((Contract)spyservice.createContract(new Contract(100,"pettersen")).getRetContract()).getName());
	
	}
	
}
