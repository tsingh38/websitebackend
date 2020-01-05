package com.lastrada.website.lastrada.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CustomerOrder {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToMany
	@JoinTable(name="customerOrder_OrderItems",joinColumns=@JoinColumn(name="customerOrder_id"), inverseJoinColumns=@JoinColumn(name="orderItem_id"))
	private Set<OrderItem>listOfOrderItems=new HashSet<>();
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
	private CustomerInformation customer;
	private String orderComment;
	private String wishDeliveryTime;
	private String paymentMethod;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<OrderItem> getListOfOrderItems() {
		return listOfOrderItems;
	}
	public void setListOfOrderItems(Set<OrderItem> listOfOrderItems) {
		this.listOfOrderItems = listOfOrderItems;
	}
	public CustomerInformation getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerInformation customer) {
		this.customer = customer;
	}
	public String getOrderComment() {
		return orderComment;
	}
	public void setOrderComment(String orderComment) {
		this.orderComment = orderComment;
	}
	public String getWishDeliveryTime() {
		return wishDeliveryTime;
	}
	public void setWishDeliveryTime(String wishDeliveryTime) {
		this.wishDeliveryTime = wishDeliveryTime;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public CustomerOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerOrder(CustomerInformation customer, String orderComment, String wishDeliveryTime,
			String paymentMethod) {
		super();
		this.customer = customer;
		this.orderComment = orderComment;
		this.wishDeliveryTime = wishDeliveryTime;
		this.paymentMethod = paymentMethod;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listOfOrderItems == null) ? 0 : listOfOrderItems.hashCode());
		result = prime * result + ((orderComment == null) ? 0 : orderComment.hashCode());
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
		result = prime * result + ((wishDeliveryTime == null) ? 0 : wishDeliveryTime.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerOrder other = (CustomerOrder) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listOfOrderItems == null) {
			if (other.listOfOrderItems != null)
				return false;
		} else if (!listOfOrderItems.equals(other.listOfOrderItems))
			return false;
		if (orderComment == null) {
			if (other.orderComment != null)
				return false;
		} else if (!orderComment.equals(other.orderComment))
			return false;
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		if (wishDeliveryTime == null) {
			if (other.wishDeliveryTime != null)
				return false;
		} else if (!wishDeliveryTime.equals(other.wishDeliveryTime))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CustomerOrder [id=" + id + ", listOfOrderItems=" + listOfOrderItems + ", customer=" + customer
				+ ", orderComment=" + orderComment + ", wishDeliveryTime=" + wishDeliveryTime + ", paymentMethod="
				+ paymentMethod + "]";
	}
	
	
}
