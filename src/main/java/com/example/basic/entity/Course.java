package com.example.basic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;
  
  @Column(length = 50, nullable = false)
  String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "major_id", nullable = false)
  Major major;
}
