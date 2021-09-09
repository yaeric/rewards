package com.reward.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customer_id;
	private String customer_name;
	
	@JsonInclude
	@Transient
	private Long reward_points;
	@JsonInclude
	@Transient
	private Double purchase;
	@OneToMany(cascade = CascadeType.ALL,fetch =FetchType.LAZY,mappedBy = "customer")
	private List<Customer_Transaction> customer_trans;
	
	
	public Customer() {
		super();
	}
	
	public Customer(int id, String name) {
		this.customer_id=id;
		this.customer_name=name;
	}


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public String getCustomer_name() {
		return customer_name;
	}


	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	

	public void setReward_points(Long reward_points) {
		this.reward_points = reward_points;
	}


	public Long getReward_points() {
		if(customer_trans==null||customer_trans.isEmpty())
			return 0l;
		return customer_trans.stream().map(x->x.getRewardPoints().intValue()).reduce(0,(a,b) -> a+b).longValue();
	}




	public void setPurchase(Double purchase) {
		this.purchase = purchase;
	}
	
	public Double getPurchase() {
		if(customer_trans==null||customer_trans.isEmpty())
			return 0d;
		return customer_trans.stream().map(x->x.getTotal_trans().doubleValue()).reduce(0d,(a,b) -> a+b).doubleValue();
	}


	public List<Customer_Transaction> getCustomer_trans() {
		return customer_trans;
	}


	public void setCustomer_trans(List<Customer_Transaction> customer_trans) {
		this.customer_trans = customer_trans;
	}





	
	

}
