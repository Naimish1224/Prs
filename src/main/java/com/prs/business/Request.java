package com.prs.business;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userId;
	private String description;
	private String justification;
	private LocalDateTime dateNeeded;
	private String deliveryMode;
	private String status;
	private double total;
	private LocalDateTime submitDate;
	private String reason;
	public Request(int id, String userId, String description, String justification, LocalDateTime dateNeeded,
			String deliveryMode, String status, double total, LocalDateTime submitDate, String reason) {
		super();
		this.id = id;
		this.userId = userId;
		this.description = description;
		this.justification = justification;
		this.dateNeeded = dateNeeded;
		this.deliveryMode = deliveryMode;
		this.status = status;
		this.total = total;
		this.submitDate = submitDate;
		this.reason = reason;
	}
	public Request() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public LocalDateTime getDateNeeded() {
		return dateNeeded;
	}
	public void setDateNeeded(LocalDateTime dateNeeded) {
		this.dateNeeded = dateNeeded;
	}
	public String getDeliveryMode() {
		return deliveryMode;
	}
	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public LocalDateTime getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(LocalDateTime submitDate) {
		this.submitDate = submitDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Request [id=" + id + ", userId=" + userId + ", description=" + description + ", justification="
				+ justification + ", dateNeeded=" + dateNeeded + ", deliveryMode=" + deliveryMode + ", status=" + status
				+ ", total=" + total + ", submitDate=" + submitDate + ", reason=" + reason + "]";
	}

}
