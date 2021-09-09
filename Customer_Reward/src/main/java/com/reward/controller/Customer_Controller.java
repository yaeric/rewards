package com.reward.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.reward.entities.Customer;
import com.reward.service.PointsService;

@Controller
public class Customer_Controller {
	
	@Autowired
	private PointsService pointService;
	
	
	@GetMapping("/customer")
	public List<Customer> findAll(){
		return pointService.getAll();
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id){
		Customer customer = pointService.getByID(id);
		if(customer==null) 
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
}
