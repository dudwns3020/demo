package com.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.demo.repository.MemberRepository;
import com.exam.demo.vo.Member;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	public int join(String loginId, String loginPw, String name) {
		Member joinedMember = getMemberLoginId(loginId);

		if (joinedMember != null) {
			return -1;
		}

		memberRepository.join(loginId, loginPw, name);

		return memberRepository.getLastInsertId();
	}

	public Member getMemberId(int id) {
		return memberRepository.getMemberId(id);
	}

	public Member getMemberLoginId(String loginId) {
		return memberRepository.getMemberLoginId(loginId);
	}
}