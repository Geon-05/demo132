package com.example.demo132.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo132.dto.UploadDto;

@SpringBootTest
public class UploadMapperTest {
  @Autowired
  UploadMapper mapper;

  @Test
  void testInsertUpload() {
    UploadDto data = new UploadDto();
    data.setIdx(1);
    data.setOname("oname01");
    data.setSname("sname01");
    data.setPath("d:/upload/book");
    data.setFile_type(".jpg");

    int res = mapper.insertUpload(data);
    assertEquals(1, res);
  }
}
