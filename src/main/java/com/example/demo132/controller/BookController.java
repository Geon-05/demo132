package com.example.demo132.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo132.dto.SearchDto;
import com.example.demo132.service.BookService;

@Controller
public class BookController {
  @Autowired
  BookService service;

  @GetMapping("/book/bookList")
  public String getMethodName(
      SearchDto searchDto, Model model) {
    Map<String, Object> map = service.selectBookList(searchDto);
    model.addAttribute("map", map);

    return "/book/list";
  }

}
