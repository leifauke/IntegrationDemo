package no.auke.demo.integration;

public class ServiceReponse {
	
	private int error=0;
	private String errormsg;
	private Object retobject;
	
	public ServiceReponse() {}

	public ServiceReponse(Object retobject) {
		this.setRetobject(retobject);
	}
	
	public ServiceReponse(int error,  String errormsg) {
		this.error=error;
		this.errormsg=errormsg;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public Object getRetobject() {
		return retobject;
	}

	public void setRetobject(Object retobject) {
		this.retobject = retobject;
	}

	public boolean isError() {
		return error>0;
	}

}
