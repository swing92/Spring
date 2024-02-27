package com.springstudy.bbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springstudy.bbs.domain.Board;

// SqlSessionTemplate을 사용해서 DB 접근해서 데이터를 읽어오는 클래스
@Repository
public class BoardDaoImpl implements BoardDao {
	
	private static final String NAME_SPACE = "com.springstudy.bbs.mapper.BoardMapper";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public void deleteBoard(int no) {
		sqlSession.delete(NAME_SPACE + ".deleteBoard", no);
	}
	
	
	public void updateBoard(Board board) {
		sqlSession.update(NAME_SPACE + ".updateBoard", board);
	}
	
	public String isPassCheck(int no) {
		return sqlSession.selectOne(NAME_SPACE + ".isPassCheck", no);
	}	
	
	public int getBoardCount() {
		return sqlSession.selectOne(NAME_SPACE + ".getBoardCount");
	}

	@Override
	public List<Board> boardList(int startRow, int num) {
		// 쿼리로 넘겨야 할 데이터
		Map<String, Object> param = new HashMap<>();
		param.put("startRow", startRow);
		param.put("num", num);		
		
		return sqlSession.selectList(NAME_SPACE + ".boardList", param);
	}

	@Override
	public Board getBoard(int no) {
		return sqlSession.selectOne(NAME_SPACE + ".getBoard", no);
	}

	@Override
	public void insertBoard(Board board) {
		sqlSession.insert(NAME_SPACE + ".insertBoard", board);
	}

}
