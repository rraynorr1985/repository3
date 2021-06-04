package com.springdatajpa.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springdatajpa.entity.Customer;
import com.springdatajpa.entity.SalesRep;

@Repository
public interface SalesRepRepository extends CrudRepository<SalesRep, Long> {
	
	@Query(value = "SELECT s FROM SalesRep s WHERE s.name LIKE '%' || :keyword || '%'"
            + " OR s.officeCode LIKE '%' || :keyword || '%'")
    public List<SalesRep> search(@Param("keyword") String keyword);
	
	
		
}
