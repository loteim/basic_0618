package com.example.basic.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "demo_a")
@Data
public class Demo2 {
  @Id @GeneratedValue
  long seq;
  @Column(
    name="username", length = 10, nullable = false)
  String userName;
  int userAge;
  String user2;
  int age;
  Date date1;
  LocalDateTime date2;
}
