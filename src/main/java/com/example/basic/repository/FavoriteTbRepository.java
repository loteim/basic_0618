package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.FavoriteTb;

public interface FavoriteTbRepository extends JpaRepository<FavoriteTb, Integer>{
    
}
