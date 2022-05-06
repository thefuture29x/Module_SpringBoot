package com.example.module_javaspringboot_finalproject.service;

import com.example.module_javaspringboot_finalproject.dto.BillCheckoutDTO;
import com.example.module_javaspringboot_finalproject.dto.CartProductDTO;
import com.example.module_javaspringboot_finalproject.dto.ProductDTO;
import com.example.module_javaspringboot_finalproject.entities.ProductEntity;

import java.util.List;

public interface IDefaultSendMailService {
    void sendMailResetPassword(String email);
    void sendMailToPayCart(String email, BillCheckoutDTO model, List<CartProductDTO> list);
    void setAmountProductAfterCheckout(List<CartProductDTO> list);
}
