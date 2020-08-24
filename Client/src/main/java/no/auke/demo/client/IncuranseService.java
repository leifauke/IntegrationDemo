package no.auke.demo.client;

import no.auke.demo.domains.Contract;

public class IncuranseService {
	
	private String address="";	
	public IncuranseService() {}
	public IncuranseService(String address) {
		this.address = address;
	}
	
	public Result createContracts(String custid, String name, String type, double amount) {
	
		String resultString = "";
		
		
		
		if(resultString.contains("1#")) {
			// customer dont exists
			return new Result(new Contract(),"customer dont exists");
		} else if(resultString.contains("2#")) {
			// contract exists
			return new Result(new Contract(),"contract exists");
		} else if(resultString.contains("3#")) {
			// wrong contracttype
			return new Result(new Contract(),"wrong contracttype");
		} else if(resultString.contains("4#")) {
			// wrong amount		
			return new Result(new Contract(),"wrong amount");
		} else {
			return new Result(new Contract(),"");
		}
		
	}
	

}
