package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.entity.Board;

public interface BoradRepository extends JpaRepository<Board, Integer>{
        
}
