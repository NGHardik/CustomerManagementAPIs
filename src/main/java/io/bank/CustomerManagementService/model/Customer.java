package io.bank.CustomerManagementService.model;

import jakarta.persistence.*;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	private Integer id;
	private String name;
	private String address;
	private String gender;
	
	public Customer() {
		super();
		// TODO Auto-gendererated constructor stub
	}
	public Customer(Integer id, String name, String address, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", name=" + name + ", address=" + address + ", gender=" + gender + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public String getgender() {
		return gender;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
}

