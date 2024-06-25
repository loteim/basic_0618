package com.example.basic.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class TagTb {
    @Id
    @Column(name="TAG_ID", length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer tagid;
    @Column(length = 30)
    String tagName;
    @Column(length = 11, nullable = true)
    Integer hitCnt;
    @OneToMany(mappedBy = "tagTb")
    List<ShopTagTb> shopTagTbList = new ArrayList<>();
}

// @Entity
// @Data
// public class BoardFileTest {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  Integer id;