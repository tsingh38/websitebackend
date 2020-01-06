package com.lastrada.website.lastrada.pojo;



import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lastrada.website.lastrada.model.ProductAddition;
import com.lastrada.website.lastrada.model.ProductOption;



public class ProductPOJO {

	
	private Long id;
	private String description;
	private String productCategory;
	private String optionDescription;
	private BigDecimal productBasePrice;
	 @JsonBackReference
	private Set<ProductAddition>productAdditions=new HashSet<>();
	 @JsonBackReference
	private Set<ProductOption>productOptions=new HashSet<>();
	
	
public ProductPOJO() {}
	


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
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", optionDescription=" + optionDescription
				+ ", productBasePrice=" + productBasePrice + ", productAdditions=" + productAdditions
				+ ", productOptions=" + productOptions + "]";
	}
	
	
	
}
