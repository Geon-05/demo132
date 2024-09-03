package com.example.demo132.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo132.dto.UploadDto;
import com.example.demo132.mapper.UploadMapper;

@Service
public class UploadService {
  @Autowired
  UploadMapper mapper;

  public void insertUploadMulti(
      List<MultipartFile> uploadFiles, String path) {
    for (int i = 0; i < uploadFiles.size(); i++) {
      MultipartFile file = uploadFiles.get(i);
      UploadDto uploadDto = makeUploadDto(file, path, i);

      try {
        File uploadFile = new File("d:/upload/" + path + File.separator + uploadDto.getSname());
        file.transferTo(uploadFile);
        mapper.insertUpload(uploadDto);
      } catch (IllegalStateException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void insertUpload(MultipartFile uploadFiles, String path) {
    UploadDto uploadDto = makeUploadDto(uploadFiles, path, 0);

    try {
      File uploadFile = new File("d:/upload/" + path + File.separator + uploadDto.getSname());
      uploadFiles.transferTo(uploadFile);
      mapper.insertUpload(uploadDto);
    } catch (IllegalStateException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private UploadDto makeUploadDto(
      MultipartFile file, String path, int idx) {
    UploadDto uploadDto = new UploadDto();

    uploadDto.setOname(file.getOriginalFilename());
    uploadDto.setSnameValue(file.getOriginalFilename());
    uploadDto.setPath(path);
    uploadDto.setIdx(idx + 1);
    uploadDto.setFile_type(file.getContentType());
    String dir = "d:/upload/" + path + File.separator;
    makeDir(dir);

    return uploadDto;
  }

  private void makeDir(String dir) {
    File uploadDir = new File(dir);
    if (!uploadDir.exists()) {
      uploadDir.mkdirs();
    }
  }
}
