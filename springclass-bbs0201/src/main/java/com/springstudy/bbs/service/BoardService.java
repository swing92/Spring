package com.springstudy.bbs.service;

import java.util.List;
import java.util.Map;

import com.springstudy.bbs.domain.Board;

public interface BoardService {	
	
	// 게시 글 삭제하기
	void deleteBoard(int no);
	
	// 게시 글 수정하기
	void updateBoard(Board board);
	
	// 게시 글 수정, 삭제에서 비밀번호 체크
	boolean isPassCheck(int no, String pass);
	
	// 게시 글 리스트
	Map<String, Object> boardList(int pageNum);
	
	// 게시 글 상세보기
	Board getBoard(int no);
	
	// 게시 글 쓰기
	void insertBoard(Board board);
}
