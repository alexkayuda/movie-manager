package com.example.invoice.controller;

import com.example.invoice.service.InvoiceGeneratorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class InvoiceGeneratorController {

    private final InvoiceGeneratorService invoiceGeneratorService;

    //constructor dependency injection
    public InvoiceGeneratorController(InvoiceGeneratorService invoiceGeneratorService) {
        this.invoiceGeneratorService = invoiceGeneratorService;
    }

    @GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse response) throws IOException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:hh:mm");
        String currentDateTime = dateFormat.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=invoice_" + currentDateTime + ".pdf";

        response.setContentType("application-pdf");
        response.setHeader(headerKey, headerValue);

        this.invoiceGeneratorService.generate(response);
    }
}
