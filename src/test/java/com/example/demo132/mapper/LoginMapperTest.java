package com.example.demo132.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo132.dto.MemberDto;

@SpringBootTest
public class LoginMapperTest {
  @Autowired
  LoginMapper mapper;

  @Test
  void testLogin() {
    MemberDto member = new MemberDto();
    member.setId("ID01");
    MemberDto loginMember = mapper.login(member);
    assertNotNull(loginMember);
  }
}
