package com.example.module_javaspringboot_day4.dto;

public class StatisticalDTO {
    private String name_product;
    private int amount;
    private int price;
    private int total;

    public StatisticalDTO() {
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public StatisticalDTO(String name_product, int amount, int price, int total) {
        this.name_product = name_product;
        this.amount = amount;
        this.price = price;
        this.total = total;
    }
}
