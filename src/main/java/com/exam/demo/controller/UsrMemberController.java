package com.exam.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.demo.service.MemberService;
import com.exam.demo.util.Ut;
import com.exam.demo.vo.Member;
import com.exam.demo.vo.ResultData;
import com.exam.demo.vo.Rq;

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

		Member member = memberService.getMemberById((int) joinRd.getData1());

		return ResultData.newData(joinRd, member);
	}

	@RequestMapping("usr/member/doLogin")
	@ResponseBody
	public String doLogin(HttpServletRequest req, String loginId, String loginPw) {
//		boolean isLogined = false;
//
//		if (httpSession.getAttribute("loginedMemberId") != null) {
//			isLogined = true;
//		}
		
		Rq rq = (Rq)req.getAttribute("rq");
		
		if (rq.isLogined()) {
			return Ut.jsHistoryBack("이미 로그인 되었습니다.");
		}

		if (Ut.empty(loginId)) {
			return Ut.jsHistoryBack("loginId(을)를 입력해주세요.");
		}
		if (Ut.empty(loginPw)) {
			return Ut.jsHistoryBack("loginPw(을)를 입력해주세요.");
		}

		Member member = memberService.getMemberLoginId(loginId);

		if (member == null) {
			return Ut.jsHistoryBack("존재하지 않는 아이디입니다.");
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			return Ut.jsHistoryBack("비밀번호가 일치하지 않습니다.");
		}

//		httpSession.setAttribute("loginedMemberId", member.getId());
		rq.login(member);

		return Ut.jsReplace(Ut.f("%s 님 환영합니다.", loginId), "/");
	}

	@RequestMapping("usr/member/login")
	public String login() {
		return "usr/member/login";
	}

	@RequestMapping("usr/member/doLogout")
	@ResponseBody
	public String doLogout(HttpServletRequest req, String loginId) {
//		boolean isLogined = false;
//
//		if (httpSession.getAttribute("loginedMemberId") == null) {
//			isLogined = true;
//		}
		Rq rq = (Rq)req.getAttribute("rq");
		
		if (!rq.isLogined()) {
			return Ut.jsHistoryBack("이미 로그아웃 되었습니다.");
		}

//		httpSession.removeAttribute("loginedMemberId");
		rq.logout();

		return Ut.jsReplace("로그아웃 되었습니다.", "/");
	}

}
