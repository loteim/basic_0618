package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.ShopTb;

public interface ShopTbRepository extends JpaRepository<ShopTb, Integer>{
    public ShopTb findByShopName(String shopName);
    
}
