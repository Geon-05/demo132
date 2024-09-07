package com.example.demo132.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MemberController {
  @GetMapping("/member/memberDetail")
  public String getMethodName() {
      return "/member/detail";
  }
  
}
