<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form name="boardReplyForm" method="post" action="./boardReply.do">
	<table border="1" cellspacing="10" cellpadding="10">
		<tr>
			<th colspan="2">답글쓰기</th>
		</tr>
		<tr>
			<!-- 제목 -->
			<td width="70" align="Center">제목</td>
			<td><input type="text" name="subject" id="subject"
				placeholder="제목 입력" style="width: 500px;"></td>
		</tr>

		<tr>
			<!-- 내용 -->
			<td width="70" align="Center">내용</td>
			<td><textarea rows="30" cols="70" name="content"></textarea>
		</tr>


		<tr>
			<td colspan="2" align="Center"><input type="button" value="답글쓰기"
				onclick="javascript:checkBoardReplyWrite()"> <input type="reset"
				value="다시작성"></td>
		</tr>

	</table>
	
	<input type="hidden" name="pseq" value="${requestScope.pseq }">
	<input type="hidden" name="pg" value="${requestScope.pg }">
	
</form>

<script src="../js/board.js" type="text/javascript"></script>