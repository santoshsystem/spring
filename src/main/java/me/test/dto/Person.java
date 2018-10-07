package me.test.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="HeMan")
@XmlType(name="Person")
public class Person extends BasePojo {
	String name;
	String email;
	int age;
	boolean sex;
	Date doj;
	
	//@XmlAttribute(name="attr")
	BasePojo jo = new BasePojo("Ping", "Pong");
	
	
	public Person() {
		super("1", "2");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@XmlAttribute
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	//@XmlElement(name="DD")
	public BasePojo getJo() {
		return jo;
	}

	public void setJo(BasePojo jo) {
		this.jo = jo;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", age=" + age + ", sex=" + sex + ", doj=" + doj + "]";
	}
	
}
