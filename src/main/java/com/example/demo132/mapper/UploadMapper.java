package com.example.demo132.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo132.dto.UploadDto;

@Mapper
public interface UploadMapper {
  public int insertUploadMulti(UploadDto uploadDto);

  public int selectSeqUploadFile();
  
  public List<UploadDto> selectUpload(int f_no);
}
