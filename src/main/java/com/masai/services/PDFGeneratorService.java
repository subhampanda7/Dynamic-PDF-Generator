package com.masai.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.masai.model.Item;
import com.masai.model.PDFGenerator;

@Service
public class PDFGeneratorService {
	
	public ByteArrayOutputStream generateByteArray(PDFGenerator pdfGenerator) {
		
        ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
        
        try {
        	
        	
            PdfWriter pdfWriter = new PdfWriter(pdfOutputStream);
            
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            
            PdfFont pdfFont = PdfFontFactory.createFont(StandardFonts.COURIER_BOLD);
            
            Document document = new Document(pdfDocument).setFont(pdfFont);
            
            float[] pointColumnWidths = { 280F, 280F };
            
            Table tableHeader = new Table(pointColumnWidths);
            
            String seller = "Seller:\n"+pdfGenerator.getSeller()+"\n"+pdfGenerator.getSellerAddress()+"\n GSTIN: "+pdfGenerator.getSellerGstin();
            
            tableHeader.addCell(new Cell().add(new Paragraph(seller)).setPadding(30));
            
            String buyer = "Buyer:\n"+pdfGenerator.getBuyer()+"\n"+ pdfGenerator.getBuyerAddress()+"\n GSTIN: "+pdfGenerator.getBuyerGstin();
            
            tableHeader.addCell(new Cell().add(new Paragraph(buyer)).setPadding(20));
            
            
            
            float[] productInformationWidth = { 140, 140, 140, 140 };
            
            Table productTable = new Table(productInformationWidth);
            
            productTable.setTextAlignment(TextAlignment.CENTER);
            
            productTable.addCell(new Cell().add(new Paragraph("Item")));
            productTable.addCell(new Cell().add(new Paragraph("Quantity")));
            productTable.addCell(new Cell().add(new Paragraph("Rate")));
            productTable.addCell(new Cell().add(new Paragraph("Amount")));
            
            

            List<Item> itemsList = pdfGenerator.getItems();
            
            for (Item item : itemsList) {
            	
                productTable.addCell(new Cell().add(new Paragraph(item.getName())));
                productTable.addCell(new Cell().add(new Paragraph(item.getQuantity())));
                productTable.addCell(new Cell().add(new Paragraph(String.valueOf(item.getRate()))));
                productTable.addCell(new Cell().add(new Paragraph(String.valueOf(item.getAmount()))));
            }
            
         
            
            document.add(tableHeader);
            document.add(productTable);
            
            pdfWriter.close();
            pdfDocument.close();
            document.close();
        }

        catch (IOException e) {
        	
            e.getMessage();
            
        }
        return pdfOutputStream;
    }
}