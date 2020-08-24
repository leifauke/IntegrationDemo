package no.auke.demo.client;

import no.auke.demo.domains.Contract;

public class Result {
	
	private Contract contract;
	private String errormsg="";
	
	public Result(Contract contract, String errormsg) {
		this.contract = contract;
	}
	public boolean isError() {
		return errormsg!="";
	}


}
