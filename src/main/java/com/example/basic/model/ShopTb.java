package com.example.basic.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class ShopTb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SHOP_ID")
    Integer Id;
    
    @Column(name="SHOP_NAME", length = 200)
    String shopName;
    @Column(name="SHOP_DESC",length = 255)
    String shopDesc;
    @Column(name="ADDRESS", length = 255)
    String address;
    @Column(length = 11)
    String telNum;
    @Column(name="PARKING_INFO",length = 255)
    String parkingInfo;
    @Column(name="LATITUDE",length = 20)
    String latitude;
    @Column(name="LONGITUDE",length = 20)
    String longitude;
    @Column(name="REG_DATE",length = 20)
    String regDate;
    @OneToMany(mappedBy = "shopTb")
    List<ShopTagTb> shopTagTbList = new ArrayList<>();
    @OneToMany(mappedBy = "shopTb")
    List<FavoriteTb> favoriteTbList = new ArrayList<>();
}
