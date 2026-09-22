package com.solarNetBilling.demo.DAO;

import com.solarNetBilling.demo.Model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAO {

    private final JdbcTemplate jdbcTemplate;

    // Spring auto-injects JdbcTemplate (configured from application.properties)
    public CustomerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // READ ALL
    public List<Customer> findAll() {
        String sql = "SELECT * FROM customerinfo";
        return jdbcTemplate.query(sql, new CustomerRowMapper());
    }

    // READ ONE
    public Optional<Customer> findById(String id) {
        String sql = "SELECT * FROM customerinfo WHERE customerId = ?";
        List<Customer> result = jdbcTemplate.query(sql, new CustomerRowMapper(), id);
        return result.stream().findFirst();
    }

    // CREATE
    public int save(Customer c) {
        String sql = "INSERT INTO customerinfo (customerId, customerName, customerContactDetails, customerEmailId, customerType, customerAddress, previousReading, currentReading) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, c.getCustomerID(), c.getCustomerName(), c.getCustomerContactDetails(), c.getCustomerEmailId(),c.getCustomerType(), c.getCustomerAddress(), c.getPreviousReading(), c.getCurrentReading());
    }

    // UPDATE
    public int updateCustomer(Customer c) {
        String sql = "UPDATE customerinfo SET customerName=?, customerContactDetails=?, customerEmailId=?, customerType=?, customerAddress=?, previousReading=?, currentReading=? WHERE customerId=?";
        return jdbcTemplate.update(sql, c.getCustomerName(), c.getCustomerContactDetails(), c.getCustomerEmailId(), c.getCustomerType(), c.getCustomerAddress(), c.getPreviousReading(), c.getCurrentReading(), c.getCustomerID() );
    }
    
    //UPDATE Meter Reading
    public int updateMeterReading(Customer c) {
        String sql = "UPDATE customerinfo SET currentReading=?, previousReading=?  WHERE customerId=?";
        return jdbcTemplate.update(sql, c.getCurrentReading(), c.getPreviousReading(), c.getCustomerID() );
    }

    // DELETE
    public int deleteById(long custId) {
    	System.out.println("Inside CustomerDAO"+ custId);
    	
        String sql = "DELETE FROM customerinfo WHERE customerId = ?";
        
        return jdbcTemplate.update(sql, custId);
        
    }
}