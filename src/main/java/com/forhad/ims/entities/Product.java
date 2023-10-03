package com.forhad.ims.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "product")
public class Product {

	// creating fields
	@Id
//	@Column(name = "pId")
	private long pId;
	@Column(name = "pCategory")
	private String pCategory;
	@Column(name = "pColor")
	private String pColor;
	@Column(name = "pPrice")
	private long pPrice;
	@Column(name = "pQuantity")
	private long pQuantity;
	@Column(name = "pSize")
	private String pSize;

	// creating getter and setters
	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getpColor() {
		return pColor;
	}

	public void setpColor(String pColor) {
		this.pColor = pColor;
	}

	public long getpPrice() {
		return pPrice;
	}

	public void setpPrice(long pPrice) {
		this.pPrice = pPrice;
	}

	public long getpQuantity() {
		return pQuantity;
	}

	public void setpQuantity(long pQuantity) {
		this.pQuantity = pQuantity;
	}

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	// creating tosString
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pCategory=" + pCategory + ", pColor=" + pColor + ", pPrice=" + pPrice
				+ ", pQuantity=" + pQuantity + ", pSize=" + pSize + "]";
	}

}
