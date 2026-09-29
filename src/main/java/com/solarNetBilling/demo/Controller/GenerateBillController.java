package com.solarNetBilling.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solarNetBilling.demo.Model.Customer;
import com.solarNetBilling.demo.Model.GenerateBill;
import com.solarNetBilling.demo.Service.GenerateBillService;

@RestController
@RequestMapping("/generate")
public class GenerateBillController {

	private static final Logger log = LoggerFactory.getLogger(GenerateBillController.class);

	@Autowired
	GenerateBillService service;

	@GetMapping("/billInformation")
	public List<GenerateBill> generateBill() {
		log.info("Inside generateBill() ");
		return service.generateBillInfo();
	}

	@GetMapping("/allCustomerBill")
	public String getAllCustomerBill() {
		log.info("Inside getAllCustomerBill()");
		int n = service.generateAllCustBill();
		String string = "No of bills claculated and updated : ";
		return string + n;

	}

	@GetMapping("/showAllCustomerBill")
	public List<GenerateBill> showAllCustomerBill() {
		log.info("Inside showAllCustomerBill()");
		return service.generateCustomerRecord();

	}

	@PostMapping("/createCustomerBill")
	public String addAllCustomer() {
		int count = service.createGenerateBillRecord();
		String string = "No of rows updated are: ";
		return string + count;
	}

//	@GetMapping("/generateBillNumner")
//	public List<GenerateBill> generateBillNumber() {
//		log.info("Inside generateBillNumber() ");
//		return service.generateBillNumber();
//	}
//	

	@GetMapping("/bill/{custId}")
	public GenerateBill generateBillById(@PathVariable long custId) {
		log.info("Inside generateBillById() ");
		return service.generateBillById(custId);
	}
	
	@PutMapping("/updateBill")
	public String updateBill(@RequestBody GenerateBill generateBill) {
		String result = service.updateBill(generateBill);
		return ("CustomerID: "+generateBill.getCustomerID()+"updateBill:result:" + result);
	}
	
	@DeleteMapping("/deleteBill/{custId}")
	public String deleteBillById(@PathVariable long custId) {
		System.out.println("Inside GenerateBill controller:"+custId);
		String result = service.deleteBill(custId);
		return ("CustomerId: "+custId+"Delete : result : " + result);
	}

}