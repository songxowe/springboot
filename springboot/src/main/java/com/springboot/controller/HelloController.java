package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 以 json 响应数据, 无需配置 jackson
public class HelloController {

  @RequestMapping("hellospringboot")
  public String hello() {
    return "Hello Spring Boot.";
  }

}
