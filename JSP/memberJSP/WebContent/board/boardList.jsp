<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO" />
<jsp:useBean id="boardPaging" class="board.bean.BoardPaging"/>
<%
	session.setAttribute("beforeSeq", "-1");

	String memId = "";
	
	if(session.getAttribute("memId")!=null)
		memId = (String)session.getAttribute("memId");
	

	int pg = Integer.parseInt(request.getParameter("pg"));

	int endNum = pg * 5;
	int startNum = endNum - 4;

	int totalA = boardDAO.getTotalA();
	int totalP = ((totalA + 1) / 5);

	ArrayList<BoardDTO> list = boardDAO.select(startNum, endNum);
	
	
	//페이징 처리
	int total = boardDAO.getTotalA();
	boardPaging.setCurrentPage(pg);
	boardPaging.setPageSize(5);
	boardPaging.setTotalA(total);
	boardPaging.setPageBlock(3);
	boardPaging.makePagingHTML();
%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/board.css">

</head>
<body>

	<table border="1" frame="hsides" rules="rows" cellspacing="3"
		cellpadding="3">


		<tr>
			<td width="70" align="Center">글번호</td>
			<td width="300" align="Center">제목</td>
			<td width="70" align="Center">작성자</td>
			<td width="100" align="Center">작성일</td>
			<td width="70" align="Center">조회수</td>
		</tr>

		<%
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<td width="70" align="Center"><%=list.get(i).getSeq()%></td>
			<td width="300" align="Center">
			<a href="javascript:void(0)" id="subjectA" onclick="isLogin(<%=list.get(i).getSeq()%>,<%=pg%>)">
			<%=list.get(i).getSubject()%></a>
			</td>
			<td width="70" align="Center"><%=list.get(i).getName()%></td>
			<td width="100" align="Center"><%=list.get(i).getLogtime()%></td>
			<td width="70" align="Center"><%=list.get(i).getHit()%></td>
		</tr>
		<%
			}
			}
		%>


	</table>
	
	<div style="float: left; width: 50px;">
		<img src="../image/lb.jpg" width="50" height="100" onclick="location.href ='../main/index.jsp'" style="cursor: pointer" />
	</div>
	<div style="float: left; width:600px; text-align: center;">
		<%=boardPaging.getPagingHTML() %>
	</div>

</body>
<script type="text/javascript">
function isLogin(seq,pg)
{
	var memId = "<%=session.getAttribute("memId")%>"; /*자바스크립트에서는 null도 문자열로 인식 왜? ""로 해줘서  */
	if(memId=="null")
	{
		alert("먼저 로그인해주세요");
	}else{
		location.href="boardView.jsp?seq="+seq+"&pg="+pg;
	}
	
}
</script>


</html>