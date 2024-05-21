package io.bank.CustomerManagementService.service;

import java.util.*;

import io.bank.CustomerManagementService.model.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	public boolean createCustomer(Customer entity);
	Customer getCustomerById(Integer id);
	boolean deleteCustomerById(Integer id);
	boolean updateCustomer(Customer entity);
}
