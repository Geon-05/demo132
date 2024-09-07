package com.example.demo132.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;

import com.example.demo132.service.UploadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UploadController {
  @Autowired
  UploadService service;

  @GetMapping("/upload")
  public String getMethodName() {
    return "/upload";
  }

  @PostMapping("/uploadActionMultiple")
  public String postMethodName(
      @RequestPart(name = "uploadFiles", required = false) List<MultipartFile> uploadFiles
      ) throws IllegalStateException, IOException {
    service.insertUploadMulti(uploadFiles, "multiple");

    return "redirect:/upload";
  }

  @GetMapping("/download")
  public ResponseEntity<byte[]> getMethodName(
      @RequestParam(name = "fileName") String fileName, @RequestParam(name = "oname") String oname) throws IOException {
    File file = new File("d:/upload/" + fileName);

    HttpHeaders headers = new HttpHeaders();

    try {
      if (file.exists()) {
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
          mimeType = MediaType.APPLICATION_OCTET_STREAM.toString();
        }
        headers.add("Content-Type", mimeType);
        headers.add("Content-Disposition", "attachment; filename=\""
            + new String(oname.getBytes("UTF-8"), "ISO-8859-1") + "\"");

        return new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (UnsupportedEncodingException e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}