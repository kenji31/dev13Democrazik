package fr.democrazik.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Test {
	
	@Id @GeneratedValue
	private Long id;
	private String test;
	public Test(String test) {
		super();
		this.test = test;
	}
	public Test() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	
	

}
