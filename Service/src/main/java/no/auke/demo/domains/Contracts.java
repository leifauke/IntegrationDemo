package no.auke.demo.domains;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
  
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "contracts")
public class Contracts {
  
	public Contracts() {}
	
    @XmlElement(name="contract")
    private ArrayList<Contract> contracts;
  
    public ArrayList<Contract> getContracts() {return contracts;}
    public void setContracts(ArrayList<Contract> contracts) {this.contracts = contracts;}
    
}
