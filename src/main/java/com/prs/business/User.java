package com.prs.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String user;
	private String password;
	private String firstname;
	private String lastname;
	private String Phone;
	private String email;
	private int reviewer;
	private int admin;
	public User(String user, String password, String firstname, String lastname, String phone, String email,
			int reviewer, int admin) {
		super();
		this.user = user;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		Phone = phone;
		this.email = email;
		this.reviewer = reviewer;
		this.admin = admin;
	}
	public User() {
		super();
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getReviewer() {
		return reviewer;
	}
	public void setReviewer(int reviewer) {
		this.reviewer = reviewer;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "User [user=" + user + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", Phone=" + Phone + ", email=" + email + ", reviewer=" + reviewer + ", admin=" + admin + "]";
	}
	
}
