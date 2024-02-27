package com.springstudy.bbs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.bbs.dao.BoardDao;
import com.springstudy.bbs.domain.Board;

// 비즈니스 로직을 처리하는 객체 - 필요한 데이터는 BoardDao를 이용해서 가져온다.
@Service
public class BoardServiceImpl implements BoardService {
	
	// 한 페이지에 출력 할 게시글의 수
	private static final int PAGE_SIZE = 10;
	
	// 한 페이지에 보여줄 페이지 그룹(페이지 그룹으로 묶을 페이지의 수)
	private static final int PAGE_GROUP = 10;

	@Autowired
	private BoardDao boardDao;
	
	// 게시 글 삭제하기
	public void deleteBoard(int no) {
		boardDao.deleteBoard(no);		
	}
	
	// 게시 글 수정하기
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}
	
	// 게시 글 수정, 삭제에서 비밀번호 체크
	public boolean isPassCheck(int no, String pass) {
		boolean result = false;
		
		String dbPass = boardDao.isPassCheck(no);
		if(dbPass.equals(pass)) {
			result = true;
		}
		
		return result;
	}
	
	
	@Override
	public Map<String, Object>  boardList(int pageNum) {	
		// 비즈니스 로직 처리 - 페이징 처리
//		int currentPage = pageNum > 0 ? pageNum : 1;
		int currentPage = pageNum;
		
		
		// 현재 페이지의 시작행
		// 1page : 0row
		// 2page : 10row
		// 3page : 20row ...
		int startRow = currentPage * PAGE_SIZE - PAGE_SIZE;
		int listCount = boardDao.getBoardCount();
		
		List<Board> boardList = boardDao.boardList(startRow, PAGE_SIZE);
		
		int pageCount = listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
		
		// 1page : 0 > 1~10 나와야함
		// 5page : 0 > 1~10 나와야함!
		// 9page : 0 > 1~10 나와야해!!
		// 10page : 1 > 1~10
		// 21page : 2 > 21~30
		// 10단위로 뭔가 수정이 피료해.. >> currentPage가 PAGE_GROUP의 배수인 경우에는 PAGE_GROUP만큼 빼줘야해
		int startPage = currentPage / PAGE_GROUP * PAGE_GROUP + 1 -(currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
		
		int endPage = startPage + PAGE_GROUP - 1;
		
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		// 뷰에 출력할 요청 처리결과 데이터(모델)을 Map에 저장
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("bList", boardList);
		modelMap.put("currentPage", currentPage);
		modelMap.put("startPage", startPage);
		modelMap.put("endPage", endPage);
		modelMap.put("PAGE_GROUP", PAGE_GROUP);
		modelMap.put("listCount", listCount);
		modelMap.put("pageCount", pageCount);
		
		boardDao.boardList(0, 10);
		
		return modelMap;
	}

	@Override
	public Board getBoard(int no) {	
		return boardDao.getBoard(no);
	}

	@Override
	public void insertBoard(Board board) {
		boardDao.insertBoard(board);
	}
}
