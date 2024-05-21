package io.bank.CustomerManagementService.service;

import java.util.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.RestTemplate;

import io.bank.CustomerManagementService.dao.CustomerDao;
import io.bank.CustomerManagementService.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	private RestTemplate restTemplate;
	
//	private RestTemplate restTemplate = new RestTemplate();
	
	private static final String ACCOUNT_SERVICE_URL = "http://APIGATEWAY/accountservice/api/accounts/delete-account/";

	@Override
	public List<Customer> getCustomers() {
		try {
			return customerDao.findAll();
		} catch (Exception e) {
			Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
			log.error("Error in getCustomers: " + e.getMessage(), e);
			return null;
		}
	}

	@Override
	public boolean createCustomer(Customer entity) {
		try {
			entity = customerDao.save(entity);
			return true;
		} catch (Exception e) {
			Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
			log.error("Error in createCustomer: " + e.getMessage(), e);
			return false;
		}
	}

	@Override
	public Customer getCustomerById(Integer id) {
	    try {
	        Optional<Customer> optionalCustomer = customerDao.findById(id);

	        if (optionalCustomer.isPresent()) {
	            return optionalCustomer.get();
	        } else {
	            Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	            log.error("Customer not found for ID: " + id);
	            return null;
	        }
	    } catch (Exception e) {
	        Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	        log.error("Error in getCustomerById: " + e.getMessage(), e);
	        return null;
	    }
	}


	@Override
	public boolean deleteCustomerById(Integer id) {
		try {
			if (customerDao.existsById(id)) {
				customerDao.deleteById(id);
				restTemplate.delete(ACCOUNT_SERVICE_URL + id);
				return true;
			} else {
				Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
				log.error("Customer not found for deletion: " + id);
				return false;
			}
		} catch (Exception e) {
			Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
			log.error("Error in deleteCustomerById: " + e.getMessage(), e);
			return false;
		}
	}

	@Override
	public boolean updateCustomer(Customer entity) {
		try {
			if (customerDao.existsById(entity.getId())) {
				customerDao.save(entity);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
			log.error("Error in updateCustomer: " + e.getMessage(), e);
			return false;
		}
	}

}

