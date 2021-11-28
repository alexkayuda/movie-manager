package com.example.invoice.services;

import com.example.invoice.enums.ResponseCode;
import com.example.invoice.grpc.InvoiceGeneratorServiceGrpc;
import com.example.invoice.grpc.InvoiceGeneratorServiceRequest;
import com.example.invoice.grpc.InvoiceGeneratorServiceResponse;
import com.example.invoice.utils.validators.InvoiceGeneratorServiceRequestValidator;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import javax.mail.internet.AddressException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@GrpcService
public class InvoiceService extends InvoiceGeneratorServiceGrpc.InvoiceGeneratorServiceImplBase{

    private final PDFGeneratorService pdfGeneratorService;
    private final MailingService mailingService;

    private String statusMessage;
    private int statusCode;

    public InvoiceService(PDFGeneratorService pdfGeneratorService, MailingService mailingService) {
        this.pdfGeneratorService = pdfGeneratorService;
        this.mailingService = mailingService;
    }

    @Override
    public void invoiceGeneratorService(InvoiceGeneratorServiceRequest request, StreamObserver<InvoiceGeneratorServiceResponse> responseObserver) {

        // validate params in the request.
        try {
            InvoiceGeneratorServiceRequestValidator.validateFirstName(request.getFirstName());
            InvoiceGeneratorServiceRequestValidator.validateLastName(request.getLastName());
            InvoiceGeneratorServiceRequestValidator.validateInvoiceType(request.getType());
            InvoiceGeneratorServiceRequestValidator.validateEmail(request.getEmail());
            InvoiceGeneratorServiceRequestValidator.validateAmount(request.getAmount());
        } catch (RuntimeException | AddressException e){
            statusCode = ResponseCode.ERROR_VALUE;
            statusMessage = "Invalid Request Parameter/-s";
            InvoiceGeneratorServiceResponse response =
                    InvoiceGeneratorServiceResponse
                            .newBuilder()
                            .setResponseMessage(statusMessage)
                            .setResponseCode(statusCode)
                            .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        // generate pdf and store it locally (storing it in S3 bucket will be done in the future).
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String currentDateTime = dateFormat.format(new Date());
        String pdfName = "invoice_" + currentDateTime + ".pdf";
        try {
            statusCode = pdfGeneratorService.generatePDF(
                    pdfName,
                    request.getFirstName(),
                    request.getLastName(),
                    request.getType(),
                    request.getAmount()
            );
        } catch (FileNotFoundException fileNotFoundException){
            statusCode = ResponseCode.ERROR_VALUE;
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            statusCode = ResponseCode.ERROR_VALUE;
            ioException.printStackTrace();
        } catch (Exception e){
            statusCode = ResponseCode.ERROR_VALUE;
            e.printStackTrace();
        }

        if(statusCode == ResponseCode.SUCCESSFUL_VALUE){
            // using MailerService, send an email to a buyer with .pdf file attached.
            statusCode = mailingService.sendMailWithAttachment(pdfName, request.getEmail());
        }

        if(statusCode == ResponseCode.SUCCESSFUL_VALUE){
            statusMessage = "PDF was generated and emailed successfully";
        } else {
            statusMessage = "Something went wrong...";
        }
        // send a response back to the caller with status code and a message.
        InvoiceGeneratorServiceResponse response =
                InvoiceGeneratorServiceResponse
                        .newBuilder()
                        .setResponseMessage(statusMessage)
                        .setResponseCode(statusCode)
                        .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
