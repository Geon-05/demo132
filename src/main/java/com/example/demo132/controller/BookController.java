package com.example.demo132.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {
  @GetMapping("/book/bookList")
  public String getMethodName() {
      return "/book/list";
  }
  
}
