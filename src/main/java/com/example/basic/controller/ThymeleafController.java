package com.example.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.basic.entity.Emp;
import com.example.basic.entity.Hospital;
import com.example.basic.repository.EmpRepository;
import com.example.basic.repository.HospitalRepository;
import com.example.basic.service.HospitalService;

@Controller
public class ThymeleafController {
  @Autowired
  EmpRepository empRepository;

  @GetMapping("/user")
  public String user(Model model) {
    Map<String, Object> user = null;
    user = new HashMap<>();
    user.put("userId", "z");
    user.put("userName", "zoo");
    user.put("userAge", 25);
    model.addAttribute("user", user);
    return "user";
  }

  @GetMapping("userList")
  public String userList(Model model) {
    List<Map<String, Object>> userList = new ArrayList<>();
    Map<String, Object> user = null;
    user = new HashMap<>();
    user.put("userId", "a");
    user.put("userName", "apple");
    user.put("userAge", 21);
    userList.add(user);
    user = new HashMap<>();
    user.put("userId", "b");
    user.put("userName", "banana");
    user.put("userAge", 22);
    userList.add(user);
    user = new HashMap<>();
    user.put("userId", "c");
    user.put("userName", "carrot");
    user.put("userAge", 23);
    userList.add(user);
    model.addAttribute("userList", userList);
    return "userList";
  }

  @GetMapping("pagination")
  public String pagination(
      Model model, @RequestParam(defaultValue = "1") int page) {
    int startPage = (page - 1) / 10 * 10 + 1;
    int endPage = startPage + 9;
    model.addAttribute("startPage", startPage);
    model.addAttribute("endPage", endPage);
    model.addAttribute("page", page);
    return "pagination";
  }

  @GetMapping("linkUrl")
  public String linkUrl(
  Model model, @RequestParam(defaultValue = "1") int page) {
  int startPage = (page - 1) / 10 * 10 + 1;
  int endPage = startPage + 9;
  model.addAttribute("startPage", startPage);
  model.addAttribute("endPage", endPage);
  model.addAttribute("page", page);
  return "linkUrl";
  }
  
  @GetMapping("mode")
  public String mode(
      Model model, @RequestParam Map<String, Object> map) {
    model.addAttribute("now", map.get("now") == null ? "am" : map.get("now"));
    // 값이 없으면 기본 값 오전, 값이 있으면 넘어온 값 그대로
    model.addAttribute("name", map.get("name"));
    model.addAttribute("auth", map.get("auth"));
    model.addAttribute("category", map.get("category"));
    return "mode";
  }
  @GetMapping("layout1")
  public String layout1() {
  return "layout1";
  }
  @GetMapping("layout2")
  public String layout2() {
  return "layout2";
  }
  @GetMapping("insert1")
  public String insert1() {
  return "insert1";
  }
  @GetMapping("/welcome")
  public String welcome(Model model) {
    List<Emp> eList = empRepository.findAll();
    model.addAttribute("eList", eList);

    List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");

    Map<String, Object> map = new HashMap<>();
    map.put("k1", "값1");
    map.put("k2", "값2");

    model.addAttribute("list", list);
    model.addAttribute("map", map);

    return "welcome";
  }
  @Autowired HospitalRepository hospitalRepository;

  
  // @GetMapping("linkUrl")
  // public String linkUrl(
  // Model model, @RequestParam(defaultValue = "1") int page) {
  // int startPage = (page - 1) / 10 * 10 + 1;
  // int endPage = startPage + 9;
  // model.addAttribute("startPage", startPage);
  // model.addAttribute("endPage", endPage);
  // model.addAttribute("page", page);
  // return "linkUrl";
  // }
  @Autowired HospitalService hospitalService;
  @GetMapping("/html/hospital")
  public String hospital(@RequestParam(defaultValue = "1") int page,Model model) {
    //html을 쓰기위해선 String 값을 전달해야함
    //model로 보내야함
   int startPage = (page - 1) / 10 * 10 + 1;
   int endPage = startPage + 9;
    // Map<String, Object> map = new HashMap<>();
        // Order sido = Order.asc("sido");
        // Order name = Order.desc("name");
        // Sort sort = Sort.by(sido, name);
    //properti는 오름차순 고정
    //2번쨰는 정할순 있지만 한방향으로만 가능
    //order은 각각 따로 지정이 가능
        // Pageable pageable = PageRequest.of(page-1,10,sort);
        // Page<Hospital> p = hospitalRepository.findAll(pageable);
    Page<Hospital> p = hospitalService.getList(page);
    List<Hospital> list = p.getContent();

    // map.put("hos", list); 안나옴
    // map.put("page", page); 안나옴

    int num = p.getNumber(); // 현재 페이지? (0이 첫번째 기준)
    int num2 = p.getNumberOfElements(); // 현재 요소 갯수?
    int size = p.getSize(); // 최대 요소 개수?
    int total = p.getTotalPages(); // 전체 페이지
    if(endPage > total){
      endPage = total;
    }
    System.out.printf("%s %s %s %s", num,num2,size, total);

    model.addAttribute("list",list);
    model.addAttribute("startPage", startPage);

    model.addAttribute("endPage", endPage);  
    model.addAttribute("totalPage", total);      
    
    model.addAttribute("page", page);
    return "hospital";
  }


}
