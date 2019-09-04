<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>    
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setCharacterEncoding("UTF-8");
%>   
<jsp:useBean id="boardDTO" class="board.bean.BoardDTO"/>   
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/> 
<%
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	
	
	Map<String,String> map = new HashMap<String,String>();
	map.put("subject", subject);
	map.put("content", content);
	map.put("seq", String.valueOf(seq));

%>
<%
	/* boardDTO.setSubject(subject);
	boardDTO.setContent(content);
	boardDTO.setSeq(seq);
	
	int su = boardDAO.update(boardDTO); */
	
	int su = boardDAO.updateMap(map);
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<%
		if (su > 0) {
	%>
	<h3>수정완료</h3>
	<% response.setHeader("Refresh", "1;url=./boardList.jsp?pg="+pg); %>
	<%
		} else {
	%>
	<h3>글쓰기 실패 3초뒤에 다시 시도.</h3>
	<%=su %>
	<% response.setHeader("Refresh", "1;url=../main/index.jsp"); %>
	<%
		}
	%>
</html>