package com.prs.business;

import javax.persistence.*;

@Entity
public class LineItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "ProductID")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "RequestID")
	private Request request;
	private String quantity;
	
	public LineItem() {
		super();
	}

	public LineItem(Product product, Request request, String quantity) {
		super();
		this.product = product;
		this.request = request;
		this.quantity = quantity;
	}

	public LineItem(int id, Product product, Request request, String quantity) {
		super();
		this.id = id;
		this.product = product;
		this.request = request;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setRole(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Credit [id=" + id + ", product=" + product + ", request=" + request + ", quantity=" + quantity + "]";
	}
	

}