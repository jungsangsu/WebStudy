<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dataDTO" class="exam.bean.DataDTO" scope="session"/>



<h5><jsp:getProperty property="x" name="dataDTO"/>*<jsp:getProperty property="y" name="dataDTO"/> =
 <%=dataDTO.getX()*dataDTO.getY()%></h5>
</body>
</html>