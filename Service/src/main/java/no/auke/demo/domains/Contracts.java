package no.auke.demo.domains;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
  
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contracts {

    private List<Contract> contracts;
    public List<Contract> getContracts() {return contracts;}

	public Contracts() {}
	public Contracts(List<Contract> contracts) {this.contracts=contracts;}
	    
}
