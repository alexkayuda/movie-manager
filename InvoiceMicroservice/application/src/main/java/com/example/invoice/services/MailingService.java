package com.example.invoice.services;

import com.example.invoice.enums.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;

@Service
public class MailingService {

    @Value("${mailing.address.from}")
    private String mailingAddressFrom;

    @Value("${mailing.address.to}")
    private String mailingAddressTo;

    @Autowired
    private JavaMailSender javaMailSender;

    public int sendMailWithAttachment(String attachmentName, String emailTo){

        final String pathToAttachment = "application\\src\\main\\java\\generatedPDF\\" + attachmentName;

        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                //for testing purposes, I will forward all emails to my testing email address
                //but the line below will be enabled in production env
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mailingAddressTo));
//                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
                mimeMessage.setFrom(new InternetAddress(mailingAddressFrom));
                mimeMessage.setSubject("Hey! Thanks for purchasing a ticket :)");

                MimeMultipart mimeMultipart = new MimeMultipart();

                MimeBodyPart attachment = new MimeBodyPart();
                attachment.attachFile(new File(pathToAttachment));

                MimeBodyPart bodyPart = new MimeBodyPart();
                bodyPart.setContent("<h1>Please find a file attached to the body of the this email :)</h1>", "text/html");

                mimeMultipart.addBodyPart(bodyPart);
                mimeMultipart.addBodyPart(attachment);

                mimeMessage.setContent(mimeMultipart);
            }
        };

        try {
            javaMailSender.send(preparator);
            System.out.println("Message was sent... Should be there shortly :)");
            return ResponseCode.SUCCESSFUL_VALUE;
        } catch (MailException e) {
            e.printStackTrace();
            System.out.println("Unable to send an email... Something went wrong :(");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Something went REALLY wrong while attempting to send an email :(");
        }

        return ResponseCode.ERROR_VALUE;
    }
}
