package com.example.demo132.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo132.dto.BookDto;
import com.example.demo132.dto.SearchDto;
import com.example.demo132.dto.UploadDto;
import com.example.demo132.service.BookService;
import com.example.demo132.service.UploadService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class BookController {
  @Autowired
  BookService service;

  @Autowired
  UploadService uploadService;

  @GetMapping("/book/bookList")
  public String getMethodName(
      SearchDto searchDto, Model model) {
    Map<String, Object> map = service.selectBookList(searchDto);
    model.addAttribute("map", map);

    return "/book/list";
  }

  @GetMapping("/book/bookInsert")
  public String insert() {
      return "/book/insert";
  }
  
  @PostMapping("/book/bookInsertAction")
  public String insertAction(
    BookDto book
    , Model model
    ) {
    return "";
  }

  @GetMapping("/book/bookDetail")
  public String detail(
    BookDto book
    , Model model
    ) {
      BookDto selectBook = service.selectBookDetail(book);
      model.addAttribute("book", selectBook);

      List<UploadDto> imgFileList = uploadService.selectUploadList(selectBook.getImg_f_no());
      model.addAttribute("imgFileList", imgFileList);
      return "/book/detail";
  }
  

}
