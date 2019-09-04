<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setCharacterEncoding("UTF-8");
%>
<%@ page import="board.bean.BoardDTO"%>
<%@ page import="board.dao.BoardDAO"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>
<HTML>
<head>
<meta charset="UTF-8">
<title>글쓰기완료</title>
<body>

	<%
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		
	%>
	<%
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		boardDTO.setId(id);
		boardDTO.setName(name);
		boardDTO.setEmail(email);

		int su = boardDAO.write(boardDTO);
	%>
	<%
		if (su == 1) {
	%>
	<h3>글쓰기 등록완료</h3>
	<% response.setHeader("Refresh", "1;url=./boardList.jsp?pg=1"); %>
	<%
		} else {
	%>
	<h3>글쓰기 실패 3초뒤에 다시 시도.</h3>
	<% response.setHeader("Refresh", "3;url=#"); %>
	<%
		}
	%>
</body>

</HTML>