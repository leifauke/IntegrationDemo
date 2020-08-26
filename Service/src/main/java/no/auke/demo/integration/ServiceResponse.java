package no.auke.demo.integration;

import no.auke.demo.domains.Contract;

public class ServiceResponse {
	
	private int error=0;
	private String errorMsg;
	private Contract retContract;
	
	public ServiceResponse() {}

	public ServiceResponse(Contract retContract) {
		this.setRetContract(retContract);
	}
	
	public ServiceResponse(int error,  String errorMsg) {
		this.error=error;
		this.errorMsg=errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errormsg) {
		this.errorMsg = errormsg;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public Contract getRetContract() {
		return retContract;
	}

	public void setRetContract(Contract retobject) {
		this.retContract = retobject;
	}

	public boolean isError() {
		return error>0;
	}

}
