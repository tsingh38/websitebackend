package com.lastrada.website.lastrada.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class CustOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String address;
	private String pincode;
	private String city;
	private String floor;
	private String customerName;
	private String email;
	private String telefonnummer;
	private String companyname;
	private String wishDeliveryTime;
	private String comment;
	private String paymentType;
	@OneToMany
	@JoinColumn( name="custorder_id")
	private Set<OrderItem> order=new HashSet<>();
	private BigDecimal totalPrice;
	
	CustOrder(){
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getFloor() {
		return floor;
	}


	public void setFloor(String floor) {
		this.floor = floor;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefonnummer() {
		return telefonnummer;
	}


	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}


	public String getCompanyname() {
		return companyname;
	}


	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}


	public String getWishDeliveryTime() {
		return wishDeliveryTime;
	}


	public void setWishDeliveryTime(String wishDeliveryTime) {
		this.wishDeliveryTime = wishDeliveryTime;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	public Set<OrderItem> getOrder() {
		return order;
	}


	public void setOrder(Set<OrderItem> order) {
		this.order = order;
	}


	public BigDecimal getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}




	
	
	
}
