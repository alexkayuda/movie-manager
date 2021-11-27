package com.example.invoice.services;

import com.example.invoice.enums.ResponseCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailingService {

    @Value("${mailing.address.from}")
    private String mailingAddressFrom;


    public int sendMailWithAttachment(String attachmentName){

        System.out.println(attachmentName);

        return ResponseCode.SUCCESSFUL_VALUE;
    }
}
