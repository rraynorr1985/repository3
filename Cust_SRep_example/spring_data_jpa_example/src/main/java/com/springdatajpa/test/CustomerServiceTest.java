package com.springdatajpa.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.springdatajpa.entity.Customer;
import com.springdatajpa.repository.CustomerRepository;
import com.springdatajpa.service.CustomerService;

class CustomerServiceTest {
	 CustomerRepository repo;
	 CustomerService service;
	
	@BeforeEach
	void setUp() throws Exception {
		repo = Mockito.mock(CustomerRepository.class);
		service = new CustomerService(repo, null);
	}
	@Test
	void test() {
		Customer expected = new Customer("Young", "y@gmail.com", "NY");
		expected.setId(1L);
		Mockito.when(repo.findById(anyLong())).thenReturn(Optional.of(expected));
		Customer actual = service.get(1L);
		assertEquals(expected, actual);
	}
}
