<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="board.bean.BoardDTO"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
<%
	//데이터 

	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));

	if(!session.getAttribute("beforeSeq").equals(seq)){
		boardDAO.boardHit(seq);
		session.setAttribute("beforeSeq", seq);
	}
	BoardDTO boardDTO = boardDAO.getboard(seq);
	
	
%>


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(boardDTO!=null)
	{
%>		
	<table border ="1" cellspacing="0" cellpadding ="3" frame="hsides" rules="rows" width="500" >
	<tr>
		<th colspan="3" id="subjectA"><%=boardDTO.getSubject() %></th>
	</tr>
	<tr>
		<th width="150">글번호 : <%=boardDTO.getSeq() %></th>
		<th width="150">작성자 : <%=boardDTO.getId() %></th>
		<th width="150">조회수 : <%=boardDTO.getHit() %></th>
	</tr>	
	<tr>
		<td colspan="3" height="200" valign="top">
		<pre  style="white-space:pre-line; word-break:break-all;"><%=boardDTO.getContent()%></pre>
		</td>
	</tr>
	
	</table>
	
	<input type="button" value="목록" onclick="location.href='boardList.jsp?pg=<%=pg%>'">
	
<%if(session.getAttribute("memId").equals(boardDTO.getId())){ %>	
	<input type="button" value="글수정" onclick="location.href='boardModifyForm.jsp?seq=<%=boardDTO.getSeq()%>&pg=<%=pg%>'">
	<input type="button" value="글삭제" onclick="">
<%} %>
	
<%
	}

%>
</body>
</html>