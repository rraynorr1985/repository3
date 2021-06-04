package com.springdatajpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdatajpa.entity.Customer;
import com.springdatajpa.entity.SalesRep;
import com.springdatajpa.repository.CustomerRepository;
import com.springdatajpa.repository.SalesRepRepository;
 
@Service
//@Transactional we don't need it for all methods,because we don't need to persist 2 of them
public class CustomerService {
	CustomerRepository repo; 
 	SalesRepRepository srepo;
 	
	@Autowired
    public CustomerService(CustomerRepository repo, SalesRepRepository repRepo) {
    	this.repo = repo;
    	this.srepo = repRepo;
    }
	
	
    @Transactional
    public void save(Customer customer) {
        repo.save(customer);
    }
     
    public List<Customer> listAll() {
        return (List<Customer>) repo.findAll();
    }
     
    public Customer get(Long id) {
        return repo.findById(id).get();
    }
    
    @Transactional 
    public void delete(Long id) {
        repo.deleteById(id);
    }
     
    public List<Customer> search(String keyword) {
        return repo.search(keyword);
    }
    
    @Transactional
    public void save(Long custId,Long salesId)
    {
    	Customer cust = repo.findById(custId).get();
    	SalesRep srep = srepo.findById(salesId).get();
    	cust.setSalesrep(srep);
    }
}