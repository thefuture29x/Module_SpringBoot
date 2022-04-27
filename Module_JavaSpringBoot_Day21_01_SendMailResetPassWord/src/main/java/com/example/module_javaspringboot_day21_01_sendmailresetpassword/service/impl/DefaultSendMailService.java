package com.example.module_javaspringboot_day21_01_sendmailresetpassword.service.impl;

import com.example.module_javaspringboot_day21_01_sendmailresetpassword.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;


@Service
public class DefaultSendMailService implements AuthService {
    @Autowired
    MailService mailService;

    private String urlResetPassword;

    @Override
    public void sendMailResetPassword(String mail) {
        String url = "ahihi-phong-ne";
        this.mailService.sendTextMail(
                "chiphongteo1123@gmail.com",
                mail,
                "Test sent mail Notiface",
                null,
                "Code to reset password :\n",
                url,
                null
        );


    }
}
