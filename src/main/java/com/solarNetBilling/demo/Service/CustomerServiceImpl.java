package com.solarNetBilling.demo.Service;

import com.solarNetBilling.demo.DAO.CustomerDAO;
import com.solarNetBilling.demo.Model.Customer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl {
	
	private static final Logger logger=LogManager.getLogger(CustomerServiceImpl.class);

    private final CustomerDAO CustomerDAO;

    public CustomerServiceImpl(CustomerDAO CustomerDAO) {
        this.CustomerDAO = CustomerDAO;
        logger.info("Inside CustomerServiceImpl Constructor");
    }

    public List<Customer> getAllCustomers() {
    	logger.info("Inside getAllCustomers()");
        return CustomerDAO.findAll();
    }

    public Customer getCustomerById(String id) {
        logger.info("Inside getCustomerById(), id: ", id);
        return CustomerDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found: " + id));
    }

    public String createCustomer(Customer Customer) {
    	logger.info("Inside createCustomer()");
        int rows = CustomerDAO.save(Customer);
        logger.info("No of rows effected:", rows);
        return rows > 0 ? "Customer created successfully" : "Creation failed";
    }

    public String updateCustomer(Customer Customer) {
        int rows = CustomerDAO.updateCustomer(Customer);
        System.out.println("Effected Updated Rows:"+rows);
        return rows > 0 ? "Customer updated successfully" : "Update failed";
    }

    public String deleteCustomer(long custId) {
    	System.out.println("Inside CustomerServiceImpl controller:"+custId);
        int rows = CustomerDAO.deleteById(custId);
        System.out.println("Effected Rows:"+rows);
        return rows > 0 ? "Customer deleted successfully" : "Delete failed";
    }
}