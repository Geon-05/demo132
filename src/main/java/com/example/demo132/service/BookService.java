package com.example.demo132.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo132.dto.BookDto;
import com.example.demo132.dto.PageDto;
import com.example.demo132.dto.SearchDto;
import com.example.demo132.mapper.BookMapper;

@Service
public class BookService {
  @Autowired
  BookMapper mapper;

  public Map<String, Object> selectBookList(SearchDto searchDto){
    Map<String, Object> map = new HashMap<>();

    List<BookDto> list = mapper.selectBookList(searchDto);
    map.put("list", list);

    int totalCnt = mapper.selectTotalCnt(searchDto);

    PageDto pageDto = new PageDto(searchDto, totalCnt);
    map.put("pageDto", pageDto);

    return map;
  }

  public BookDto selectBookDetail(BookDto book){
    return mapper.selectBookDetail(book);
  }

  public int insertBook(BookDto book){
    return mapper.insertBook(book);
  }

  public int deleteBook(String book_no) {
    return mapper.deleteBook(book_no);
}
}
