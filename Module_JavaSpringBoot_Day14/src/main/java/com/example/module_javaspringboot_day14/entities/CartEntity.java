package com.example.module_javaspringboot_day14.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;

@Entity
@Table(name = "cart_product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "amount_cart")
    private int amountCart;
    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "id_product")
    private Long idProduct;
    private String name;
    private int price;
    private String description;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id",referencedColumnName = "id")
//    private ProductEntity productEntity;

}
