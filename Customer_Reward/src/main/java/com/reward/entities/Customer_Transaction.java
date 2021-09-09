package com.reward.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Reward")
public class Customer_Transaction extends Customer_Reward{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int trans_id;
	private Double total_trans;
	@ManyToOne
	@JoinColumn
	private Customer customer;
	private Date tranDate;
	
	public int getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}

	public Double getTotal_trans() {
		return total_trans;
	}

	public void setTotal_trans(Double total_trans) {
		this.total_trans = total_trans;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer_Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long getRewardPoints() {
		this.reward_points=0l;
		if(this.total_trans>50 && this.total_trans<=100) {
			this.reward_points+=(this.total_trans.intValue()-50)*1;
		}
		if(this.total_trans>100) {
			this.reward_points+=50;
			this.reward_points+=(this.total_trans.intValue()-100)*2;
		}
		
		return this.reward_points;
	}

	public Customer_Transaction(int trans_id, Customer customer,double total_trans, java.util.Date date) {
		super();
		this.trans_id = trans_id;
		this.customer = customer;
		this.total_trans = total_trans;
		this.tranDate = (Date) date;
	}

	@Override
	public String toString() {
		return "Customer_Transaction [trans_id=" + trans_id + ", total_trans=" + total_trans + ", customer=" + customer
				+ "]";
	}



}
