package com.forhad.ims.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "sale")
public class Sale {

	// Creating fields

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cId")
	private long cId;

	@Column(name = "cName")
	private String cName;

	@Column(name = "category")
	private String category;

	@Column(name = "color")
	private String color;

	@Column(name = "price")
	private long price;

	@Column(name = "quantity")
	private long quantity;

	@Column(name = "size")
	private String size;

	@Column(name = "date")
	private String date;

	// generating getters and setters
	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	// to strings

	@Override
	public String toString() {
		return "Sale [cName=" + cName + ", category=" + category + ", color=" + color + ", price=" + price
				+ ", quantity=" + quantity + ", size=" + size + ", date=" + date + "]";
	}

}
