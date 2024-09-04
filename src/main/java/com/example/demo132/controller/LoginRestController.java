package com.example.demo132.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo132.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class LoginRestController {
  @Autowired
  LoginService service;

  @GetMapping("/checkId/{id}")
  public Map<String, Object> getMethodName(@PathVariable(name = "id") String id) {
    Map<String, Object> map = new HashMap<>();
    
    int res = service.selectCheckId(id);
    map.put("restest", res);
    
    return map;
  }
  
}
