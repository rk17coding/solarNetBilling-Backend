package com.solarNetBilling.demo.Service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solarNetBilling.demo.DAO.CustomerBillDAO;
import com.solarNetBilling.demo.Model.CustomerBill;

/**
 * @Service is a specialization of @Component that marks a class as belonging to
 *          the business logic / service layer. Functionally identical
 *          to @Component — the difference is purely semantic, signaling intent
 *          and improving readability.
 * 
 */
@Service
public class CalcUnitConsumedService{
	
	private static final Logger log = LoggerFactory.getLogger(CalcUnitConsumedService.class);
	
	@Autowired
	CustomerBillDAO CustomerBillDAO;
   
	public List<CustomerBill> generateAllCustomerBill() {
    	log.debug("inside generateAllCustomerBill()");
        return CustomerBillDAO.findAll();
    }
	
}