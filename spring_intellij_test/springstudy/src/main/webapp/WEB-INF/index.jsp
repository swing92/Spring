<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../resources/css/index.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%@ include file="template/header.jsp" %>

<%--	WEB-INF/views + main + .jsp--%>
<%--    WEB-INF/index.jsp?body = views/ + main + .jsp--%>
<%--    ?body = detail.jsp--%>

	<jsp:include page="${ param.body }"/>
	<%@ include file="template/footer.jsp" %>
</body>
</html>