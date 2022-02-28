package com.exam.demo.controller;

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
			return "사용중인 아이디입니다";
		}
		
		Member member = memberService.getMemberId(id);

		return member;
	}

}
