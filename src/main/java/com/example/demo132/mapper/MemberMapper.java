package com.example.demo132.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.example.demo132.dto.MemberDto;
import com.example.demo132.dto.SearchDto;

@Mapper
public interface MemberMapper {
    public MemberDto selectMemberDetail(MemberDto member);

    public List<MemberDto> selectMemberList(SearchDto searchDto);
    
    public int selectTotalCnt(SearchDto searchDto);

    public int deleteMember(String mem_no);

    public int updateMember(MemberDto member);
}
