package com.example.Security.service;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendVerificationEmail(String mail, String otp) throws MessagingException {
        MimeMailMessage mimeMessage = new MimeMailMessage(javaMailSender.createMimeMessage());
        MimeMessageHelper mimeMessagehelper = new MimeMessageHelper(mimeMessage.getMimeMessage(), "utf-8");

        String subject = "Verify OTP";
        String text = "Your OTP code is: " + otp;

        mimeMessagehelper.setSubject(subject);
        mimeMessagehelper.setTo(mail);
        mimeMessagehelper.setText(text, true);

        try {
            javaMailSender.send(mimeMessage.getMimeMessage());
        }
        catch (MailException e) {
            throw new MailSendException(e.getMessage());
        }
    }
}
