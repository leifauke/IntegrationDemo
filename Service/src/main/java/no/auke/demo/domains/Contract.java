package no.auke.demo.domains;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
  
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "contract")
public class Contract implements Serializable {
  
    private static final long serialVersionUID = 1L;
    
    public Contract() {}
    public Contract(int custid, String name) {
    	this.custid=custid;
    	this.name=name;
    }
  
    @XmlAttribute(name = "custid")
    private int custid;
    
    @XmlElement(name = "name")
    private String name;
  
    @XmlElement(name = "lastName")
    private String lastName;
    
    @XmlAttribute(name = "contractid")
    private int contractid;    
    
    @XmlAttribute(name = "type")
    private String type;       

    @XmlAttribute(name = "status")
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