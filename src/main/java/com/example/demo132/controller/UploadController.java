package com.example.demo132.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo132.service.UploadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UploadController {
  @Autowired
  UploadService service;

  @GetMapping("/upload")
  public String getMethodName() {
      return "/upload";
  }

  @PostMapping("/uploadAction")
  public String postMethodName(
    @RequestPart(name="file",required=false) MultipartFile file
    , Model model) {
      service.insertUpload(file, "file");
      return "/upload";
  }

  @PostMapping("/uploadActionMultiple")
  public String postMethodName(
    @RequestPart(name="uploadFiles",required=false) List<MultipartFile> uploadFiles) {
      service.insertUploadMulti(uploadFiles, "multiple");
      
      return "/upload";
  }
  
}