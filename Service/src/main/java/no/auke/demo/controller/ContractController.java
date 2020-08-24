package no.auke.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

 
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "users")
@Path("/contracts")
public class ContractController 
{
    private static Map<Integer, Contract> DB = new HashMap<>(); 
     
    @GET
    @Produces("application/json")
    public Contracts getAllContracts() {
        Contracts contracts = new Contracts();
        contracts.setContracts(new ArrayList<>(DB.values()));
        return contracts;
    }
     
    @POST
    @Consumes("application/json")
    public Response createContract(Contract contract) throws URISyntaxException {
        
    	if(contract.getFirstName() == null || contract.getLastName() == null) {
            return Response.status(400).entity("Please provide all mandatory inputs").build();
        }
        
        contract.setId(DB.values().size()+1);
        contract.setUri("/user-management/"+contract.getId());
    
        DB.put(contract.getId(), contract);
        return Response.status(201).contentLocation(new URI(contract.getUri())).build();
    
    }
 
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getContractById(@PathParam("id") int id) throws URISyntaxException {
        
    	Contract contract = DB.get(id);
        
        if(contract == null) {
            return Response.status(404).build();
        }
        
        return Response
                .status(200)
                .entity(contract)
                .contentLocation(new URI("/user-management/"+id)).build();
    
    }
 
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateContract(@PathParam("id") int id, Contract contract) throws URISyntaxException {
    	Contract temp = DB.get(id);
        if(contract == null) {
            return Response.status(404).build();
        }
        temp.setFirstName(contract.getFirstName());
        temp.setLastName(contract.getLastName());
        DB.put(temp.getId(), temp);
        return Response.status(200).entity(temp).build();
    }
 
    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) throws URISyntaxException {
    	Contract contract = DB.get(id);
        if(contract != null) {
            DB.remove(contract.getId());
            return Response.status(200).build();
        }
        return Response.status(404).build();
    }
     
    static {
    	
        Contract user1 = new Contract();
        user1.setId(1);
        user1.setFirstName("John");
        user1.setLastName("Wick");
        user1.setUri("/user-management/1");
 
        Contract user2 = new Contract();
        user2.setId(2);
        user2.setFirstName("Harry");
        user2.setLastName("Potter");
        user2.setUri("/user-management/2");
         
        DB.put(user1.getId(), user1);
        DB.put(user2.getId(), user2);
    }
    
}
