package com.exam.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.exam.demo.vo.Member;

@Mapper
public interface MemberRepository {

	@Insert("""
			INSERT INTO `member`
			SET regDate = NOW(),
			updateDate = NOW(),
			loginId = #{loginId},
			loginPw = #{loginPw},
			`name` = #{name};
			""")
	void join(@Param("loginId") String loginId, @Param("loginPw") String loginPw, @Param("name") String name);

	@Select("""
			SELECT LAST_INSERT_ID()
			""")
	int getLastInsertId();
	
	@Select("""
			SELECT *
			FROM `member`
			WHERE id = #{id};
			""")
	Member getMemberId(@Param("id") int id);

	@Select("""
			SELECT *
			FROM `member`
			WHERE loginId = #{loginId};
			""")
	Member getMemberLoginId(@Param("loginId") String loginId);

}
