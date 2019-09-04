<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../js/member.js" type="text/javascript"></script>

</head>
<body>
	<form name="writeForm" method="post" action="http://localhost:8080/memberJSP/member/write.jsp">
		<table border="1" cellspacing="10" cellpadding="10">

			<tr>
				<!-- 이름 -->
				<td width="70" align="Center">이름</td>
				<td><input type="text" name="name" id="name" placeholder="이름입력"
					style="width: 500px;"></td>
			</tr>


			<tr>
				<!-- 아이디 -->
				<td width="70" align="Center">아이디</td>
				<td><input type="text" name="id" id="id" placeholder="아이디 입력"
					style="width: 500px;">
					<input type="button"
					value="중복체크" onclick="checkID()">
					<input type="hidden" name="check" value="">
					</td>
			</tr>

			<tr>
				<!-- 비밀번호 -->
				<td width="70" align="Center">비밀번호</td>
				<td><input type="text" name="pwd" id="pwd"
					style="width: 500px;"></td>
			</tr>

			<tr>
				<!-- 비밀번호 재확인 -->
				<td width="70" align="Center">재확인</td>
				<td><input type="text" name="repwd" id="repwd"
					style="width: 500px;"></td>
			</tr>


			<tr>
				<!-- 성별 -->
				<td width="70" align="Center">성별</td>
				<td><input type="radio" name="gender" id="gender" value="0"
					checked="checked">남 <input type="radio" name="gender"
					value="1">여</td>
			</tr>


			<tr>
				<!-- 이메일 -->
				<td width="70" align="Center">이메일</td>
				<td><input type="text" name="email1" id="email1" style="width: 225px;">
					@ <input type="text" name="email2" id="email2" placeholder="직접입력" list="list"
					style="width: 225px;"> <datalist id=list>
						<option value="naver.com">naver.com</option>
						<option value="daum.net">daum.net</option>
						<option value="google.com">google.com</option>
						<option value="nate.net">nate.net</option>
					</datalist>
			</tr>

			<tr>
				<!-- 핸드폰 -->
				<td width="70" align="Center">핸드폰</td>
				<td><select name="tel1" id="tel1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="019">019</option>
				</select> - <input type="text" name="tel2" id="tel2" style="width: 200px;">
					- <input type="text" name="tel3" id="tel3" style="width: 200px;"></td>
			</tr>

			<tr>
				<td rowspan="3" align="Center">주소</td>
				<td><input type="text" name="zipcode" id="daum_zipcode" readonly> <input
					type="button" name="zipbutton" value="우편번호검색" onclick ="checkPost()"></td>
			</tr>
			<tr>
				<td><input type="text" name="addr1" id="daum_addr1" placeholder="주소"
					style="width: 500px;" readonly></td>
			</tr>
			<tr>
				<td><input type="text" name="addr2" id="daum_addr2"
					placeholder="상세 주소" style="width: 500px;"></td>
			</tr>

			<tr>
				<td colspan="2" align="Center"><input type="button"
					value="회원가입" onclick="checkWrite()"> <input
					type="reset" value="다시작성"></td>
			</tr>

		</table>
	</form>
</body>


</html>




