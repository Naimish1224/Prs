package com.prs.business;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String vendorId;
	private String partnumber;
	private String productName;
	private Double price;
	private String unit;
	private String photopath;
	public Product(String vendorId, String partnumber, String productName, Double price, String unit,
			String photopath) {
		super();
		this.vendorId = vendorId;
		this.partnumber = partnumber;
		this.productName = productName;
		this.price = price;
		this.unit = unit;
		this.photopath = photopath;
	}
	public Product() {
		super();
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getPartnumber() {
		return partnumber;
	}
	public void setPartnumber(String partnumber) {
		this.partnumber = partnumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPhotopath() {
		return photopath;
	}
	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
	@Override
	public String toString() {
		return "Product [vendorId=" + vendorId + ", partnumber=" + partnumber + ", productName=" + productName
				+ ", price=" + price + ", unit=" + unit + ", photopath=" + photopath + "]";
	}
	
}
