package com.example.basic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Board {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)  
Integer id;  
String title;
}
