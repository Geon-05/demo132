package com.example.demo132.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo132.dto.MemberDto;
import com.example.demo132.service.LoginService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class LoginController {
  @Autowired
  LoginService service;

  @GetMapping("/login/login")
  public String login() {
      return "/login/login";
  }
  
  @PostMapping("/login/loginAction")
  public String loginAction(
    @RequestParam(name = "chkIdSave", required = false) String chkIdSave
    , HttpServletRequest request
    , HttpServletResponse response
    , HttpSession session
    , MemberDto member
    , Model model
  ) {
    
    Cookie cookie = new Cookie("IdSave", member.getId());
    cookie.setPath("/");

    if ("1".equals(chkIdSave)) {
      cookie.setMaxAge(60*60*24*7);
    } else {
      cookie.setMaxAge(0);
    }
    response.addCookie(cookie);

    MemberDto loginMember = service.login(member);

    if (loginMember != null){
      session.setAttribute("loginId", loginMember.getId());
      session.setAttribute("loginName", loginMember.getName());

      return "redirect:/book/bookList";
    } else {
      model.addAttribute("msg", "아이디 비밀번호를 확인해주세요.");

      return "common/msg";
    }
  }

  @GetMapping("/login/loginRegister")
  public String getMethodName() {
      return "/login/register";
  }
  
  @PostMapping("/login/loginRegisterAction")
  public String postMethodName(
    MemberDto member
    , Model model
  ) {
      int res = service.insertUeser(member);

      if (res > 0) {
        model.addAttribute("msg", "로그인 후 이용이 가능합니다.");
        model.addAttribute("url", "/login/login");
        return "/common/msg";
      } else {
        model.addAttribute(("msg"), "입력중 예외가 발생하였습니다.\n관리자에게 문의하세요.");
        return "/common/msg";
      }
      
  }
  
  
}
