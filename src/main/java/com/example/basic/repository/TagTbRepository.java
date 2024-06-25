package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.TagTb;

public interface TagTbRepository  
extends JpaRepository<TagTb, Integer> {
    
}
