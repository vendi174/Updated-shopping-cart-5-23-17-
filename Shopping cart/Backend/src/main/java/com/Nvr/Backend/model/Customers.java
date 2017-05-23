package com.Nvr.Backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Size;
import javax.persistence.*;

import org.hibernate.validator.constraints.*;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customers {
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty
	String firstname;
	@NotEmpty
	String lastname;
	@Column(unique = true, nullable = false)
	@NotEmpty
	@Email
	
	String email;
	@Size(min = 10, max = 10)
	int phone;

	@OneToOne
	@JoinColumn(name="user_id")
	Users users;
	
	
	@OneToOne
	@JoinColumn(name="billing_id")
	BillingAddress billingAddress;
	
	@OneToOne
	@JoinColumn(name="shipping_id")
	ShippingAddress shippingAddress;
	
	@OneToOne
	@JoinColumn(name="cart_id")
	Carts cart;
	
	
	
	

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Carts getCart() {
		return cart;
	}

	public void setCart(Carts cart) {
		this.cart = cart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
