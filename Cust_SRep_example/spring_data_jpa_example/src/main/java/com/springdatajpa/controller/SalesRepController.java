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
import com.springdatajpa.service.SalesRepService;

@Controller
public class SalesRepController {
	@Autowired SalesRepService salesrepService;
	
	@RequestMapping("/salesrep")
	public ModelAndView salesrepIndex() {
	    List<SalesRep> listSalesRep = salesrepService.listAll();
	    ModelAndView mav = new ModelAndView("salesrep");
	    mav.addObject("listSalesRep", listSalesRep);
	    return mav;
	}
	
	@RequestMapping("/newsalesrep")
	public String newSalesRepForm(Map<String, Object> model) {
	    SalesRep srep = new SalesRep();
	    model.put("salesrep", srep);
	    return "new_salesrep";
	}
	
	@RequestMapping(value = "/saverep", method = RequestMethod.POST)
	public String saveSaleRep(@ModelAttribute("salesrep") SalesRep srep) {
		salesrepService.save(srep);
	    return "redirect:/salesrep";
	}
	
	@RequestMapping("/editsr")
	public ModelAndView editSrepForm(@RequestParam long id) {
	    ModelAndView mav = new ModelAndView("edit_srep");
	    SalesRep srep = salesrepService.get(id);
	    mav.addObject("srep", srep);
	 
	    return mav;
	}
	
	@RequestMapping(value = "/savesrep", method = RequestMethod.POST)
	public String saveSrep(@ModelAttribute("srep") SalesRep srep) {
		salesrepService.save(srep);
	    return "redirect:/salesrep";
	}
	
	@RequestMapping("/deletesrep")
	public String deleteCustomerForm(@RequestParam long id) {
		salesrepService.delete(id);
	    return "redirect:/salesrep";       
	}
	
}
