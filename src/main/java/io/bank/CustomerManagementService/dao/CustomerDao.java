package io.bank.CustomerManagementService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.bank.CustomerManagementService.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

}