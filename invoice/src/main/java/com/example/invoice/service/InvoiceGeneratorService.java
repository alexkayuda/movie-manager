package com.example.invoice.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class InvoiceGeneratorService {
    public void generate(HttpServletResponse response) throws IOException {

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.COURIER_BOLD);
        titleFont.setSize(20);

        String titleText = "Title of the text";

        Paragraph titleParagraph = new Paragraph(titleText, titleFont);
        titleParagraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font bodyFont = FontFactory.getFont(FontFactory.COURIER);
        bodyFont.setSize(15);

        String bodyText = "Body of the invoice";

        Paragraph bodyParagraph = new Paragraph(bodyText, bodyFont);
        bodyParagraph.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(titleParagraph);
        document.add(bodyParagraph);

        document.close();
    }
}
