<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script src="../js/board.js" type="text/javascript"></script>

<form name="boardWriteForm" method="post" action="./boardWrite.do">
	<table border="1" cellspacing="10" cellpadding="10">

		<tr>
			<!-- 제목 -->
			<th width="70" align="Center">제목</th>
			<td><input type="text" name="subject" id="subject"
				placeholder="제목 입력" style="width: 500px;"></td>
		</tr>

		<tr>
			<!-- 내용 -->
			<th width="70" align="Center">내용</th>
			<td><textarea rows="30" cols="70" name="content"></textarea>
		</tr>


		<tr>
			<td colspan="2" align="Center"><input type="button" value="글쓰기"
				onclick="javascript:checkBoardWrite()"> <input type="reset"
				value="다시작성"></td>
		</tr>

	</table>
</form>


