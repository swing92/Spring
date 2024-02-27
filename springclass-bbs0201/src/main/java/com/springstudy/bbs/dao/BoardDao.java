package com.springstudy.bbs.dao;

import java.util.List;

import com.springstudy.bbs.domain.Board;

public interface BoardDao {
	
	// no에 해당하는 비밀번호을 db 테이블에서 읽어오는 메서드
	public abstract String isPassCheck(int no);	
	public abstract List<Board> boardList(int startRow, int num);
	Board getBoard(int no);
	void insertBoard(Board board);
	void updateBoard(Board board);
	void deleteBoard(int no);
	int getBoardCount();
}
