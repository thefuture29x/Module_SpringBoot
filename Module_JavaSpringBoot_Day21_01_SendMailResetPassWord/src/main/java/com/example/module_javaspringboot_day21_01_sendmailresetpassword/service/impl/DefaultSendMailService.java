package com.example.module_javaspringboot_day21_01_sendmailresetpassword.service.impl;

import com.example.module_javaspringboot_day21_01_sendmailresetpassword.service.AuthService;
import com.example.module_javaspringboot_day21_01_sendmailresetpassword.service.IUserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.util.Random;


@Service
public class DefaultSendMailService implements AuthService {
    @Autowired
    MailService mailService;
    @Autowired
    IUserService iUserService;

    @Override
    public void sendMailResetPassword(String mail) {
        String url = "ahihi-phong-ne";
        String tokenString = RandomString.make(60);

        this.mailService.sendTextMail(
                "chiphongteo1123@gmail.com",
                mail,
                "Test sent mail Notiface",
                null,
                "Code to reset password :\n",
                url,
                tokenString,
                null
        );

        iUserService.updateUserToken(mail,tokenString);


    }
}
