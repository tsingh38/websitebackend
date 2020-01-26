package com.lastrada.website.lastrada.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToOne
    @JoinColumn(name="ORDER_PRODUCT_ID")
	private Product product;
	private Long quantity;
	private BigDecimal totalPrice;
	@ManyToMany( fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinTable(name="orderItem_productaddition",joinColumns=@JoinColumn(name="orderItem_id"), inverseJoinColumns=@JoinColumn(name="ProductAddition_id"))
	private Set<ProductAddition> listOfAdditions=new HashSet<>();
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
	private ProductOption productOption;
	
	public OrderItem() {}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set<ProductAddition> getListOfAdditions() {
		return listOfAdditions;
	}

	public void setListOfAdditions(Set<ProductAddition> listOfAdditions) {
		this.listOfAdditions = listOfAdditions;
	}

	public ProductOption getProductOption() {
		return productOption;
	}

	public void setProductOption(ProductOption productOption) {
		this.productOption = productOption;
	}
	
	
	
	
}
