package com.lastrada.website.lastrada.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductAddition{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String additionDescription;
	private BigDecimal additionPrice;
	private BigDecimal additionsPriceForSmall;
	private BigDecimal additionsPriceForNormal;
	private BigDecimal additionsPriceForFamily;
	private BigDecimal additionsPriceForParty;
	
	
	
	public ProductAddition(String additionDescription, BigDecimal additionPrice, BigDecimal additionsPriceForSmall,
			BigDecimal additionsPriceForNormal, BigDecimal additionsPriceForFamily, BigDecimal additionsPriceForParty) {
		super();
		this.additionDescription = additionDescription;
		this.additionPrice = additionPrice;
		this.additionsPriceForSmall = additionsPriceForSmall;
		this.additionsPriceForNormal = additionsPriceForNormal;
		this.additionsPriceForFamily = additionsPriceForFamily;
		this.additionsPriceForParty = additionsPriceForParty;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdditionDescription() {
		return additionDescription;
	}
	public void setAdditionDescription(String additionDescription) {
		this.additionDescription = additionDescription;
	}
	public BigDecimal getAdditionPrice() {
		return additionPrice;
	}
	public void setAdditionPrice(BigDecimal additionPrice) {
		this.additionPrice = additionPrice;
	}
	public BigDecimal getAdditionsPriceForSmall() {
		return additionsPriceForSmall;
	}
	public void setAdditionsPriceForSmall(BigDecimal additionsPriceForSmall) {
		this.additionsPriceForSmall = additionsPriceForSmall;
	}
	public BigDecimal getAdditionsPriceForNormal() {
		return additionsPriceForNormal;
	}
	public void setAdditionsPriceForNormal(BigDecimal additionsPriceForNormal) {
		this.additionsPriceForNormal = additionsPriceForNormal;
	}
	public BigDecimal getAdditionsPriceForFamily() {
		return additionsPriceForFamily;
	}
	public void setAdditionsPriceForFamily(BigDecimal additionsPriceForFamily) {
		this.additionsPriceForFamily = additionsPriceForFamily;
	}
	public BigDecimal getAdditionsPriceForParty() {
		return additionsPriceForParty;
	}
	public void setAdditionsPriceForParty(BigDecimal additionsPriceForParty) {
		this.additionsPriceForParty = additionsPriceForParty;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionDescription == null) ? 0 : additionDescription.hashCode());
		result = prime * result + ((additionPrice == null) ? 0 : additionPrice.hashCode());
		result = prime * result + ((additionsPriceForFamily == null) ? 0 : additionsPriceForFamily.hashCode());
		result = prime * result + ((additionsPriceForNormal == null) ? 0 : additionsPriceForNormal.hashCode());
		result = prime * result + ((additionsPriceForParty == null) ? 0 : additionsPriceForParty.hashCode());
		result = prime * result + ((additionsPriceForSmall == null) ? 0 : additionsPriceForSmall.hashCode());
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
		ProductAddition other = (ProductAddition) obj;
		if (additionDescription == null) {
			if (other.additionDescription != null)
				return false;
		} else if (!additionDescription.equals(other.additionDescription))
			return false;
		if (additionPrice == null) {
			if (other.additionPrice != null)
				return false;
		} else if (!additionPrice.equals(other.additionPrice))
			return false;
		if (additionsPriceForFamily == null) {
			if (other.additionsPriceForFamily != null)
				return false;
		} else if (!additionsPriceForFamily.equals(other.additionsPriceForFamily))
			return false;
		if (additionsPriceForNormal == null) {
			if (other.additionsPriceForNormal != null)
				return false;
		} else if (!additionsPriceForNormal.equals(other.additionsPriceForNormal))
			return false;
		if (additionsPriceForParty == null) {
			if (other.additionsPriceForParty != null)
				return false;
		} else if (!additionsPriceForParty.equals(other.additionsPriceForParty))
			return false;
		if (additionsPriceForSmall == null) {
			if (other.additionsPriceForSmall != null)
				return false;
		} else if (!additionsPriceForSmall.equals(other.additionsPriceForSmall))
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
		return "ProductAddition [id=" + id + ", additionDescription=" + additionDescription + ", additionPrice="
				+ additionPrice + ", additionsPriceForSmall=" + additionsPriceForSmall + ", additionsPriceForNormal="
				+ additionsPriceForNormal + ", additionsPriceForFamily=" + additionsPriceForFamily
				+ ", additionsPriceForParty=" + additionsPriceForParty + "]";
	}

	
	
	
	
}