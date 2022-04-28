package com.example.module_javaspringboot_day22_01_practice.service.impl;

import com.example.module_javaspringboot_day22_01_practice.dto.BillCheckoutDTO;
import com.example.module_javaspringboot_day22_01_practice.entities.ProductEntity;
import com.example.module_javaspringboot_day22_01_practice.service.IDefaultSendMailService;
import com.example.module_javaspringboot_day22_01_practice.service.IUserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultSendMailServiceImpl implements IDefaultSendMailService {
    @Autowired
    MailService mailService;
    @Autowired
    IUserService iUserService;
    @Override
    public void sendMailResetPassword(String email) {
//        String url = "ahihi-phong-ne";
        String tokenString = RandomString.make(45);

        this.mailService.sendTextMail(
                "chiphongteo1123@gmail.com",
                email,
                "Test sent mail Notiface",
                null,
                "Code to reset password :\n",
                null,
                tokenString,
                null
        );

        iUserService.updateUserToken(email,tokenString);
    }

    @Override
    public void sendMailToPayCart(String email, BillCheckoutDTO model, List<ProductEntity> list) {

        this.mailService.sendMailCheckout(
                "chiphongteo1123@gmail.com",
                email,
                "Test sent mail Notiface",
                "Checkout Success !!! ",
                model,
                list
        );
    }
}
