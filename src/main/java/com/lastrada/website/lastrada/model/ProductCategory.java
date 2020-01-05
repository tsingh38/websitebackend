package com.lastrada.website.lastrada.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String ProductCategoryDescription;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductCategoryDescription() {
		return ProductCategoryDescription;
	}
	public void setProductCategoryDescription(String productCategoryDescription) {
		ProductCategoryDescription = productCategoryDescription;
	}
	public ProductCategory(String productCategoryDescription) {
		super();
		ProductCategoryDescription = productCategoryDescription;
	}
	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ProductCategoryDescription == null) ? 0 : ProductCategoryDescription.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProductCategory other = (ProductCategory) obj;
		if (ProductCategoryDescription == null) {
			if (other.ProductCategoryDescription != null)
				return false;
		} else if (!ProductCategoryDescription.equals(other.ProductCategoryDescription))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", ProductCategoryDescription=" + ProductCategoryDescription + "]";
	}
	
	
	
}
