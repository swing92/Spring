package com.springstudy.bbs.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springstudy.bbs.domain.Board;
import com.springstudy.bbs.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@PostMapping("/delete")
	public String delete(Model model, String pass, int no,
			PrintWriter out, HttpServletResponse response) {
		
		// 비밀번호가 맞는지 체크
		boolean result = service.isPassCheck(no, pass);
		
		// 비밀번호가 맞지 않으면 - 사용자에게 알림을 응답하고 프로그램 종료
		if(!result) {
			// 응답을 직접 생성
			response.setContentType("text/html; charset=utf-8");
			out.println("<script>");
			out.println("	alert('비밀번호가 맞지 않음');");
			out.println("	history.back();");
			out.println("</script>");
			return null;
		}
		
		// 비밀번호가 맞으면 게시 글을 삭제
		service.deleteBoard(no);
		
		// 게시 글 삭제가 완료되면 게시 글 리스트로 redirect
		return "redirect:boardList";
	}
	
	
	@PostMapping("/updateProcess")
	public String update(Model model, Board board,
			PrintWriter out, HttpServletResponse response) {
		
		// 비밀번호가 맞는지 체크
		boolean result = service.isPassCheck(board.getNo(), board.getPass());
		
		// 비밀번호가 맞지 않으면 - 사용자에게 알림을 응답하고 프로그램 종료
		if(!result) {
			// 응답을 직접 생성
			response.setContentType("text/html; charset=utf-8");
			out.println("<script>");
			out.println("	alert('비밀번호가 맞지 않음');");
			out.println("	history.back();");
			out.println("</script>");
			return null;
		}
		
		// 게시 글을 수정
		service.updateBoard(board);
		
		// 게시 글 수정이 완료되면 redirect
		return "redirect:boardList";
	}
	
	
	@PostMapping("/update")
	public String update(Model model, String pass, int no,
			PrintWriter out, HttpServletResponse response) {

		// 비밀번호가 맞는지 체크
		boolean result = service.isPassCheck(no, pass);
		
		// 비밀번호가 맞지 않으면 - 사용자에게 알림을 응답하고 프로그램 종료
		if(!result) {
			// 응답을 직접 생성
			response.setContentType("text/html; charset=utf-8");
			out.println("<script>");
			out.println("	alert('비밀번호가 맞지 않음');");
			out.println("	history.back();");
			out.println("</script>");
			return null;
		}
		
		// 비밀번호가 맞으면 - no에 해당하는 게시 글 정보를 읽어와 모델에 저장
		model.addAttribute("board", service.getBoard(no));
		return "/updateForm";
	}
	
	//@RequestMapping("/writeProcess")
	// 파라미터를 받아서 도메인 객체로 넘겨주는 커멘트 객체
	@PostMapping("/writeProcess")
	public String insertBoard(Board board) {
		System.out.println("before - no : " + board.getNo());
		// 입력 - Board 객체로 만들어서	
		// 게시 글 등록 => service
		service.insertBoard(board);
		
		System.out.println("after - no : " + board.getNo());
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
	public String boardList(Model model, @RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum) {
		// pageNum이 null이면 기본값을 1로 넘겨준다.
		
		// 1. 입력
		//String page = request.getParameter("page");
		
		// 2. 요청에 대한 처리를 하고 결과 데이터 - 게시 글 리스트 - 모델(model)
		Map<String, Object> modelMap = service.boardList(pageNum);
		model.addAllAttributes(modelMap);
		
		// 3. 뷰에 결과를 출력
		// 뷰의 이름으로 간주 - viewResolver 설정의 prefix, suffix를 조합해서 물리적인 뷰의 이름이 결정 
		// /WEB-INF/index.jsp?body=views/ + boardList + .jsp
		return "boardList";
	}

	
}
