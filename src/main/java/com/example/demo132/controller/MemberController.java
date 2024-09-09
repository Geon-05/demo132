package com.example.demo132.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo132.dto.BookDto;
import com.example.demo132.dto.MemberDto;
import com.example.demo132.dto.SearchDto;
import com.example.demo132.service.MemberService;



@Controller
public class MemberController {
  @Autowired
  MemberService service;
  
  @GetMapping("/member/memberList")
  public String list(
    SearchDto searchDto, Model model
  ) {
    Map<String, Object> map = service.selectMemberList(searchDto);
    model.addAttribute("map", map);
    
    return "/member/list";
  }
  
  @GetMapping("/member/memberDetail")
  public String detail(
    MemberDto member
    , Model model
  ) {
    MemberDto selectMember = service.selectMemberDetail(member);
    model.addAttribute("member", selectMember);
    return "/member/detail";
  }

  @GetMapping("/member/memberDelete")
  public String getMethodName(
      @RequestParam(name = "mem_no", required = false) String memNo, Model model) {
    if (memNo == null) {
      model.addAttribute("msg", "사용자번호가 입력되지 않았습니다.");
      return "/common/msg";
    }

    int res = service.deleteMember(memNo);

    if (res > 0) {
      model.addAttribute("msg", "삭제 되었습니다.");
      model.addAttribute("url", "/");
    } else {
      model.addAttribute("msg", "삭제 중 예외가 발생 하였습니다.\n관리자에게 문의해주세요");
    }
    return "/common/msg";
  }

  @GetMapping("/member/memberUpdate")
  public String update(
      MemberDto member, Model model) {
    MemberDto selectMember = service.selectMemberDetail(member);
    model.addAttribute("member", selectMember);
    return "/member/update";
  }

  @PostMapping("/member/memberUpdateAction")
  public String updateAction(
    MemberDto member, Model model) {
  int res = service.updateMember(member);
  if (res > 0) {
    return "redirect:/member/memberList";
  } else {
    model.addAttribute("msg", "사용자 정보 수정 중 문제가 발생하였습니다.\n관리자에게 문의하세요.");
    return "/common/msg";
  }
}
  
  
  
}
