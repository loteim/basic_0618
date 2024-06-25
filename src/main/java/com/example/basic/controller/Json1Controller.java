package com.example.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.model.Member;

@Controller
public class Json1Controller {
  @GetMapping("json/exam")
  @ResponseBody
  public Map<String, Object> jsonExam() {
    Map<String, Object> map = new HashMap<>();
    map.put("count", 2);

    List<Map<String, Object>> list = new ArrayList<>();
    Map<String, Object> innerMap1 = new HashMap<>();
    innerMap1.put("name", "가");
    innerMap1.put("userId", "A");
    innerMap1.put("userPassword", "1");
    list.add(innerMap1);
    Map<String, Object> innerMap2 = new HashMap<>();
    innerMap2.put("name", "나");
    innerMap2.put("userId", "B");
    innerMap2.put("userPassword", "2");
    list.add(innerMap2);

    map.put("list", list);

    return map;
  }

  @GetMapping("json1/string")
  @ResponseBody
  public String json() {
    return "json/string";
  }

  @GetMapping("json1/map")
  @ResponseBody
  public Map<String, Object> jsonMap(Map<String, Object> map) {
    Map<String, Object> map2 = new HashMap<String, Object>();
    map2.put("key1", "value");
    map2.put("key2", 2324);
    map2.put("key3", true);
    return map2;
  }

  @GetMapping("json1/object")
  @ResponseBody
  public Member jsonObject() {
    Member member = new Member();
    member.setName("kim");
    return member;
  }

}
