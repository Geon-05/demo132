package com.example.demo132;

import java.net.*;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * 인터셉터
 * 컨트롤러에 들어오는 요청과 컨트롤러의 응답을 가로채는 역할
 * 로그인 체크, 권한체크등의 처리
 * 로그처리, 오류발생시 오류내역을 테이블에 저장하기 등
 * 
 * 인터셉터를 정의
 * HandlerInterceptor를 구현
 * 
 * 설정파일에 여러개의 인터셉터를 등록 하여 사용 할 수 있다.
 */
public class LoginInterceptor implements HandlerInterceptor {
  /**
   * 컨트롤러에 요청을 보내기 전에 가로채기
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession();

    // 로그인했는지 확인
    // null이 아니고 빈 문자열이 아니면 로그인 했다고 판단
    if(session.getAttribute("loginId") == null || "".equals((String)session.getAttribute("loginId"))){

      // 한글로된 파라메터를 전달하기 위해서 URLEncoder를 사용
      // 쿼리스트링으로 전달 되므로 화면에서 출력하기 위해서는 param.msg를 이용!
      String msg = URLEncoder.encode("로그인 후 이용이 가능 합니다.", "utf-8");
      // 서블릿을 통해서 리다이렉트
      // 로그인을 하지 않은 경우 로그인 페이지로 이동
      response.sendRedirect("/login/login?msg="+msg);
      // Model.setAttribute랑 동일
      // request.setAttribute("msg", "로그인 후 이용이 가능 합니다.");

      return false;
    }
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }
}
