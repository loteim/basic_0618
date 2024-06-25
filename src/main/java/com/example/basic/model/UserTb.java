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
public class UserTb {
    @Id
    @Column(name="USER_ID",length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    @Column(length = 20)
    String userName;
    @Column(length = 50)
    String email;
    @Column(length = 255)
    String pass;
    @Column(length = 15, nullable = true)
    String phoneNum;
    @Column(length = 20)
    String regDate;


    @OneToMany(mappedBy = "userTb")
    List<FavoriteTb>favoriteTbList = new ArrayList<>();
    
}
