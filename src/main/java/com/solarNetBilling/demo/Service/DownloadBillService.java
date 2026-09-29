package com.solarNetBilling.demo.Service;


import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.openpdf.text.Chunk;
import org.openpdf.text.Document;
import org.openpdf.text.Element;
import org.openpdf.text.Font;
import org.openpdf.text.PageSize;
import org.openpdf.text.Paragraph;
import org.openpdf.text.Phrase;
import org.openpdf.text.pdf.PdfPCell;
import org.openpdf.text.pdf.PdfPTable;
import org.openpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solarNetBilling.demo.Controller.GenerateBillController;
import com.solarNetBilling.demo.DAO.DownloadBillDAO;
import com.solarNetBilling.demo.Model.DownloadBill;

@Service
public class DownloadBillService {
	
	private static final Logger log = LoggerFactory.getLogger(GenerateBillController.class);
	
	@Autowired
	DownloadBillDAO downloadBillDAO;
	
	List<DownloadBill> dnldBill = new ArrayList<DownloadBill>();

	public List<DownloadBill> getBillInfo(long custId) {
		dnldBill = downloadBillDAO.findById(custId);
		//dnldBill.setMeterRent(0.00);
		//dnldBill.setFixedCharge(0.00);
		return dnldBill;
	}
	
	
	
	public byte[] generate(DownloadBill bill) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document doc = new Document(PageSize.A4, 40, 40, 40, 40);
        PdfWriter.getInstance(doc, out);
        doc.open();
        
        //Font Style
        Font title = new Font(Font.HELVETICA, 18, Font.BOLD);
        Font bold = new Font(Font.HELVETICA, 11, Font.BOLD);
        Font normal = new Font(Font.HELVETICA, 11);
        
        //Paragraph Heading
        Paragraph heading = new Paragraph("ELECTRICITY BILL", title);
        heading.setAlignment(Element.ALIGN_CENTER);
        heading.setSpacingAfter(20);
        doc.add(heading);

        
        doc.add(new Paragraph("Consumer Name: " + bill.getCustomerName(), normal));
        doc.add(new Paragraph("Consumer ID: " + bill.getCustomerID(), normal));
        doc.add(new Paragraph("Consumer Phone No: " + bill.getCustomerContactDetails(), normal));
        doc.add(new Paragraph("Consumer EmailID: " + bill.getCustomerEmailId(), normal));
        doc.add(new Paragraph("Consumer Type: " + bill.getCustomerType(), normal));
        doc.add(new Paragraph("Address: " + bill.getCustomerAddress(), normal));
        doc.add(new Paragraph("Bill No.: " + bill.getBillNo(), normal));
        doc.add(new Paragraph("Billing Month: " + bill.getBillDate(), normal));
        doc.add(Chunk.NEWLINE);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{3, 2});

        addRow(table, "Previous Reading", String.valueOf(bill.getPreviousReading()), normal);
        addRow(table, "Current Reading", String.valueOf(bill.getCurrentReading()), normal);
        addRow(table, "Units Consumed", String.valueOf(bill.getUnitConsumed()), normal);
        addRow(table, "Energy Charge", String.format("Rs. %.2f", bill.getBillAmount()), normal);
        addRow(table, "Fixed Charge", String.format("Rs. %.2f", bill.getFixedCharge()), normal);
        addRow(table, "Meter Rent", String.format("Rs. %.2f", bill.getMeterRent()), normal);
        //addRow(table, "Tax", String.format("Rs. %.2f", bill.getTax()), normal);
        //addRow(table, "TOTAL AMOUNT", String.format("Rs. %.2f", bill.getTotalAmount()), bold);

        doc.add(table);
        doc.close();
        return out.toByteArray();
    }

    private void addRow(PdfPTable table, String label, String value, Font font) {
        PdfPCell c1 = new PdfPCell(new Phrase(label, font));
        PdfPCell c2 = new PdfPCell(new Phrase(value, font));
        c1.setPadding(8);
        c2.setPadding(8);
        c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(c1);
        table.addCell(c2);
    }
}
	
	
