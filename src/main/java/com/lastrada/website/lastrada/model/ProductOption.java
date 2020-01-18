package com.lastrada.website.lastrada.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ProductOption {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String productOptionDescription;
	private BigDecimal optionPrice;
	private BigDecimal optionPriceForSmall;
	private BigDecimal optionPriceForNormal;
	private BigDecimal optionPriceForFamily;
	private BigDecimal optionPriceForParty;
	private boolean isDefault;
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "productOptions")
	@JsonBackReference
	private Set<Product>product=new HashSet<>();
	public ProductOption() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public boolean isDefault() {
		return isDefault;
	}
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	public String getProductOptionDescription() {
		return productOptionDescription;
	}
	public void setProductOptionDescription(String productOptionDescription) {
		this.productOptionDescription = productOptionDescription;
	}
	public BigDecimal getOptionPrice() {
		return optionPrice;
	}
	public void setOptionPrice(BigDecimal optionPrice) {
		this.optionPrice = optionPrice;
	}
	public BigDecimal getOptionPriceForSmall() {
		return optionPriceForSmall;
	}
	public void setOptionPriceForSmall(BigDecimal optionPriceForSmall) {
		this.optionPriceForSmall = optionPriceForSmall;
	}
	public BigDecimal getOptionPriceForNormal() {
		return optionPriceForNormal;
	}
	public void setOptionPriceForNormal(BigDecimal optionPriceForNormal) {
		this.optionPriceForNormal = optionPriceForNormal;
	}
	public BigDecimal getOptionPriceForFamily() {
		return optionPriceForFamily;
	}
	public void setOptionPriceForFamily(BigDecimal optionPriceForFamily) {
		this.optionPriceForFamily = optionPriceForFamily;
	}
	public BigDecimal getOptionPriceForParty() {
		return optionPriceForParty;
	}
	public void setOptionPriceForParty(BigDecimal optionPriceForParty) {
		this.optionPriceForParty = optionPriceForParty;
	}
	
	public ProductOption(String productOptionDescription, BigDecimal optionPrice, BigDecimal optionPriceForSmall,
			BigDecimal optionPriceForNormal, BigDecimal optionPriceForFamily, BigDecimal optionPriceForParty) {
		super();
		this.productOptionDescription = productOptionDescription;
		this.optionPrice = optionPrice;
		this.optionPriceForSmall = optionPriceForSmall;
		this.optionPriceForNormal = optionPriceForNormal;
		this.optionPriceForFamily = optionPriceForFamily;
		this.optionPriceForParty = optionPriceForParty;
		this.isDefault=this.optionPriceForNormal!=null? true:false;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((optionPrice == null) ? 0 : optionPrice.hashCode());
		result = prime * result + ((optionPriceForFamily == null) ? 0 : optionPriceForFamily.hashCode());
		result = prime * result + ((optionPriceForNormal == null) ? 0 : optionPriceForNormal.hashCode());
		result = prime * result + ((optionPriceForParty == null) ? 0 : optionPriceForParty.hashCode());
		result = prime * result + ((optionPriceForSmall == null) ? 0 : optionPriceForSmall.hashCode());
		result = prime * result + ((productOptionDescription == null) ? 0 : productOptionDescription.hashCode());
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
		ProductOption other = (ProductOption) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (optionPrice == null) {
			if (other.optionPrice != null)
				return false;
		} else if (!optionPrice.equals(other.optionPrice))
			return false;
		if (optionPriceForFamily == null) {
			if (other.optionPriceForFamily != null)
				return false;
		} else if (!optionPriceForFamily.equals(other.optionPriceForFamily))
			return false;
		if (optionPriceForNormal == null) {
			if (other.optionPriceForNormal != null)
				return false;
		} else if (!optionPriceForNormal.equals(other.optionPriceForNormal))
			return false;
		if (optionPriceForParty == null) {
			if (other.optionPriceForParty != null)
				return false;
		} else if (!optionPriceForParty.equals(other.optionPriceForParty))
			return false;
		if (optionPriceForSmall == null) {
			if (other.optionPriceForSmall != null)
				return false;
		} else if (!optionPriceForSmall.equals(other.optionPriceForSmall))
			return false;
		if (productOptionDescription == null) {
			if (other.productOptionDescription != null)
				return false;
		} else if (!productOptionDescription.equals(other.productOptionDescription))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProductOption [id=" + id + ", productOptionDescription=" + productOptionDescription + ", optionPrice="
				+ optionPrice + ", optionPriceForSmall=" + optionPriceForSmall + ", optionPriceForNormal="
				+ optionPriceForNormal + ", optionPriceForFamily=" + optionPriceForFamily + ", optionPriceForParty="
				+ optionPriceForParty + "]";
	}

	

}
