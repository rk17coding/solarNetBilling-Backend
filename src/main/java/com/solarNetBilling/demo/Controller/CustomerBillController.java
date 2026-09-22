package com.solarNetBilling.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.solarNetBilling.demo.Model.CustomerBill;
import com.solarNetBilling.demo.Service.CalcUnitConsumedService;



/** @RestController is a specialized @Component that combines @Controller
 *                 + @ResponseBody, used to build RESTful HTTP endpoints. Every
 *                 method return value is automatically serialized to JSON (or
 *                 XML) and written directly to the HTTP response. */

@RestController
public class CustomerBillController{

	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CalcUnitConsumedService service;
	
	@GetMapping("/customerbillingUnitConsumed")
	public List<CustomerBill> calculateCustomerbill() {
		log.info("Inside calculateCustomerbill() ");
		return service.generateAllCustomerBill();
	}
	
}