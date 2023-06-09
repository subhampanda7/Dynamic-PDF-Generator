package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.masai.model.PDFGenerator;
import com.masai.services.PDFGeneratorService;

@RestController
public class PDFController {
	
    @Autowired
    PDFGeneratorService pdfGeneratorService;

    @PostMapping("/pdf")
    public ResponseEntity<byte[]> generatePdf(@RequestBody PDFGenerator invoice) throws Exception {
    	
        if (invoice == null || invoice.getItems() == null)
            throw new Exception("Invalid request body");
        
        ByteArrayOutputStream byteOutputStream = pdfGeneratorService.generateByteArray(invoice);
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setContentType(MediaType.APPLICATION_PDF);
        
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("invoice.pdf").build());
        
        return new ResponseEntity<>(byteOutputStream.toByteArray(), headers, HttpStatus.CREATED);
    }

}

