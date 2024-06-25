package com.example.basic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Hospital {
  @Id
  Integer id;
  @Column(length = 50, nullable = false)
  String sido;
  @Column(length = 50, nullable = false)
  String name;
  Integer medical;
  Integer room;
  @Column(length = 15, nullable = false)
  String tel;
  @Column(length = 100, nullable = false)
  String address;
}
