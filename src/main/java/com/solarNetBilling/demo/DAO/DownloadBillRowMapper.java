package com.solarNetBilling.demo.DAO;

import com.solarNetBilling.demo.Model.DownloadBill;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DownloadBillRowMapper implements RowMapper<DownloadBill> {

    @Override
    public DownloadBill mapRow(ResultSet rs, int rowNum) throws SQLException {
    	DownloadBill d = new DownloadBill();
    	d.setCustomerID(rs.getString("customerID"));
    	d.setCustomerName(rs.getString("customerName"));
    	d.setCustomerContactDetails(rs.getString("customerContactDetails"));
    	d.setCustomerEmailId(rs.getString("customerEmailId"));
    	d.setCustomerAddress(rs.getString("customerAddress"));
    	d.setCustomerType(rs.getString("customerType"));
    	d.setPreviousReading(rs.getDouble("previousReading"));
    	d.setCurrentReading(rs.getDouble("currentReading"));
		d.setUnitConsumed(rs.getDouble("unitConsumed"));
		d.setBillNo(rs.getLong("billNo"));
		d.setBillAmount(rs.getDouble("billAmount"));
		d.setBillDate(rs.getDate("billDate") != null ? rs.getDate("billDate").toLocalDate() : null);
        return d;
    }
}