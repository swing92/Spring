<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
        
	<div class="row my-5" id="global-content">
		<div class="col-10 offset-1">
		
			<div class="row">
				<div class="col">
					<h2 class="fs-3 fw-bold text-center">게시 글 상세보기</h2>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th>제 목</th>
								<td colspan="3">${board.title}</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>${board.writer}</td>
								<th>작성일</th>
								<td><fmt:formatDate value="${board.regDate}"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td>
									<div class="col-sm-8">
										<input type="password" name="pass" id="pass" class="form-control">
									</div>
								</td>
								<th>조회수</th>
								<td>${board.readCount}</td>
							</tr>
							<tr>
								<th>파 일</th>
								<td colspan="3">
									${board.file1}
								</td>
							</tr>
							<tr>							
								<td colspan="4" class="p-3" style="white-space: pre">${board.content}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row my-3">
				<div class="col text-center">
					<input type="button" class="btn btn-warning" id="detailUpdate" value="수정하기" >
					&nbsp;&nbsp;
					<input type="button" class="btn btn-danger" id="detailDelete" value="삭제하기" >
					&nbsp;&nbsp;
					<input type="button" class="btn btn-primary" value="목록보기" 
							onclick="location.href='boardList'">
				</div>				
			</div>
		
		</div>
	</div>	