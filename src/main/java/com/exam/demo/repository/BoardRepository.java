package com.exam.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.exam.demo.vo.Board;

@Mapper
public interface BoardRepository {

	@Select("""
			SELECT *
			FROM board AS B
			WHERE B.id = #{id}
			""")
	Board getBoardId(@Param("id") int id);

}
