package com.solarNetBilling.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solarNetBilling.demo.Model.GenerateBill;
import com.solarNetBilling.demo.Service.GenerateBillService;

@RestController
@RequestMapping("/generate")
public class GenerateBillController{
	
	private static final Logger log = LoggerFactory.getLogger(GenerateBillController.class);
	
	@Autowired
	GenerateBillService service;
	
	@GetMapping("/billInformation")
	public List<GenerateBill> generateBill() {
		log.info("Inside generateBill() ");
		return service.generateBillInfo();
	}
	
	 @GetMapping("/allCustomerBill")
	    public List<GenerateBill> getAllCustomerBill() {
		 log.info("Inside getAllCustomerBill()");
		 return service.generateAllCustBill();
	 
	 }
	
//	@GetMapping("/generateBillNumner")
//	public List<GenerateBill> generateBillNumber() {
//		log.info("Inside generateBillNumber() ");
//		return service.generateBillNumber();
//	}
//	
	
	
}