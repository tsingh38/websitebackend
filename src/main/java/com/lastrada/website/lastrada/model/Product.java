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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String description;
	private String productCategory;
	private String optionDescription;
	private BigDecimal productBasePrice;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="product_productaddition",joinColumns=@JoinColumn(name="Product_id"), inverseJoinColumns=@JoinColumn(name="ProductAddition_id"))
	private Set<ProductAddition>productAdditions=new HashSet<>();
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="product_productoption",joinColumns=@JoinColumn(name="Product_id"), inverseJoinColumns=@JoinColumn(name="ProductOption_id"))
	private Set<ProductOption>productOptions=new HashSet<>();
	
	
	public Product() {}
	public Product(String description, ProductCategory productCategory,String optionDescription, BigDecimal productBasePrice) {
		super();
		this.description = description;
		this.productCategory=productCategory.toString();
		this.optionDescription = optionDescription;
		this.productBasePrice = productBasePrice;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public String getOptionDescription() {
		return optionDescription;
	}


	public void setOptionDescription(String optionDescription) {
		this.optionDescription = optionDescription;
	}


	public BigDecimal getProductBasePrice() {
		return productBasePrice;
	}


	public void setProductBasePrice(BigDecimal productBasePrice) {
		this.productBasePrice = productBasePrice;
	}


	public Set<ProductAddition> getProductAdditions() {
		return productAdditions;
	}


	public void setProductAdditions(Set<ProductAddition> productAdditions) {
		this.productAdditions = productAdditions;
	}


	public Set<ProductOption> getProductOptions() {
		return productOptions;
	}


	public void setProductOptions(Set<ProductOption> productOptions) {
		this.productOptions = productOptions;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((optionDescription == null) ? 0 : optionDescription.hashCode());
		result = prime * result + ((productAdditions == null) ? 0 : productAdditions.hashCode());
		result = prime * result + ((productBasePrice == null) ? 0 : productBasePrice.hashCode());
		result = prime * result + ((productOptions == null) ? 0 : productOptions.hashCode());
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
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (optionDescription == null) {
			if (other.optionDescription != null)
				return false;
		} else if (!optionDescription.equals(other.optionDescription))
			return false;
		if (productAdditions == null) {
			if (other.productAdditions != null)
				return false;
		} else if (!productAdditions.equals(other.productAdditions))
			return false;
		if (productBasePrice == null) {
			if (other.productBasePrice != null)
				return false;
		} else if (!productBasePrice.equals(other.productBasePrice))
			return false;
		if (productOptions == null) {
			if (other.productOptions != null)
				return false;
		} else if (!productOptions.equals(other.productOptions))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", optionDescription=" + optionDescription
				+ ", productBasePrice=" + productBasePrice + ", productAdditions=" + productAdditions
				+ ", productOptions=" + productOptions + "]";
	}
	
	
	
}
