package com.example.invoice.utils.validators;

import com.example.invoice.grpc.InvoiceGeneratorServiceRequest;

import java.util.regex.Pattern;

public class InvoiceGeneratorServiceRequestValidator {
    public static void validateFirstName(final String firstName){
        if(firstName == null || firstName.isEmpty()){
            throw new RuntimeException("InvoiceGeneratorServiceRequest: First Name can not be NULL or empty");
        }
    }
    public static void validateLastName(final String lastName){
        if(lastName == null || lastName.isEmpty()){
            throw new RuntimeException("InvoiceGeneratorServiceRequest: Last Name can not be NULL or empty");
        }
    }

    public static void validateEmail(final String email) {
        if(email == null || !patternMatches(email)){
            throw new RuntimeException("InvoiceGeneratorServiceRequest: Email Pattern does not match");
        }
    }

    public static void validateAmount(final long amount){
        if(amount <= 0){
            throw new RuntimeException("InvoiceGeneratorServiceRequest: Amount must be greater then 0");
        }
    }

    public static void validateInvoiceType(InvoiceGeneratorServiceRequest.Type invoiceType){
        if(invoiceType.getNumber() < 1 || invoiceType.getNumber() > 2){
            throw new RuntimeException("InvoiceGeneratorServiceRequest: InvoiceType is incorrect");
        }
    }

    private static boolean patternMatches(final String emailAddress) {
        return Pattern
                .compile("^(.+)@(\\\\S+)$")
                .matcher(emailAddress)
                .matches();
    }
}
