package com.reward.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reward.entities.Customer;


@Repository
public interface Customer_Reposit extends JpaRepository<Customer, Integer>{
	
}
