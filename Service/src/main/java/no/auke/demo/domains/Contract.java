package no.auke.demo.domains;

import java.io.Serializable;
  
public class Contract implements Serializable {
  
    private static final long serialVersionUID = 1L;
    
    public Contract() {}
    public Contract(int custid, String name) {
    	this.custid=custid;
    	this.name=name;
    }
  
    private int custid;
    private String name;
    private int contractid;    
    private String type;       
    private String status;       
    
    public int getCustId() {
        return custid;
    }
    public void setCustId(int id) {
        this.custid = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getContractid() {
		return contractid;
	}
    public void setContractid(int contractid) {
		this.contractid = contractid;
	}
    public String getType() {
		return type;
	}
    public void setType(String type) {
		this.type = type;
	}
    public String getStatus() {
		return status;
	}
    public void setStatus(String status) {
		this.status = status;
	}

}