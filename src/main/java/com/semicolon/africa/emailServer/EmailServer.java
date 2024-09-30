package com.semicolon.africa.emailServer;

import com.semicolon.africa.dtos.requests.SendEmailRequest;
import com.semicolon.africa.dtos.response.SendMailResponse;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServer {


    private MimeMessage msg;
    private SendMailResponse sendMailResponse;

    public SendMailResponse sendMail(@NotNull SendEmailRequest sendEmailRequest) {
        sendMailResponse = new SendMailResponse();
        try{
            this.msg = new MimeMessage(sendEmailRequest.getSession());
            msg.setFrom(new InternetAddress(sendEmailRequest.getSenderEmailAddress()));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendEmailRequest.getRecipientEmailAddress()));
            msg.setSubject(sendEmailRequest.getSubject());
            msg.setSentDate(sendEmailRequest.getSentDate());
            msg.setText(sendEmailRequest.getBody());
            Transport.send(msg);
            sendMailResponse.setMessage("Mail sent.");
            sendMailResponse.setStatus(true);
        }catch(MessagingException msgEx){

            System.out.println(msgEx.getCause());
            sendMailResponse.setMessage(msgEx);
            sendMailResponse.setStatus(false);
        }
        return sendMailResponse;
    }

}
