package com.solarNetBilling.demo.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solarNetBilling.demo.Controller.GenerateBillController;
import com.solarNetBilling.demo.Model.GenerateBill;



@Service
public class GenerateBillServiceImpl {
	private static final Logger log = LoggerFactory.getLogger(GenerateBillController.class);
	
	
	// 1. Make the field final to prevent accidental changes
    private final CalculateBillService billService;
    
    // 2. Create a constructor to inject the service bean automatically
    public GenerateBillServiceImpl(CalculateBillService billService) {
        this.billService = billService;
    }
	
	HashMap<String, Character> billType = new HashMap<String, Character>();
	{
	billType.put("Domestic", 'G');
	billType.put("Commercial", 'R' );
	billType.put("Short-term", 'T' );
	billType.put("Municipal or Non-Municipal", 'P');
	billType.put("School", 'S');
	billType.put("Industrial", 'I');
	billType.put("College", 'C');
	billType.put("Street light", 'L');
	billType.put("Office", 'O');
	billType.put("EV Charging Station", 'E');
	}
	
	
    private static final AtomicLong sequence = new AtomicLong(0);
    private static LocalDate lastResetDate = LocalDate.now();
    
    

    //Bill No Generator Method
    public synchronized long generateBillNo() {
        LocalDate today = LocalDate.now();

        // Reset sequence at start of each new day
        if (!today.equals(lastResetDate)) {
            sequence.set(0);
            lastResetDate = today;
        }

        String datePart = today.format(DateTimeFormatter.ofPattern("yyMMdd")); // 6 digits
        long seq = sequence.incrementAndGet() % 10000;
        String seqPart = String.format("%04d", seq);

        return Long.parseLong(datePart + seqPart); // e.g. 2509220001
    }
    
    //Calculate bill method
    public GenerateBill generateBillAmount(GenerateBill genBill) {
    	
    	char category = billType.get(genBill.getCustomerType());
    	log.debug("Type Of Customer: " + genBill.getCustomerType() + " Consumer Category: " + category);
    	genBill.setUnitConsumed(Math.round(genBill.getCurrentReading() - genBill.getPreviousReading()));
    	genBill.setBillNo(generateBillNo());
    	genBill.setBillAmount(calculatebillAmount(category , genBill.getUnitConsumed()));
    	genBill.setBillDate(LocalDate.now());
    	
    	return genBill;
    }
    
    
    public double calculatebillAmount(char category, double unitConsumed) {
    	
    	double result=0;
    	
    	switch(category) {
    	case 'G': 
    		log.info("switch : Domestic");
    		result = billService.calculateDomesticbill(unitConsumed);
    		break;
    	case 'R': 
    		log.info("switch : Commercial");
    		result = billService.calculateCommercialbill(unitConsumed);
    		break;
    	case 'T': 
    		log.info("switch : Short-term");
    		result = billService.calculateShortTermbill(unitConsumed);
    		break;
    	case 'P': 
    		log.info("switch : Municipal or Non-Municipal");
    		result = billService.calculateMuncipalbill(unitConsumed);
    		break;
    	case 'S': 
    		log.info("switch : School");
    		result = billService.calculateSchoolbill(unitConsumed);
    		break;
    	case 'I': 
    		log.info("switch : Industrial");
    		result = billService.calculateIndustrialbill(unitConsumed);
    		break;
    	case 'C': 
    		log.info("switch : College");
    		result = billService.calculateCollegebill(unitConsumed);
    		break;
    	case 'L': 
    		log.info("switch : Street light");
    		result = billService.calculateStreetLightbill(unitConsumed);
    		break;
    	case 'O': 
    		log.info("switch : Office");
    		result = billService.calculateOfficebill(unitConsumed);
    		break;
    	case 'E': 
    		log.info("switch : EV charging station");
    		result = billService.calculateEVChargingbill(unitConsumed);
    		break;
    	  default:
    		  log.info("switch : Customer category is out of the defined range:"+category);
    	
    	}
    	
    	return result;
    }
    
    
    
    
    
  
    
    
    
}
