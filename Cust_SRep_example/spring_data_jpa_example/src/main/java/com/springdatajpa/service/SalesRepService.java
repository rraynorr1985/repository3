package com.springdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdatajpa.entity.Customer;
import com.springdatajpa.entity.SalesRep;
import com.springdatajpa.repository.SalesRepRepository;

@Service
public class SalesRepService {
	@Autowired SalesRepRepository repo;
	
	 @Transactional
	    public void save(SalesRep srep) {
	        repo.save(srep);
	    }
	     
	    public List<SalesRep> listAll() {
	        return (List<SalesRep>) repo.findAll();
	    }
	     
	    public SalesRep get(Long id) {
	        return repo.findById(id).get();
	    }
	    
	    @Transactional 
	    public void delete(Long id) {
	        repo.deleteById(id);
	    }
	     
	    public List<SalesRep> search(String keyword) {
	        return repo.search(keyword);
	    }
}
