package com.exam.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.demo.service.MemberService;
import com.exam.demo.vo.Member;

@Controller
public class UsrMemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("usr/member/doJoin")
	@ResponseBody
	public Object doJoin(String loginId, String loginPw, String name) {

		if (loginId == null) {
			return "loginId(을)를 입력해주세요.";
		}
		if (loginPw == null) {
			return "loginPw(을)를 입력해주세요.";
		}
		if (name == null) {
			return "name(을)를 입력해주세요.";
		}

		int id = memberService.join(loginId, loginPw, name);

		if (id == -1) {
			return "사용중인 아이디입니다.";
		}
		
		Member member = memberService.getMemberId(id);

		return member;
	}
	
	@RequestMapping("usr/member/doLogin")
	@ResponseBody
	public String doLogin(HttpSession httpSession, String loginId, String loginPw) {
		boolean isLogined = false;
		
		if (httpSession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
		}
		if(isLogined) {
			return "이미 로그인 되었습니다.";
		}
		
		if (loginId == null) {
			return "loginId(을)를 입력해주세요.";
		}
		if (loginPw == null) {
			return "loginPw(을)를 입력해주세요.";
		}
		
		Member member = memberService.getMemberLoginId(loginId);
		
		if(member == null) {
			return "존재하지 않는 아이디입니다.";
		}
		
		if(member.getLoginPw().equals(loginPw) == false) {
			return "비밀번호가 일치하지 않습니다.";
		}
		
		httpSession.setAttribute("loginedMemberId", member.getId());
		
		return loginId + "님 환영합니다.";
	}
	
	@RequestMapping("usr/member/doLogout")
	@ResponseBody
	public String doLogout(HttpSession httpSession, String loginId) {
		boolean isLogined = false;
		
		if(httpSession.getAttribute("loginedMemberId") == null) {
			isLogined = true;
		}
		if(isLogined) {
			return "이미 로그아웃 되었습니다.";
		}
		
		httpSession.removeAttribute("loginedMemberId");

		return "로그아웃 되었습니다.";
	}

}
