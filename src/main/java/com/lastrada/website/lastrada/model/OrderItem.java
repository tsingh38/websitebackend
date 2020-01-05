package com.lastrada.website.lastrada.model;

import java.math.BigDecimal;
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
public class OrderItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
	private ProductCategory orderItemCategory;
	private Long quantity;
	private BigDecimal orderItemTotalPrice;
	@OneToMany
	@JoinTable(name="orderItem_productaddition",joinColumns=@JoinColumn(name="orderItem_id"), inverseJoinColumns=@JoinColumn(name="ProductAddition_id"))
	private Set<ProductAddition> listOfAdditions=new HashSet<>();
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
	private ProductOption productOption;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ProductCategory getOrderItemCategory() {
		return orderItemCategory;
	}
	public void setOrderItemCategory(ProductCategory orderItemCategory) {
		this.orderItemCategory = orderItemCategory;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getOrderItemTotalPrice() {
		return orderItemTotalPrice;
	}
	public void setOrderItemTotalPrice(BigDecimal orderItemTotalPrice) {
		this.orderItemTotalPrice = orderItemTotalPrice;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listOfAdditions == null) ? 0 : listOfAdditions.hashCode());
		result = prime * result + ((orderItemCategory == null) ? 0 : orderItemCategory.hashCode());
		result = prime * result + ((orderItemTotalPrice == null) ? 0 : orderItemTotalPrice.hashCode());
		result = prime * result + ((productOption == null) ? 0 : productOption.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listOfAdditions == null) {
			if (other.listOfAdditions != null)
				return false;
		} else if (!listOfAdditions.equals(other.listOfAdditions))
			return false;
		if (orderItemCategory == null) {
			if (other.orderItemCategory != null)
				return false;
		} else if (!orderItemCategory.equals(other.orderItemCategory))
			return false;
		if (orderItemTotalPrice == null) {
			if (other.orderItemTotalPrice != null)
				return false;
		} else if (!orderItemTotalPrice.equals(other.orderItemTotalPrice))
			return false;
		if (productOption == null) {
			if (other.productOption != null)
				return false;
		} else if (!productOption.equals(other.productOption))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderItemCategory=" + orderItemCategory + ", quantity=" + quantity
				+ ", orderItemTotalPrice=" + orderItemTotalPrice + ", listOfAdditions=" + listOfAdditions
				+ ", productOption=" + productOption + "]";
	}
	public OrderItem(ProductCategory orderItemCategory, Long quantity, BigDecimal orderItemTotalPrice) {
		super();
		this.orderItemCategory = orderItemCategory;
		this.quantity = quantity;
		this.orderItemTotalPrice = orderItemTotalPrice;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
