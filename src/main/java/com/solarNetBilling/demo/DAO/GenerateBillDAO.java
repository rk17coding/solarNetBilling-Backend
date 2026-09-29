package com.solarNetBilling.demo.DAO;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.solarNetBilling.demo.Model.Customer;
import com.solarNetBilling.demo.Model.GenerateBill;

@Repository
public class GenerateBillDAO {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerBillDAO.class);
	
    private final JdbcTemplate jdbcTemplate;

	public GenerateBillDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
    // READ ALL
	public List<GenerateBill> findAll() {
		log.info("inside findAll()");
		String sql = "SELECT * FROM customerBill;";
		//String sql = "SELECT customerId,customerType, previousReading, currentReading, (currentReading - previousReading) AS unitConsumed, NULL AS billNo, NULL AS billAmount, NULL AS billDate  FROM customerinfo;";
		log.debug(sql);
		return jdbcTemplate.query(sql, new GenerateBillRowMapper());
	}
	
	// Create New Record for Generate bill
    public int create(GenerateBill g) {
        String sql = "INSERT INTO customerBill (customerId, customerType, previousReading, currentReading, unitConsumed, billNo, billAmount, billDate) VALUES (?, ?, ?, ?,?, ?, ?,?);";
        return jdbcTemplate.update(sql, g.getCustomerID(), g.getCustomerType(), g.getPreviousReading(), g.getCurrentReading(), g.getUnitConsumed(), g.getBillNo(), g.getBillAmount(), g.getBillDate());
    }
    
    public int update(GenerateBill g) {
    	String sql = "UPDATE customerBill SET unitConsumed = ?, billNo = ?, billAmount = ?, billDate = ? WHERE customerId = ?";
    	log.debug(sql, g.getCustomerID());
    	return jdbcTemplate.update(sql, g.getUnitConsumed(), g.getBillNo(), g.getBillAmount(), g.getBillDate(), g.getCustomerID());
    }

    public Optional<GenerateBill> findById(long custId) {
        String sql = "SELECT * FROM customerBill WHERE customerId = ?";
        List<GenerateBill> result = jdbcTemplate.query(sql, new GenerateBillRowMapper(), custId);
        return result.stream().findFirst();
    }

	public int updateBill(GenerateBill g) {
	        String sql = "UPDATE customerBill SET customerType=?, previousReading=?, currentReading=?, unitConsumed=?, billAmount=? WHERE customerId=?";
	        return jdbcTemplate.update(sql, g.getCustomerType(), g.getPreviousReading(), g.getCurrentReading(), g.getUnitConsumed(), g.getBillAmount(), g.getCustomerID());
	    }

		public int deleteById(long custId) {
			log.info("Inside GenerateBillDAO:deleteById" + custId);

			String sql = "DELETE FROM customerBill WHERE customerId = ?";

			return jdbcTemplate.update(sql, custId);

		}
    
    
	
	
	
}