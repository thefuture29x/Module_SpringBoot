package com.example.module_javaspringboot_finalproject.service.impl;

import com.example.module_javaspringboot_finalproject.dto.BillCheckoutDTO;
import com.example.module_javaspringboot_finalproject.dto.CartProductDTO;
import com.example.module_javaspringboot_finalproject.dto.ProductDTO;
import com.example.module_javaspringboot_finalproject.entities.ProductEntity;
import com.example.module_javaspringboot_finalproject.service.IDefaultSendMailService;
import com.example.module_javaspringboot_finalproject.service.IProductService;
import com.example.module_javaspringboot_finalproject.service.IUserService;
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
    @Autowired
    IProductService iProductService;


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
    public void sendMailToPayCart(String email, BillCheckoutDTO model, List<CartProductDTO> list) {

        this.mailService.sendMailCheckout(
                "chiphongteo1123@gmail.com",
                email,
                "Test sent mail Notiface",
                "Checkout Success !!! ",
                model,
                list
        );
    }

    @Override
    public void setAmountProductAfterCheckout(List<CartProductDTO> list) {
        list.stream().forEach(pro -> {
            iProductService.setAmountProduct(pro.getId(), pro.getAmountCart());
        });
    }
}
