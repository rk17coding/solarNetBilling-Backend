package com.solarNetBilling.demo.DAO;

import com.solarNetBilling.demo.Model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Customer c = new Customer();
    	c.setCustomerID(rs.getString("customerID"));
    	c.setCustomerName(rs.getString("customerName"));
    	c.setCustomerContactDetails(rs.getString("customerContactDetails"));
    	c.setCustomerEmailId(rs.getString("customerEmailId"));
    	c.setCustomerType(rs.getString("customerType"));
    	c.setCustomerAddress(rs.getString("customerAddress"));
    	c.setPreviousReading(rs.getDouble("previousReading"));
    	c.setCurrentReading(rs.getDouble("currentReading"));
        
        return c;
    }
}