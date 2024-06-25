package com.example.basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Data
public class FavoriteTb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name="SHOP_ID")
    ShopTb shopTb;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    UserTb userTb;

    @Column(length = 20)
    String regDate;
}
