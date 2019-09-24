<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form name="loginForm" method="post"
	action="../member/loginAction.do">
	<table border="1" cellspacing="10" cellpadding="1">

		<tr>
			<!-- 아이디 -->
			<td width=90" align="Center">ID</td>
			<td><input type="text" name="id" id="id" placeholder="아이디 입력"
				style="width: 100px;"></td>
		</tr>

		<tr>
			<!-- 비밀번호 -->
			<td width="90" align="Center">PW</td>
			<td><input type="password" name="pwd" id="pwd" style="width: 100px;"
				placeholder="비밀번호 입력"></td>
		</tr>


		<tr>
			<td colspan="2" align="Center"><input type="button" value="로그인"
				onclick="javascript:checklogin()">
				<button type="button" onclick="location.href='../member/writeForm.do' ">회원가입</button>
				<input type="reset" value="다시작성"></td>
		</tr>

	</table>
</form>
<script src="../js/login.js" type="text/javascript"></script>