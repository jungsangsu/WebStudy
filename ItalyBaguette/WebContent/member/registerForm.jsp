<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form name="registerForm" method="post"
	action="/ItalyBaguette/member/register.do">
	<table class="table table-bordered"
		style="margin-top: 300px; width: 1000px; margin-left: auto; margin-right: auto; background-color: aliceblue">
		<tr>
			<!-- 이름 -->
			<td width="100" align="Center">이름</td>
			<td><input type="text" class="form-control" name="name"
				id="name" style="width: 200px;" placeholder="이름을 입력하세요"></td>
		</tr>


		<tr>
			<!-- 아이디 -->
			<td width="100" align="Center">아이디</td>
			<td><input type="text" name="id" class="form-control" id="id"
				placeholder="아이디 입력" style="width: 200px; display: inline-block">
				<input type="button" value="중복체크" onclick="checkID()"
				class="form-control" style="width: 100px; display: inline-block">
				<input type="hidden" name="check" value=""></td>
		</tr>

		<tr>
			<!-- 비밀번호 -->
			<td width="100" align="Center">비밀번호</td>
			<td><input type="password" name="registerpwd" id="registerpwd"
				class="form-control" style="width: 200px; display: inline-block"
				placeholder="6~10자리">&nbsp;&nbsp;&nbsp;&nbsp;<span
				id="checkPWD"></span></td>
		</tr>

		<tr>
			<!-- 비밀번호 재확인 -->
			<td width="100" align="Center">재확인</td>
			<td><input type="password" name="repwd" id="repwd"
				class="form-control" style="width: 200px; display: inline-block">&nbsp;&nbsp;&nbsp;&nbsp;<span
				id="checkRPWD"></span></td>
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
			<td width="100" align="Center">이메일</td>
			<td><input type="text" name="email1" id="email1"
				class="form-control" style="width: 250px; display: inline-block">
				@ <input type="text" name="email2" id="email2" class="form-control"
				placeholder="직접입력" list="list"
				style="width: 250px; display: inline-block"> <datalist
					id=list>
					<option value="naver.com">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="google.com">google.com</option>
					<option value="nate.net">nate.net</option>
				</datalist>
		</tr>

		<tr>
			<!-- 핸드폰 -->
			<td width="70" align="Center">핸드폰</td>
			<td><select name="tel1" id="tel1" class="form-control"
				style="width: 76px; display: inline-block">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="019">019</option>
			</select> - <input type="text" name="tel2" id="tel2"
				style="width: 76px; display: inline-block" class="form-control">
				- <input type="text" name="tel3" id="tel3"
				style="width: 76px; display: inline-block" class="form-control"></td>
		</tr>

		<tr>
			<td rowspan="3" align="Center">주소</td>
			<td><input type="text" name="zipcode" id="daum_zipcode" readonly
				class="form-control" style="width: 100px; display: inline-block">
				<input type="button" name="zipbutton" value="우편번호검색"
				class="form-control" onclick="checkFirst()"
				style="width: 150px; display: inline-block"></td>
		</tr>
		<tr>
			<td><input type="text" name="addr1" id="daum_addr1"
				class="form-control" placeholder="주소" style="width: 500px;" readonly></td>
		</tr>
		<tr>
			<td><input type="text" name="addr2" id="daum_addr2"
				class="form-control" placeholder="상세 주소" style="width: 500px;"></td>
		</tr>

		<tr>
			<td colspan="2" align="Center"><input type="button" value="회원가입"
				class="btn btn-outline-secondary" onclick="checkRegister()"> <input
				type="reset" value="다시작성" class="btn btn-outline-secondary"></td>
		</tr>
	</table>
</form>

<script src="../js/member.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#registerpwd').on('input',function() {
			var len = $('#registerpwd').val().length;
			if (len >= 6 && len <= 10) {
				$('#checkPWD')
						.html('<strong>Clear</strong>')
						.css('color', 'blue');
			} else {
				$('#checkPWD')
						.html(
								'<strong>비밀번호는 6자리이상 10자 이하로 해주세요.</strong>')
						.css('color', 'red');
			}
		});

		$('#repwd').on('input',function() {
			var pwdlen = $('#registerpwd').val();
			var repwdlen = $('#repwd').val();

			if (pwdlen == repwdlen) {
				$('#checkRPWD')
						.html(
								'<strong>Clear</strong>')
						.css('color', 'blue');
			} else {
				$('#checkRPWD')
						.html(
								'<strong>비밀번호 불일치합니다.</strong>')
						.css('color', 'red');
			}
		});
	});
</script>