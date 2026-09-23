package com.solarNetBilling.demo.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solarNetBilling.demo.Controller.GenerateBillController;
import com.solarNetBilling.demo.Model.GenerateBill;

@Service
public class GenerateBillService {
	
	private static final Logger log = LoggerFactory.getLogger(GenerateBillController.class);
	 
	@Autowired
	GenerateBillServiceImpl generateBillServiceImpl;
	
	List<GenerateBill> generateBill =new ArrayList<>(Arrays.asList(
			new GenerateBill(7301313326L, "Domestic", 2751.66, 2934.12, 182.46, 1001L, 0.0, LocalDate.of(2026, 9, 22)),
		    new GenerateBill(8475904631L, "Domestic", 2860.29, 2907.14, 46.85, 1002L, 0.0, LocalDate.of(2026, 9, 22)),
		    new GenerateBill(9550184987L, "Domestic", 1991.38, 2089.92, 98.54, 1003L, 0.0, LocalDate.of(2026, 9, 22)),
		    new GenerateBill(3567841541L, "Commercial", 14187.78, 15281.43, 1093.65, 1004L, 0.0, LocalDate.of(2026, 9, 22)),
		    new GenerateBill(3230610782L, "Street light", 1272.73, 1514.63, 241.90, 1005L, 0.0, LocalDate.of(2026, 9, 22)),
		    new GenerateBill(1833149188L, "Commercial", 6289.03, 7479.7, 1190.67, 1007L, 0.0, LocalDate.of(2026, 9, 22)),
		    new GenerateBill(9576176055L, "Industrial", 152492.68, 160922.28, 8429.60, 1008L, 0.0, LocalDate.of(2026, 9, 22)),
		    new GenerateBill(4407275009L, "Commercial", 1450.11, 1605.43, 155.32, 1009L, 0.0, LocalDate.of(2026, 9, 22)),
		    new GenerateBill(2149955028L, "Commercial", 23343.78, 23423.21, 79.43, 1010L, 0.0, LocalDate.of(2026, 9, 22)),
		    new GenerateBill(2717042798L, "Domestic", 2020.3, 2243.42, 223.12, 1011L, 0.0, LocalDate.of(2026, 9, 22)),
		    new GenerateBill(3432233072L, "Domestic", 3647.99, 3806.14, 158.15, 1012L, 0.0, LocalDate.of(2026, 9, 22)),
		    new GenerateBill(1149644348L, "Commercial", 1661.62, 2636.99, 975.37, 1013L, 0.0, LocalDate.of(2026, 9, 22)),
		    new GenerateBill(6825365116L, "Domestic", 507.38, 587.91, 80.53, 1014L, 0.0, LocalDate.of(2026, 9, 22)),
		    new GenerateBill(5887223826L, "Street light", 463.9, 501.72, 37.82, 1015L, 0.0, LocalDate.of(2026, 9, 22)),
		    new GenerateBill(1384976654L, "Municipal or Non-Municipal", 27461.01, 29581.1, 2120.09, 1006L, 0.0, LocalDate.of(2026, 9, 22)),
		    new GenerateBill(4917382661L, "Commercial", 2408.95, 3289.55, 880.60, 1016L, 0.0, LocalDate.of(2026, 9, 22)))
			); 	

	public List<GenerateBill> generateBillInfo() {
		return generateBill;
	}
	
	@Deprecated
	public List<GenerateBill> generateBillNumber(){
		
		for(GenerateBill custbill : generateBill) {
			custbill.setBillNo(generateBillServiceImpl.generateBillNo());
		}	
		return generateBill;
	}

	public List<GenerateBill> generateAllCustBill() {
		for(GenerateBill custbill : generateBill) {
			
			GenerateBill temp = generateBillServiceImpl.generateBillAmount(custbill);
			custbill.setUnitConsumed(temp.getUnitConsumed());
			custbill.setBillNo(temp.getBillNo());
			custbill.setBillAmount(temp.getBillAmount());
			custbill.setBillDate(temp.getBillDate());
			
			
			log.info("Inside generateAllCustBill");
		}
		return generateBill;
	}
	
}
