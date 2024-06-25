package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.UserTb;

public interface UserTbRepository extends JpaRepository<UserTb, Integer>{
    public UserTb findByUserName(String userName);
    
}
