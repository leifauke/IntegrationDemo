package no.auke.demo.controller;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import no.auke.demo.domains.Contract;
import no.auke.demo.domains.Contracts;
import no.auke.demo.integration.ServiceReponse;
 
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "users")
@Path("/contracts")
public class ContractController {
	
	ContractService insureServ = new ContractService();
	
    @GET
    @Produces("application/json")
    public Contracts getAllContracts() {
        return new Contracts(insureServ.allContracts());
    }
     
    @POST
    @Consumes("application/json")
    public Response createContract(Contract contract) throws URISyntaxException {
    	
    	ServiceReponse resp = insureServ.createContract(contract);
    	if(resp.isError()) {
    		return Response.status(resp.getError()).entity(resp.getErrormsg()).build();
    	} else {
    		return Response.status(201).build();
    	}

    }
  
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateContract(@PathParam("id") int id, Contract contract) throws URISyntaxException {

    	ServiceReponse resp = insureServ.updateContract(contract);
    	if(resp.isError()) {
    		return Response.status(resp.getError()).entity(resp.getErrormsg()).build();
    	} else {
    		return Response.status(201).entity(resp.getRetobject()).build();
    	}
    }
 
}
