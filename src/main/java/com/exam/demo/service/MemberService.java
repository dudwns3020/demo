package com.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.demo.repository.MemberRepository;
import com.exam.demo.util.Ut;
import com.exam.demo.vo.Member;
import com.exam.demo.vo.ResultData;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	public String join(String loginId, String loginPw, String name) {
		Member joinedMember = getMemberLoginId(loginId);

		if (joinedMember != null) {//오류
//			return ResultData.from(Ut.f("해당 로그인 아이디(%s)는 이미 사용중입니다.", loginId));
			return Ut.f("해당 로그인 아이디(%s)는 이미 사용중입니다.", loginId);
		}

		memberRepository.join(loginId, loginPw, name);

		int id = memberRepository.getLastInsertId();
		
//		return ResultData.from(Ut.f("회원가입이 완료되었습니다."), id);
		return Ut.f("회원가입이 완료되었습니다.", id);
	}

	public  Member getMemberId(int id) {
		return memberRepository.getMemberById(id);
	}

	public Member getMemberLoginId(String loginId) {
		return memberRepository.getMemberLoginId(loginId);
	}
}