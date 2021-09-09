package com.reward.service;


import com.reward.doa.Customer_Reposit;
import com.reward.entities.Customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointsService {
	
	@Autowired
	private Customer_Reposit customer_Reposit;
	
	public List<Customer> getAll(){
		return customer_Reposit.findAll();
	}
	
	public Customer getByID(int customer_id) {
		return customer_Reposit.findById(customer_id).orElse(null);
		
	}
}
