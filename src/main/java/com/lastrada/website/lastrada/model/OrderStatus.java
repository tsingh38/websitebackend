package com.lastrada.website.lastrada.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderStatus {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToOne
	@JoinColumn( name="custorder_id")
	private CustOrder custOrder;
	private Integer status;
	private String orderDate;
	private String orderTime;
	private Long orderNumber;
	
	OrderStatus(){
		
	}

	public OrderStatus(CustOrder custOrder, Integer status, String orderDate, String orderTime, Long orderNumber) {
		super();
		this.custOrder = custOrder;
		this.status = status;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.orderNumber = orderNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustOrder getCustOrder() {
		return custOrder;
	}

	public void setCustOrder(CustOrder custOrder) {
		this.custOrder = custOrder;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}
	

	
}
