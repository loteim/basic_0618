package com.example.basic.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MethodController {
  @PostMapping("req/post2")
  public String post() {
    return "POST";
  }
  
  @GetMapping("req/signup")
  public String signup() {
    // templates/signup.html
    return "html/signup";
  }

  @PostMapping("req/signup")
  @ResponseBody
  public Map<String, Object> signupPost(
    @RequestBody Map<String, Object> map) {
    return map;
  }

}
