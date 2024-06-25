package com.example.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.basic.intreceptor.IPCheckInterceptor;
import com.example.basic.intreceptor.ServerCheckInterceptor;
import com.example.basic.intreceptor.SignInCheckInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
@Autowired
private SignInCheckInterceptor signInCheckInterceptor;
@Autowired
private IPCheckInterceptor ipCheckInterceptor;
@Autowired ServerCheckInterceptor serverCheckInterceptor;
@Override
public void addInterceptors(InterceptorRegistry registry) {
registry.addInterceptor(signInCheckInterceptor).addPathPatterns("/main");
registry.addInterceptor(ipCheckInterceptor).addPathPatterns("/visitor");
registry.addInterceptor(serverCheckInterceptor).addPathPatterns("/html/hospital");

WebMvcConfigurer.super.addInterceptors(registry);
}
}