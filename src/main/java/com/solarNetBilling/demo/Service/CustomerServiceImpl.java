package com.solarNetBilling.demo.Service;

import com.solarNetBilling.demo.DAO.CustomerDAO;
import com.solarNetBilling.demo.Model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl {

    private final CustomerDAO CustomerDAO;

    public CustomerServiceImpl(CustomerDAO CustomerDAO) {
        this.CustomerDAO = CustomerDAO;
    }

    public List<Customer> getAllCustomers() {
        return CustomerDAO.findAll();
    }

    public Customer getCustomerById(String id) {
        return CustomerDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found: " + id));
    }

    public String createCustomer(Customer Customer) {
        int rows = CustomerDAO.save(Customer);
        return rows > 0 ? "Customer created successfully" : "Creation failed";
    }

    public String updateCustomer(Customer Customer) {
        int rows = CustomerDAO.updateCustomer(Customer);
        return rows > 0 ? "Customer updated successfully" : "Update failed";
    }

    public String deleteCustomer(long custId) {
    	System.out.println("Inside CustomerServiceImpl controller:"+custId);
        int rows = CustomerDAO.deleteById(custId);
        System.out.println("Effected Rows:"+rows);
        return rows > 0 ? "Customer deleted successfully" : "Delete failed";
    }
}