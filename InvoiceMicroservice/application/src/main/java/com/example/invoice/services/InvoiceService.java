package com.example.invoice.services;

import com.example.invoice.grpc.InvoiceGeneratorServiceGrpc;
import com.example.invoice.grpc.InvoiceGeneratorServiceRequest;
import com.example.invoice.grpc.InvoiceGeneratorServiceResponse;
import com.example.invoice.utils.validators.InvoiceGeneratorServiceRequestValidator;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


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
        InvoiceGeneratorServiceRequestValidator.validateFirstName(request.getFirstName());
        InvoiceGeneratorServiceRequestValidator.validateLastName(request.getLastName());
//        InvoiceGeneratorServiceRequestValidator.validateInvoiceType(request.getPurchaseType());
//        InvoiceGeneratorServiceRequestValidator.validateEmail(request.getEmail());
        InvoiceGeneratorServiceRequestValidator.validateAmount(request.getAmount());

        // generate pdf and store it locally (storing these in S3 bucket will be done in the future).
        statusCode = pdfGeneratorService.generatePDF();

        // using MailerService, email buyer with pdf attachment.
        statusCode = mailingService.sendMailWithAttachment("Name of the PDF HERE");


        if(statusCode == 1){
            statusMessage = "Email Was Successfully Sent to the Buyer";
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
