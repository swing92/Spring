package com.springstudy.bbs.dao;

import java.util.List;

import com.springstudy.bbs.domain.Board;

public interface BoardDao {
	public abstract List<Board> boardList();
	Board getBoard(int no);
	void insertBoard(Board board);
}
