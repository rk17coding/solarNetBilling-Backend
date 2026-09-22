package com.solarNetBilling.demo.DAO;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.solarNetBilling.demo.Model.Customer;
import com.solarNetBilling.demo.Model.CustomerBill;
import com.solarNetBilling.demo.Service.CalcUnitConsumedService;

/**
 * @Repository is a specialization of @Component that marks a class as belonging
 *             to the data access layer (DAL). Unlike @Service and @Controller,
 *             it has one extra framework behavior — it automatically translates
 *             persistence-related exceptions into Spring's DataAccessException
 *             hierarchy.
 * 
 */
@Repository
public class CustomerBillDAO {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerBillDAO.class);
	
    private final JdbcTemplate jdbcTemplate;

    // Spring auto-injects JdbcTemplate (configured from application.properties)
    public CustomerBillDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
    // READ ALL
	public List<CustomerBill> findAll() {
		log.info("inside findAll()");
		String sql = "SELECT customerId,customerType, previousReading, currentReading, (currentReading - previousReading) AS unitConsumed, NULL AS billNo, NULL AS billAmount FROM customerinfo;";
		log.debug(sql);
		return jdbcTemplate.query(sql, new CustomerBillRowMapper());
	}


//    // READ ONE
//    public Optional<Customer> findById(String id) {
//        String sql = "SELECT * FROM calculateBill WHERE customerId = ?";
//        List<Customer> result = jdbcTemplate.query(sql, new CustomerRowMapper(), id);
//        return result.stream().findFirst();
//    }
    

	
	
}