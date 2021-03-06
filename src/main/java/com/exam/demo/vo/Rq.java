package com.exam.demo.vo;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.demo.service.MemberService;

import lombok.Getter;

public class Rq {

	@Getter
	private boolean isLogined;
	@Getter
	private int loginedMemberId;
	@Getter
	private Member loginedMemberName;

	private HttpServletRequest req;
	private HttpServletResponse res;
	private HttpSession httpSession;

	public Rq(HttpServletRequest req, HttpServletResponse res, MemberService memberService) {
		this.req = req;
		this.res = res;
		this.httpSession = req.getSession();
//		HttpSession httpSession = req.getSession();

		boolean isLogined = false;
		int loginedMemberId = 0;
		Member loginedMemberName = null;

		if (httpSession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
			loginedMemberName = memberService.getMemberId(loginedMemberId);
		}

		this.isLogined = isLogined;
		this.loginedMemberId = loginedMemberId;
		this.loginedMemberName =loginedMemberName; 
	}

	public void printHistoryBackJs() {
//		try {
//			res.getWriter();
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		res.setContentType("text/html; charset=utf-8");
		print("<script>");
		print("alert('로그인 후 이용해주세요.');");
		print("history.back();");
		print("</script>");
	}

	public void print(String msg) {
		try {
			res.getWriter().append(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void login(Member member) {
		httpSession.setAttribute("loginedMemberId", member.getId());
	}

	public void logout() {
		httpSession.removeAttribute("loginedMemberId");
	}
}
