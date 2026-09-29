package com.solarNetBilling.demo.DAO;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.solarNetBilling.demo.Model.DownloadBill;

@Repository
public class DownloadBillDAO {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerBillDAO.class);
	
    private final JdbcTemplate jdbcTemplate;

	public DownloadBillDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
    public List<DownloadBill> findById(long custId) {
        String sql = "SELECT c.customerId, c.customerName, c.customerContactDetails, c.customerEmailId, c.customerAddress, g.customerType, g.previousReading, g.currentReading, g.unitConsumed, g.billNo, g.billAmount, g.billDate\r\n"
        		+ "FROM customerinfo c\r\n"
        		+ "INNER JOIN customerBill g \r\n"
        		+ "    ON c.customerId = g.customerId\r\n"
        		+ "    WHERE c.customerid = ?;";
        List<DownloadBill> result = jdbcTemplate.query(sql, new DownloadBillRowMapper(), custId);
        return result;
    }
	
	
	
	
	
	
	
}