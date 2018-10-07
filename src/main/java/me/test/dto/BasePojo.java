package me.test.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name="Inner")
@XmlType(name="BasePojo")
public class BasePojo {
	String base1;
	String base2;
	
	public BasePojo() {
		super();
	}
	public BasePojo(String base1, String base2) {
		super();
		this.base1 = base1;
		this.base2 = base2;
	}
	public String getBase1() {
		return base1;
	}
	public void setBase1(String base1) {
		this.base1 = base1;
	}
	public String getBase2() {
		return base2;
	}
	public void setBase2(String base2) {
		this.base2 = base2;
	}
	
	
}
