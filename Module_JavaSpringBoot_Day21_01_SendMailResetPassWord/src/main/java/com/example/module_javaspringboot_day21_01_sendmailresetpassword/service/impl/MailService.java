package com.example.module_javaspringboot_day21_01_sendmailresetpassword.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void  sendTextMail(String from,
                              String toAddress,
                              String subject,
                              String filePath,
                              String content,
                              String url,
                              Object model){
        final Context ctx = new Context(LocaleContextHolder.getLocale());
        ctx.setVariable("model",model);
        final MimeMessage mesasge = this.javaMailSender.createMimeMessage();
        final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mesasge,"UTF-8");
        try {
            mimeMessageHelper.setTo(toAddress);
            try {
                mimeMessageHelper.setFrom(from,"Reset Password");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            mimeMessageHelper.setSubject(subject);

            String codeReset = "PhongAhihi123";
            String textContent = "<h3 style='color:red;'> " +content+ " </br> "+codeReset+" </h3>";
            mimeMessageHelper.setText(textContent,true);

            this.javaMailSender.send(mesasge);


        } catch (MessagingException e) {
            e.printStackTrace();

        }
    }




    public void sendEmail(String emailString, String resetPasswordString)
            throws UnsupportedEncodingException, MessagingException {

        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mailHelper = new MimeMessageHelper(mailMessage);

        mailHelper.setFrom("chiphongteo1123@gmail.com", "Reset PassWord");
        mailHelper.setTo(emailString);

        String subject = "Here's the link to reset your password";

        String content = "<p>Hello !!!,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + resetPasswordString + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        mailHelper.setSubject(subject);

        mailHelper.setText(content, true);

        javaMailSender.send(mailMessage);
    }

}
