package com.solarNetBilling.demo.Controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solarNetBilling.demo.Model.DownloadBill;
import com.solarNetBilling.demo.Service.DownloadBillService;

@RestController
@RequestMapping("/download")
public class DownloadBillController {
	
	private static final Logger log = LoggerFactory.getLogger(GenerateBillController.class);
	
	@Autowired
	DownloadBillService downloadBillService;

	@GetMapping("/bill/{custId}")
	public List<DownloadBill> getBill(@PathVariable long custId) {
		log.info("Inside getBill() ");
		return downloadBillService.getBillInfo(custId);
	}
	
    @GetMapping("/bill/id/{custId}")
    public ResponseEntity<byte[]> download(@PathVariable long custId) {
    	List<DownloadBill> dnldBill = downloadBillService.getBillInfo(custId);
		DownloadBill bill = dnldBill.stream().findFirst().orElse(null);
        byte[] pdf = downloadBillService.generate(bill);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=electricity-bill-" + bill.getCustomerID() + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}