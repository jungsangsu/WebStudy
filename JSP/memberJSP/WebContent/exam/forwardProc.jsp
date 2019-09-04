<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setAttribute("apple","사과");
	

	//페이지 이동
	RequestDispatcher dispacher = request.getRequestDispatcher("forwardResult.jsp");
	dispacher.forward(request,response);
%>
<%-- <jsp:forward page="forwardResult.jsp"/> --%>