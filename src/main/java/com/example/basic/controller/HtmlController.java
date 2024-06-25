package com.example.basic.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.basic.model.Member;

@Controller
public class HtmlController {
  @GetMapping("html/exam")
  public String htmlExam() {
    return "html/exam";
  }


  @GetMapping("html/string")
  public String htmlString(Model model) {
    model.addAttribute(
      "age", 35);
    return "html/string";
  }

  @GetMapping("html/void")
  public void htmlVoid() {
  }

  @GetMapping("html/map")
  public Map<String, Object> htmlMap() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("age", 30);
    map.put("address", "부산");
    return map;
  }

  @GetMapping("html/model")
  public Model htmlModel(Model model) {
    return model;
  }

  @GetMapping("html/model_and_view")
  public ModelAndView htmlModel() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("html/model_and_view");
    return mav;
  }

  // DTO - Data Transfer Object
  // VO  - Value Object
  // Member import 안됨 -> Member 클래스 작성을 해야 해서
  @GetMapping("html/object")
  public Member htmlObject() {
    Member member = new Member();
    member.setName("kim");
    return member;
  }
}
