package com.example.basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Data
public class ShopTagTb {
    @Id
    @Column(length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer seq;
    
  @ManyToOne
  @JoinColumn(name = "SHOP_ID")
  ShopTb shopTb;
  @ManyToOne
  @JoinColumn(name="tag_id")
  TagTb tagTb;
}
