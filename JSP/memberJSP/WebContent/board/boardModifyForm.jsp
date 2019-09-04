<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" %>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>

<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	BoardDTO boardDTO = boardDAO.getboard(seq);
%>
    
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<form name="boardModifyForm" method="post"
		action="./boardModify.jsp">
		<input type="hidden" name="seq" id="seq" value="<%=seq%>"/>		
		<input type="hidden" name="pg" id="pg" value="<%=pg%>"/>
		<table border="1" cellspacing="10" cellpadding="10">
		
			<tr>
				<!-- 제목 -->
				<td width="70" align="Center">제목</td>
				<td><input type="text" name="subject" id="subject" placeholder="제목 입력"
					style="width: 500px;"></td>
			</tr>

			<tr>
				<!-- 내용 -->
				<td width="70" align="Center">내용</td>
				<td><textarea rows="30" cols ="70" name = "content"></textarea>
			</tr>


			<tr>
				<td colspan="2" align="Center"><input type="button" value="글수정"
					onclick="javascript:checkBoardModify()">
					<input type="reset" value="다시작성"></td>
			</tr>

		</table>
	</form>
</body>
<script type="text/javascript">
window.onload=function()
{
	document.boardModifyForm.subject.value = '<%=boardDTO.getSubject()%>'
	document.boardModifyForm.content.value = '<%=boardDTO.getContent()%>'
}

function checkBoardModify()
{
	if(document.boardModifyForm.subject.value=="")
	{
		alert("제목을 입력하세요");
		document.getElementById("subject").focus();
	} else if(document.boardModifyForm.content.value=="")
	{
		alert("내용을 입력하세요");
		document.getElementById("content").focus();
	} else{
		document.boardModifyForm.submit();
	}
	
}

</script>
</html>