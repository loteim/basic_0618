package com.example.basic.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper {
  public List<Map<String, Object>> select(
    String ename);

}