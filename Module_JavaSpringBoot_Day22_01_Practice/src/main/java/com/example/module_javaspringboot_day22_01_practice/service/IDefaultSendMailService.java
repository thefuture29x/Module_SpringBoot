package com.example.module_javaspringboot_day22_01_practice.service;

import com.example.module_javaspringboot_day22_01_practice.dto.BillCheckoutDTO;
import com.example.module_javaspringboot_day22_01_practice.entities.ProductEntity;

import java.util.List;

public interface IDefaultSendMailService {
    void sendMailResetPassword(String email);
    void sendMailToPayCart(String email, BillCheckoutDTO model, List<ProductEntity> list);
}
