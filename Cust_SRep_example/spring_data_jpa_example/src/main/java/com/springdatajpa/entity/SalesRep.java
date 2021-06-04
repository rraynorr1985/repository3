package com.springdatajpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class SalesRep {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String officeCode;
	
	
	public SalesRep() {
		super();
	}
	public SalesRep(Long id, String name, String officeCode) {
		super();
		this.id = id;
		this.name = name;
		this.officeCode = officeCode;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
//	public List<Customer> getAssCustomers() {
//		return assCustomers;
//	}
//	public void setAssCustomers(List<Customer> assCustomers) {
//		this.assCustomers = assCustomers;
//	}
	
	
}
