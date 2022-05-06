package com.example.module_javaspringboot_finalproject.service.impl;

import com.example.module_javaspringboot_finalproject.dto.BillCheckoutDTO;
import com.example.module_javaspringboot_finalproject.dto.CartProductDTO;
import com.example.module_javaspringboot_finalproject.dto.ProductDTO;
import com.example.module_javaspringboot_finalproject.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    TemplateEngine templateEngine;

    private static final String HTML_TEMPLATE = "bill_product";

    public void  sendTextMail(String from,
                              String toAddress,
                              String subject,
                              String filePath,
                              String content,
                              String url,
                              String tokenString,
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
            String resetPasswordString = "http://localhost:8080/reset_password?token=" + tokenString;
            String textContent = "<h3> " +content+ " </h3>"
                    + "<p>Click the link below to change your password:</p>"
                    + "<p><a href=\"" + resetPasswordString + "\">Change my password</a></p>";
            mimeMessageHelper.setText(textContent,true);

            this.javaMailSender.send(mesasge);


        } catch (MessagingException e) {
            e.printStackTrace();

        }
    }

    public void sendMailCheckout(String from,
                                 String toAddress,
                                 String subject,
                                 String content,
                                 BillCheckoutDTO model,
                                 List<CartProductDTO> list){
        final Context ctx = new Context(LocaleContextHolder.getLocale());
        ctx.setVariable("model",model);
        ctx.setVariable("listProduct",list);
        final MimeMessage mesasge = this.javaMailSender.createMimeMessage();
        final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mesasge,"UTF-8");
        try {
            mimeMessageHelper.setTo(toAddress);
            try {
                mimeMessageHelper.setFrom(from,content);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            mimeMessageHelper.setSubject(subject);

            String htmlContent = this.templateEngine.process(HTML_TEMPLATE, ctx);
            mimeMessageHelper.setText(htmlContent,true);
            this.javaMailSender.send(mesasge);


        } catch (MessagingException e) {
            e.printStackTrace();

        }
    }
}
