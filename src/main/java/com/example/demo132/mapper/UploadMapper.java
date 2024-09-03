package com.example.demo132.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo132.dto.UploadDto;

@Mapper
public interface UploadMapper {
  public int insertUpload(UploadDto uploadDto);
}
