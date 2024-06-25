package com.example.basic.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "course_list")
public class Major {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(length = 255, nullable = true)
  String name;

  @Column(name = "max_prsn", nullable = false)
  Integer maxPrsn;

  @Column(name = "ebtb_date", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  Date ebtbDate;

  @OneToMany(mappedBy = "major", fetch = FetchType.EAGER)
  List<Course> course_list = new ArrayList<>();
}
