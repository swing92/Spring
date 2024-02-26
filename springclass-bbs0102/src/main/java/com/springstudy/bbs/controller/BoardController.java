package com.springstudy.bbs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springstudy.bbs.domain.Board;
import com.springstudy.bbs.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	//@RequestMapping("/writeProcess")
	// 파라미터를 받아서 도메인 객체로 넘겨주는 커멘트 객체
	@PostMapping("/writeProcess")
	public String insertBoard(Board board) {
		
		// 입력 - Board 객체로 만들어서	
		// 게시 글 등록 => service
		
		// 최종적으로 응답 
		return "redirect:boardList";
		
	}
	
	
	
	@GetMapping("/boardDetail")
	public String boardDetail(Model model, int no) {
		
		Board board = service.getBoard(no);
		model.addAttribute("board", board);
		
		return "/boardDetail";
	}
	
	
	@RequestMapping(value={"/boardList", "/list"}, method=RequestMethod.GET)
	public String boardList(Model model) {
		
		// 1. 입력
		//String page = request.getParameter("page");
		
		// 2. 요청에 대한 처리를 하고 결과 데이터 - 게시 글 리스트 - 모델(model)
		List<Board> bList = service.boardList();
		model.addAttribute("bList", bList);
		
		// 3. 뷰에 결과를 출력
		// 뷰의 이름으로 간주 - viewResolver 설정의 prefix, suffix를 조합해서 물리적인 뷰의 이름이 결정 
		// /WEB-INF/index.jsp?body=views/ + boardList + .jsp
		return "boardList";
	}

	
}
