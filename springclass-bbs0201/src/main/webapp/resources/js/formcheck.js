$(function() {

	$("#updateForm").on("submit", function() {
		if($("#writer").val().length <= 0) {
			alert("작성자가 입력되지 않음");
			$("#writer").focus();
			return false;
		}
		if($("#title").val().length <= 0) {
			alert("제목이 입력되지 않음");
			$("#title").focus();
			return false;
		}
		if($("#pass").val().length <= 0) {
			alert("비밀번호가 입력되지 않음");
			$("#pass").focus();
			return false;
		}
		if($("#content").val().length <= 0) {
			alert("내용이 입력되지 않음");
			$("#content").focus();
			return false;
		}		
	
	});	
	
	$("#detailDelete").on("click", function() {
		let pass = $("#pass").val();
		if(pass.length <= 0) {
			alert("게시 글을 삭제하려면 비밀번호를 입력해 주세요");
			return false; // 기본 이벤트와 이벤트 전파를 취소
		}	
		
		$("#rPass").val(pass);
		$("#checkForm").attr("action", "delete");
		$("#checkForm").attr("method", "post");
		$("#checkForm").submit();
		
	});	
	
	
	$("#detailUpdate").on("click", function() {
		let pass = $("#pass").val();
		if(pass.length <= 0) {
			alert("비밀번호를 입력해 주세요");
			return false; // 기본 이벤트와 이벤트 전파를 취소
		}	
		
		$("#rPass").val(pass);
		$("#checkForm").attr("action", "update");
		$("#checkForm").attr("method", "post");
		$("#checkForm").submit();
		
	});
		
	$("#writeForm").on("submit", function() {
		if($("#writer").val().length <= 0) {
			alert("작성자가 입력되지 않음");
			$("#writer").focus();
			return false;
		}
		if($("#title").val().length <= 0) {
			alert("제목이 입력되지 않음");
			$("#title").focus();
			return false;
		}
		if($("#pass").val().length <= 0) {
			alert("비밀번호가 입력되지 않음");
			$("#pass").focus();
			return false;
		}
		if($("#content").val().length <= 0) {
			alert("내용이 입력되지 않음");
			$("#content").focus();
			return false;
		}		
	
	});
	

});