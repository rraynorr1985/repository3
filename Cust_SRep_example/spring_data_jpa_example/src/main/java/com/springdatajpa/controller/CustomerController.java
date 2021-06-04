package com.springdatajpa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springdatajpa.entity.Customer;
import com.springdatajpa.entity.SalesRep;
import com.springdatajpa.service.CustomerService;
import com.springdatajpa.service.SalesRepService;

@Controller
public class CustomerController {
	@Autowired CustomerService customerService;
	
	@Autowired SalesRepService salesrepService;
	
	@RequestMapping("/")
	public ModelAndView home() {
	    ModelAndView mav = new ModelAndView("home");
	    return mav;
	}
	
	@RequestMapping("/customer")
	public ModelAndView customerIndex() {
	    List<Customer> listCustomer = customerService.listAll();
	    ModelAndView mav = new ModelAndView("customer");
	    mav.addObject("listCustomer", listCustomer);
	    return mav;
	}
	
	@RequestMapping("/new")
	public String newCustomerForm(Map<String, Object> model) {
	    Customer customer = new Customer();
	    model.put("customer", customer);
	    return "new_customer";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
	    customerService.save(customer);
	    return "redirect:/customer";
	}
	
	
	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam long id) {
	    ModelAndView mav = new ModelAndView("edit_customer");
	    Customer customer = customerService.get(id);
	    mav.addObject("customer", customer);
	    return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteCustomerForm(@RequestParam long id) {
	    customerService.delete(id);
	    return "redirect:/customer";       
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
	    List<Customer> result = customerService.search(keyword);
	    ModelAndView mav = new ModelAndView("search");
	    mav.addObject("result", result);
	 
	    return mav;    
	}
	
	@RequestMapping("/assign")
	public ModelAndView assignCustomerForm(@RequestParam long id) {
		List<SalesRep> listSalesRep = salesrepService.listAll();
	    ModelAndView mav = new ModelAndView("assign");
	    Customer customer = customerService.get(id);
	    mav.addObject("customer", customer);
	    mav.addObject("listSalesRep",listSalesRep);
	    return mav;
	}
	
	
	@RequestMapping(value = "/assign-rep")
	public String saveAssi(@RequestParam long custId, @RequestParam long repId) {
		customerService.save(custId, repId);
	    return "redirect:/customer";
	}
}
