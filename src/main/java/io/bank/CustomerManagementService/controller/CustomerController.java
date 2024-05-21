package io.bank.CustomerManagementService.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import io.bank.CustomerManagementService.model.Customer;
import io.bank.CustomerManagementService.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerService ser;

	@GetMapping("/get")
	public List<Customer> getCus() {
		return ser.getCustomers();
	}

	@PostMapping("/add")
	public boolean createCustomer(@RequestBody Customer ent) {
		
		return ser.createCustomer(ent);

	}
	
	 @GetMapping("/getById/{id}")
	    public Customer getCustomerById(@PathVariable Integer id) {
	        return ser.getCustomerById(id);
	    }
	 @DeleteMapping("/delete/{id}")
	 public boolean deleteCustomerById(@PathVariable Integer id) {
	     return ser.deleteCustomerById(id);
	 }
	    @PutMapping("/update/{id}")
	    public boolean updateCustomer(@PathVariable Integer id, @RequestBody Customer entity) {
	        // Ensure the ID in the path matches the ID in the request body
	        if (!id.equals(entity.getId())) {
	            return false;
	        }

	        return ser.updateCustomer(entity);
	    }
}
