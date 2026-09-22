package com.solarNetBilling.demo.DAO;

import com.solarNetBilling.demo.Model.CustomerBill;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerBillRowMapper implements RowMapper<CustomerBill> {

	@Override
	public CustomerBill mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerBill c = new CustomerBill();
		c.setCustomerID(rs.getLong("customerID"));
		c.setCustomerType(rs.getString("customerType"));
		c.setPreviousReading(rs.getDouble("previousReading"));
		c.setCurrentReading(rs.getDouble("currentReading"));
		c.setUnitConsumed(rs.getDouble("unitConsumed"));
		c.setBillNo(rs.getLong("billNo"));
		c.setBillAmount(rs.getDouble("billAmount"));
		return c;
	}
}