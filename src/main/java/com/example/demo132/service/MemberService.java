package com.example.demo132.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo132.dto.BookDto;
import com.example.demo132.dto.MemberDto;
import com.example.demo132.dto.PageDto;
import com.example.demo132.dto.SearchDto;
import com.example.demo132.mapper.MemberMapper;

@Service
public class MemberService {
    @Autowired
    MemberMapper mapper;

    public Map<String, Object> selectMemberList(SearchDto searchDto) {
        Map<String, Object> map = new HashMap<>();

        List<MemberDto> list = mapper.selectMemberList(searchDto);
        map.put("list", list);

        int totalCnt = mapper.selectTotalCnt(searchDto);

        PageDto pageDto = new PageDto(searchDto, totalCnt);
        map.put("pageDto", pageDto);

        return map;
    }

    public MemberDto selectMemberDetail(MemberDto member) {
        return mapper.selectMemberDetail(member);
    }

    public int deleteMember(String mem_no) {
        return mapper.deleteMember(mem_no);
    }

    public int updateMember(MemberDto member) {
        return mapper.updateMember(member);
    }
}
