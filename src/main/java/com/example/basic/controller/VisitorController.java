package com.example.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

public class VisitorController {
    @GetMapping("/visitor")
public String visitor(
@RequestHeader("user-agent") String userAgent) {
return userAgent;
}
}
