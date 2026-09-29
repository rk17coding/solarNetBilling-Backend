package com.solarNetBilling.demo.DAO;


import com.solarNetBilling.demo.Model.GenerateBill;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenerateBillRowMapper implements RowMapper<GenerateBill> {

	@Override
	public GenerateBill mapRow(ResultSet rs, int rowNum) throws SQLException {
		GenerateBill g = new GenerateBill();
		g.setCustomerID(rs.getLong("customerID"));
		g.setCustomerType(rs.getString("customerType"));
		g.setPreviousReading(rs.getDouble("previousReading"));
		g.setCurrentReading(rs.getDouble("currentReading"));
		g.setUnitConsumed(rs.getDouble("unitConsumed"));
		g.setBillNo(rs.getLong("billNo"));
		g.setBillAmount(rs.getDouble("billAmount"));
		g.setBillDate(rs.getDate("billDate") != null ? rs.getDate("billDate").toLocalDate() : null);
		return g;
	}
}