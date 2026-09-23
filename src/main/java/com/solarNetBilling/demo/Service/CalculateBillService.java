package com.solarNetBilling.demo.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.solarNetBilling.demo.Controller.GenerateBillController;

@Service
public class CalculateBillService{
	
	private static final Logger log = LoggerFactory.getLogger(GenerateBillController.class);
	 
    // 1. Define a shared interface for any consumption slab type
	public interface BillableSlab {int unit();int energyCharge();}

    // 2. Make records implement the interface
    public record DomesticMonthlyConsumption(int unit, int energyCharge) implements BillableSlab {} 
    public record CommercialMonthlyConsumption(int unit, int energyCharge) implements BillableSlab {} 
    public record ShortTermMonthlyConsumption(int unit, int energyCharge) implements BillableSlab {}
    public record MunicipalMonthlyConsumption(int unit, int energyCharge) implements BillableSlab {}
    public record SchoolMonthlyConsumption(int unit, int energyCharge) implements BillableSlab {}
    public record IndustrialMonthlyConsumption(int unit, int energyCharge) implements BillableSlab {}
    public record CollegeMonthlyConsumption(int unit, int energyCharge) implements BillableSlab {}
    public record StreetLightMonthlyConsumption(int unit, int energyCharge) implements BillableSlab {}
    public record OfficeMonthlyConsumption(int unit, int energyCharge) implements BillableSlab {}
    public record EVChargingStationMonthlyConsumption(int unit, int energyCharge) implements BillableSlab {}

    // Slabs setup using LinkedHashMap to guarantee sequence order (1, 2, 3...)  // check for static
    static LinkedHashMap<Integer, DomesticMonthlyConsumption> chargeSlabForDomestic = new LinkedHashMap<>(); 
    static LinkedHashMap<Integer, CommercialMonthlyConsumption> chargeSlabForCommercial = new LinkedHashMap<>(); 
    static LinkedHashMap<Integer, ShortTermMonthlyConsumption> chargeSlabForShortTerm = new LinkedHashMap<>();
    static LinkedHashMap<Integer, MunicipalMonthlyConsumption> chargeSlabForMunicipal = new LinkedHashMap<>();
    static LinkedHashMap<Integer, SchoolMonthlyConsumption> chargeSlabForSchool = new LinkedHashMap<>();
    static LinkedHashMap<Integer, IndustrialMonthlyConsumption> chargeSlabForIndustrial = new LinkedHashMap<>();
    static LinkedHashMap<Integer, CollegeMonthlyConsumption> chargeSlabForCollege = new LinkedHashMap<>();
    static LinkedHashMap<Integer, StreetLightMonthlyConsumption> chargeSlabForStreet = new LinkedHashMap<>();
    static LinkedHashMap<Integer, OfficeMonthlyConsumption> chargeSlabForOffice = new LinkedHashMap<>();
    static LinkedHashMap<Integer, EVChargingStationMonthlyConsumption> chargeSlabForEVChargingStation = new LinkedHashMap<>();

    static {
        //Domestic Charge Slab
        chargeSlabForDomestic.put(1, new DomesticMonthlyConsumption(25,518));
        chargeSlabForDomestic.put(2, new DomesticMonthlyConsumption(35,569));
        chargeSlabForDomestic.put(3, new DomesticMonthlyConsumption(40,670));
        chargeSlabForDomestic.put(4, new DomesticMonthlyConsumption(50,745));
        chargeSlabForDomestic.put(5, new DomesticMonthlyConsumption(50,762)); 
        chargeSlabForDomestic.put(6, new DomesticMonthlyConsumption(100,762));
        chargeSlabForDomestic.put(7, new DomesticMonthlyConsumption(0,921));

        //Commercial Charge Slab
        chargeSlabForCommercial.put(1, new CommercialMonthlyConsumption(60,657));
        chargeSlabForCommercial.put(2, new CommercialMonthlyConsumption(40,724));
        chargeSlabForCommercial.put(3, new CommercialMonthlyConsumption(50,793));
        chargeSlabForCommercial.put(4, new CommercialMonthlyConsumption(150,849));
        chargeSlabForCommercial.put(5, new CommercialMonthlyConsumption(0,926));
        
        //ShortTerm Charge Slab
        chargeSlabForShortTerm.put(1, new ShortTermMonthlyConsumption(0,756));
        
        //Municipal or Non-Municipal Charge Slab
        chargeSlabForMunicipal.put(1, new MunicipalMonthlyConsumption(0,663));
        
        //School Charge Slab
        chargeSlabForSchool.put(1, new SchoolMonthlyConsumption(0,524));
        
        //Industrial Charge Slab
        chargeSlabForIndustrial.put(1, new IndustrialMonthlyConsumption(500,677));
        chargeSlabForIndustrial.put(2, new IndustrialMonthlyConsumption(1500,747));
        chargeSlabForIndustrial.put(3, new IndustrialMonthlyConsumption(1500,787));
        chargeSlabForIndustrial.put(4, new IndustrialMonthlyConsumption(0,807));
        
        //College Charge Slab
        chargeSlabForCollege.put(1, new CollegeMonthlyConsumption(0,732));
        
        //Street Charge Slab
        chargeSlabForStreet.put(1, new StreetLightMonthlyConsumption(0,577));
        
        //Office Charge Slab
        chargeSlabForOffice.put(1, new OfficeMonthlyConsumption(100,582));
        chargeSlabForOffice.put(2, new OfficeMonthlyConsumption(100,701));
        chargeSlabForOffice.put(3, new OfficeMonthlyConsumption(0,846));
        
        //EV Charging Station Charge Slab
        chargeSlabForEVChargingStation.put(1, new EVChargingStationMonthlyConsumption(0,722));
        
    } 

    /**
     * 3. THE GENERIC METHOD
     * Uses <? extends BillableSlab> to accept a map of any slab type.
     */
    public double billingLogic(double unitConsumed, Map<Integer, ? extends BillableSlab> chargeSlab) {
        double billAmount = 0; 
        double remainingUnits = unitConsumed; 
        int slab = 0, unit = 0, energyCharge = 0, count = 1; 
        log.info("unitConsumed : "+unitConsumed+", remainingUnits: "+remainingUnits);
        
        //  Ternary Operator to find the first element unit and energyCharge 
        int firstunit = chargeSlab.containsKey(1) ? chargeSlab.get(1).unit() : 0;
        int initialRate = chargeSlab.containsKey(1) ? chargeSlab.get(1).energyCharge() : 0;
        log.info("firstunit : "+firstunit+" initialRate :"+initialRate);
        

        if (remainingUnits < firstunit) {
            billAmount = (remainingUnits * initialRate) / 100.0; 
            log.debug("Inside if (remainingUnits < firstunit) Statement");
            log.info("billAmount :"+billAmount+"remainingUnits :"+remainingUnits+" initialRate :"+initialRate);
        }
        
        if (remainingUnits >= firstunit) { 
            for (Entry<Integer, ? extends BillableSlab> entry : chargeSlab.entrySet()) { 
                if (remainingUnits <= 0) {
                	log.info("Check: billAmount :"+billAmount+" remainingUnits :"+remainingUnits+" initialRate :"+initialRate);
                	log.info("unit consumed is less than maximum consumption in the slab");
                    break; 
                } 
                slab = entry.getKey(); 
                unit = entry.getValue().unit(); 
                energyCharge = entry.getValue().energyCharge();
                
                if (slab == count && slab < chargeSlab.size()) { 
                    billAmount = ((unit * energyCharge) / 100.0) + billAmount; 
                    remainingUnits = remainingUnits - unit; 
                    count++; 
					log.info("if : Slab: " + slab + ", Unit: " + unit + ", remainingUnits: " + remainingUnits
							+ ", energyCharge: " + energyCharge + ", count: " + count + ", chargeSlab.size(): "
							+ chargeSlab.size() + ", billAmount: " + billAmount);
                } else if (slab == chargeSlab.size()) {
                    billAmount = ((remainingUnits * energyCharge) / 100.0) + billAmount;
                    log.info("else if : Slab: " + slab + ", Unit: " + unit + ", remainingUnits: " + remainingUnits
							+ ", energyCharge: " + energyCharge + ", count: " + count + ", chargeSlab.size(): "
							+ chargeSlab.size() + ", billAmount: " + billAmount);
                } 
            } 
        } 
        return Math.round(billAmount * 100.0) / 100.0;
    }

    public double calculateDomesticbill(double unitConsumed) {
        return billingLogic(unitConsumed, chargeSlabForDomestic);
    } 

    public double calculateCommercialbill(double unitConsumed) {
        return billingLogic(unitConsumed, chargeSlabForCommercial);
    } 

	public double calculateShortTermbill(double unitConsumed) {
	  return billingLogic(unitConsumed, chargeSlabForShortTerm);
	}
	
	public double calculateMuncipalbill(double unitConsumed) {
	  return billingLogic(unitConsumed, chargeSlabForMunicipal);
	}
	
	public double calculateSchoolbill(double unitConsumed) {
	  return billingLogic(unitConsumed, chargeSlabForSchool);
	}
	
	public double calculateIndustrialbill(double unitConsumed) {
	  return billingLogic(unitConsumed, chargeSlabForIndustrial);
	}
	
	public double calculateCollegebill(double unitConsumed) {
	  return billingLogic(unitConsumed, chargeSlabForCollege);
	}
	
	public double calculateStreetLightbill(double unitConsumed) {
	  return billingLogic(unitConsumed, chargeSlabForStreet);
	}
	
	public double calculateOfficebill(double unitConsumed) {
	  return billingLogic(unitConsumed, chargeSlabForOffice);
	}
	
	public double calculateEVChargingbill(double unitConsumed) {
	  return billingLogic(unitConsumed, chargeSlabForEVChargingStation);
	}
	
}