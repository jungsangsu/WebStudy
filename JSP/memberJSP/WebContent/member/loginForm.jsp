<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>


<script src="../js/login.js" type="text/javascript"></script>

</head>
<body>
	<form name="loginForm" method="post"
		action="http://localhost:8080/memberJSP/member/login.jsp">
		<table border="1" cellspacing="10" cellpadding="10">

			<tr>
				<!-- 아이디 -->
				<td width="70" align="Center">아이디</td>
				<td><input type="text" name="id" id="id" placeholder="아이디 입력"
					style="width: 500px;"></td>
			</tr>

			<tr>
				<!-- 비밀번호 -->
				<td width="70" align="Center">비밀번호</td>
				<td><input type="text" name="pwd" id="pwd"
					style="width: 500px;" placeholder="비밀번호 입력"></td>
			</tr>


			<tr>
				<td colspan="2" align="Center"><input type="button" value="로그인"
					onclick="javascript:checklogin()">
					<button type="button"
						onclick="location.href='http://localhost:8080/memberJSP/member/writeForm.jsp' ">회원가입</button>
					<input type="reset" value="다시작성"></td>
			</tr>

		</table>
	</form>
</body>


</html>