<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/bootstrap/bootstrap.min.css" rel="stylesheet" >
<script src="resources/js/jquery-3.2.1.min.js"></script>
<script src="resources/js/formcheck.js"></script>
</head>
<body>
	<div class="container">
		<!-- header -->
		<%@ include file="template/header.jsp" %>	
		<%-- content
			/WEB-INF/index.jsp?body=views/ + boardList + .jsp 
			/WEB-INF/index.jsp?body=views/ + boardDetail + .jsp 
			/WEB-INF/index.jsp?body=views/ + writeForm + .jsp
		<%= request.getParameter("body") %>
		--%>
		<jsp:include page="${param.body}" />
		<!-- footer -->
		<%@ include file="template/footer.jsp" %>
	</div>
	<script src="resources/bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>