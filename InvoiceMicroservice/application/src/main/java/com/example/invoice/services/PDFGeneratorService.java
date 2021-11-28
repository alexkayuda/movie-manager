package com.example.invoice.services;

import com.example.invoice.enums.ResponseCode;
import com.example.invoice.grpc.InvoiceGeneratorServiceRequest;
import com.example.invoice.models.SampleMovieModel;
import com.example.invoice.utils.builders.DefaultBuilder;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class PDFGeneratorService {

    public int generatePDF(
            String pdfName,
            String firstName,
            String lastName,
            InvoiceGeneratorServiceRequest.Type purchaseType,
            long amount) throws IOException {

        String path = "application\\src\\main\\java\\generatedPDF\\" + pdfName;
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        pdfDocument.setDefaultPageSize(PageSize.A4);

        //Generating Header section of the Invoice
        float headerColumnWidth[] = {400f, 160f};
        Table headerTable = new Table(headerColumnWidth);
        headerTable.setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(DeviceRgb.WHITE);

        headerTable.addCell(new Cell().add(
                new Paragraph("INVOICE"))
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginTop(30f)
                .setMarginBottom(30f)
                .setFontSize(30f));

        headerTable.addCell(new Cell().add(
                new Paragraph("Regal Cinema\n500 Spectrum Center Dr\nIrvine, CA  92618"))
                .setTextAlignment(TextAlignment.RIGHT)
                .setMarginTop(30f)
                .setMarginBottom(30f)
                .setMarginRight(30f)
        );

        removeBorder(headerTable);

        document.add(headerTable);
        document.add(new Paragraph("\n\n"));

        //Generating Customer section of the invoice
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        float bodyColumnWidth[] = {80,300, 100, 80};
        Table customerInfoTable = new Table(bodyColumnWidth);
        customerInfoTable.setBorder(null);

        customerInfoTable.addCell(new Cell(0,4).add(
                new Paragraph("Customer Information").setBold()
        ));

        customerInfoTable.addCell(new Cell().add(
                new Paragraph("Name")
        ));

        customerInfoTable.addCell(new Cell().add(
                new Paragraph(lastName + ", " + firstName)
        ));

        customerInfoTable.addCell(new Cell().add(
                new Paragraph("Invoice #")
        ));

        customerInfoTable.addCell(new Cell().add(
                new Paragraph("1234567"))
                .setTextAlignment(TextAlignment.RIGHT)
        );

        customerInfoTable.addCell(new Cell().add(
                new Paragraph("Reference ID")
        ));

        customerInfoTable.addCell(new Cell().add(
                new Paragraph(UUID.randomUUID().toString())
        ));

        customerInfoTable.addCell(new Cell().add(
                new Paragraph("Date")
        ));

        customerInfoTable.addCell(new Cell().add(
                new Paragraph(dateFormat.format(new Date())))
                .setTextAlignment(TextAlignment.RIGHT)
        );

        removeBorder(customerInfoTable);
        document.add(customerInfoTable);

        document.add(new Paragraph("\n"));

        //Generating Invoice Details section of the invoice
        SampleMovieModel movie = DefaultBuilder.createDefaultMovieBuilder().build();

        float invoiceDetailsColumnWidth[] = {140,140,140,140};
        Table invoiceDetailsTable = new Table(invoiceDetailsColumnWidth);

        invoiceDetailsTable.addCell(new Cell().add(
                new Paragraph("Purchase Type"))
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(DeviceRgb.WHITE)
                .setTextAlignment(TextAlignment.CENTER)
        );

        invoiceDetailsTable.addCell(new Cell().add(
                new Paragraph("Movie Title"))
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(DeviceRgb.WHITE)
                .setTextAlignment(TextAlignment.CENTER)
        );

        invoiceDetailsTable.addCell(new Cell().add(
                new Paragraph("Qty"))
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(DeviceRgb.WHITE)
                .setTextAlignment(TextAlignment.CENTER)
        );

        invoiceDetailsTable.addCell(new Cell().add(
                new Paragraph("Amount"))
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(DeviceRgb.WHITE)
                .setTextAlignment(TextAlignment.CENTER)
        );

        //Subscription means a monthly pass
        if(purchaseType.getValueDescriptor().getFullName() == "SUBSCRIPTION"){
            invoiceDetailsTable.addCell(new Cell().add(
                    new Paragraph("Monthly Pass"))
                    .setTextAlignment(TextAlignment.CENTER)
            );

            invoiceDetailsTable.addCell(new Cell().add(
                    new Paragraph("---"))
                    .setTextAlignment(TextAlignment.CENTER)
            );
        } else {
            invoiceDetailsTable.addCell(new Cell().add(
                    new Paragraph("Movie Ticket"))
                    .setTextAlignment(TextAlignment.CENTER)
            );

            invoiceDetailsTable.addCell(new Cell().add(
                    new Paragraph(movie.getTitle()))
                    .setTextAlignment(TextAlignment.CENTER)
            );
        }

        invoiceDetailsTable.addCell(new Cell().add(
                new Paragraph("1"))
                .setTextAlignment(TextAlignment.CENTER)
        );

        invoiceDetailsTable.addCell(new Cell().add(
                new Paragraph(NumberFormat.getCurrencyInstance().format(amount)))
                .setTextAlignment(TextAlignment.CENTER)
        );

        invoiceDetailsTable.addCell(new Cell().add(
                        new Paragraph("blank")
                                .setTextAlignment(TextAlignment.CENTER)
                                .setFontColor(DeviceRgb.BLACK)
                                .setOpacity(0.15f)
        ));

        invoiceDetailsTable.addCell(new Cell().add(
                new Paragraph("blank")
                        .setTextAlignment(TextAlignment.CENTER)
                        .setFontColor(DeviceRgb.BLACK)
                        .setOpacity(0.15f)
        ));

        invoiceDetailsTable.addCell(new Cell().add(
                new Paragraph("blank")
                        .setTextAlignment(TextAlignment.CENTER)
                        .setFontColor(DeviceRgb.BLACK)
                        .setOpacity(0.15f)
        ));

        invoiceDetailsTable.addCell(new Cell().add(
                new Paragraph("blank")
                        .setTextAlignment(TextAlignment.CENTER)
                        .setFontColor(DeviceRgb.BLACK)
                        .setOpacity(0.15f)
        ));

        invoiceDetailsTable.addCell(new Cell().add(
                new Paragraph(""))
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(DeviceRgb.WHITE)
        );

        invoiceDetailsTable.addCell(new Cell().add(
                new Paragraph(""))
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(DeviceRgb.WHITE)
        );

        invoiceDetailsTable.addCell(new Cell().add(
                new Paragraph("Total Amount:"))
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(DeviceRgb.WHITE)
                .setTextAlignment(TextAlignment.RIGHT)
        );

        invoiceDetailsTable.addCell(new Cell().add(
                new Paragraph(NumberFormat.getCurrencyInstance().format(amount)))
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(DeviceRgb.WHITE)
                .setTextAlignment(TextAlignment.RIGHT)
        );

        document.add(invoiceDetailsTable);

        document.close();
        return ResponseCode.SUCCESSFUL_VALUE;
    }

    private static void removeBorder(Table table) {
        for (IElement iElement : table.getChildren()) {
            ((Cell)iElement).setBorder(Border.NO_BORDER);
        }
    }
}
