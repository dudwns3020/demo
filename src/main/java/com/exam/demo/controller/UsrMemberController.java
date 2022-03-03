package com.exam.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.demo.service.MemberService;
import com.exam.demo.util.Ut;
import com.exam.demo.vo.Member;
import com.exam.demo.vo.ResultData;

@Controller
public class UsrMemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("usr/member/doJoin")
	@ResponseBody
	public ResultData doJoin(String loginId, String loginPw, String name) {

		if (Ut.empty(loginId)) {
			return ResultData.from("loginId(을)를 입력해주세요.");
		}
		if (Ut.empty(loginPw)) {
			return ResultData.from("loginPw(을)를 입력해주세요.");
		}
		if (Ut.empty(name)) {
			return ResultData.from("name(을)를 입력해주세요.");
		}

		ResultData joinRd = memberService.join(loginId, loginPw, name);

		if (joinRd.isFail()) {
			return joinRd;
		}
		
		Member member = memberService.getMemberById(joinRd.getData1());

		return ResultData.newData(joinRd, member);
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
		
		if (Ut.empty(loginId)) {
			return "loginId(을)를 입력해주세요.";
		}
		if (Ut.empty(loginPw)) {
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
		
		return Ut.f("%s 님 환영합니다.", loginId);
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
