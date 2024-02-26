package com.springstudy.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.bbs.dao.BoardDao;
import com.springstudy.bbs.domain.Board;

// 비즈니스 로직을 처리하는 객체 - 필요한 데이터는 BoardDao를 이용해서 가져온다.
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> boardList() {	
		// 비즈니스 로직 처리 - 페이징 처리
		return boardDao.boardList();
	}

	@Override
	public Board getBoard(int no) {	
		return boardDao.getBoard(no);
	}

	@Override
	public void insertBoard(Board board) {
		
	}
}
