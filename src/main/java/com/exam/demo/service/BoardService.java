package com.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.demo.repository.BoardRepository;
import com.exam.demo.vo.Board;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;

	public Board getBoardId(int id) {
		return boardRepository.getBoardId(id);
	}

}