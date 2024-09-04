package com.example.demo132.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo132.dto.MemberDto;

@Mapper
public interface LoginMapper {
  public MemberDto login(MemberDto member);

  public int insertUser(MemberDto member);

  public int selectCheckId(String id);
}
