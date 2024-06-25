package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.ShopTagTb;
import com.example.basic.model.ShopTb;

public interface ShopTagTbRepository extends JpaRepository<ShopTagTb, Integer>{
    
}
