package com.springstudy.bbs.service;

import java.util.List;

import com.springstudy.bbs.domain.Board;

public interface BoardService {	
	List<Board> boardList();
	Board getBoard(int no);
	void insertBoard(Board board);
}
