<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>** include JSP directive **</h3>
<%@ include file="today.jsp" %>

<h3>** include JSP tag **</h3>
<jsp:include page="image.jsp"/>

<h3>** 3초뒤에 페이지 이동 **</h3>
<% response.setHeader("Refresh","3;url=input.jsp"); %>

</body>
</html>