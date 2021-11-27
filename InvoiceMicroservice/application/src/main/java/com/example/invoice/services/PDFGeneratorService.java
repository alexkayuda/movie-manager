package com.example.invoice.services;

import com.example.invoice.enums.ResponseCode;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class PDFGeneratorService {

    private String referenceId = UUID.randomUUID().toString();

    public int generatePDF(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:hh:mm");
        String currentDateTime = dateFormat.format(new Date());
        String pdfName = "invoice_" + currentDateTime + ".pdf";

        return ResponseCode.SUCCESSFUL_VALUE;
    }
}
