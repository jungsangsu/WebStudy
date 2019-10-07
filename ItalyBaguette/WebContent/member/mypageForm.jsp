<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form name="mypageForm" method="post"
	action="/ItalyBaguette/member/modify.do">
	<input type="hidden" name="oldpwd" id="oldpwd" value="${requestScope.memberDTO.pwd }">
	<table class="table table-bordered"
		style="margin-top: 300px; width: 1000px; margin-left: auto; margin-right: auto; background-color: aliceblue">
		<tr>
			<!-- 이름 -->
			<td width="100" align="Center">이름</td>
			<td><input type="text" class="form-control" name="name"
				id="name" value="${requestScope.memberDTO.name }"
				style="width: 200px;" readonly placeholder="이름을 입력하세요"></td>
		</tr>

		<tr>
			<!-- 아이디 -->
			<td width="100" align="Center">아이디</td>
			<td><input type="text" name="id" class="form-control" id="id"
				placeholder="아이디 입력" value="${requestScope.memberDTO.id }" readonly
				style="width: 200px; display: inline-block">
		</tr>

		<tr>
			<!-- 비밀번호 -->
			<td width="100" align="Center">이전 비밀번호</td>
			<td><input type="password" name="beforepwd" id="beforepwd"
				class="form-control" style="width: 200px; display: inline-block"
				placeholder="6~10자리">&nbsp;&nbsp;&nbsp;&nbsp;<span
				id="beforePWD"></span></td>
		</tr>

		<tr>
			<!-- 비밀번호 -->
			<td width="100" align="Center">새비밀번호</td>
			<td><input type="password" name="pwd" id="pwd"
				class="form-control" style="width: 200px; display: inline-block"
				placeholder="6~10자리">&nbsp;&nbsp;&nbsp;&nbsp;<span
				id="checkPWD"></span></td>
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
				value="${requestScope.memberDTO.email1 }" class="form-control"
				style="width: 250px; display: inline-block"> @ <input
				type="text" name="email2" id="email2" class="form-control"
				value="${requestScope.memberDTO.email2 }" placeholder="직접입력"
				list="list" style="width: 250px; display: inline-block"> <datalist
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
				value="${requestScope.memberDTO.tel2 }"
				style="width: 76px; display: inline-block" class="form-control">
				- <input type="text" name="tel3" id="tel3"
				value="${requestScope.memberDTO.tel3 }"
				style="width: 76px; display: inline-block" class="form-control"></td>
		</tr>

		<tr>
			<td rowspan="3" align="Center">주소</td>
			<td><input type="text" name="zipcode" id="daum_zipcode" readonly
				class="form-control" value="${requestScope.memberDTO.zipcode }"
				style="width: 100px; display: inline-block"> <input
				type="button" name="zipbutton" value="우편번호검색" class="form-control"
				onclick="checkFirst()" style="width: 150px; display: inline-block"></td>
		</tr>

		<tr>
			<td><input type="text" name="addr1" id="daum_addr1"
				class="form-control" value="${requestScope.memberDTO.addr1 }"
				placeholder="주소" style="width: 500px;" readonly></td>
		</tr>

		<tr>
			<td><input type="text" name="addr2" id="daum_addr2"
				value="${requestScope.memberDTO.addr2 }" class="form-control"
				placeholder="상세 주소" style="width: 500px;"></td>
		</tr>

		<tr>
			<td colspan="2" align="Center"><input type="submit" value="회원수정"
				class="btn btn-outline-secondary"> <input type="reset"
				value="다시작성" class="btn btn-outline-secondary"></td>
		</tr>

	</table>
</form>

<script type="text/javascript" src="../js/member.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script type="text/javascript">
window.onload=function()
{
	document.modifyForm.gender['${requestScope.memberDTO.getGender() }'].checked = true;
	<%--document.modifyForm.email2.value = '<%=memberDTO.getEmail2()%>' --%>
	document.modifyForm.tel1.value = '${requestScope.memberDTO.tel1 }'
	document.getElementById("email22").value = '${requestScope.memberDTO.email2 }'
}
</script>

<script src="../js/member.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#pwd').on('input',function() {
			var len = $('#pwd').val().length;
			if (len < 6 || len > 10) {
				$('#checkPWD')
				.html(
						'<strong>비밀번호는 6자리이상 10자 이하로 해주세요.</strong>')
				.css('color', 'red');
			}		
			else {
				$('#checkPWD')
				.html('<strong>Clear</strong>')
				.css('color', 'blue');
			}
		});

   		$('#beforepwd').on('input',function(){
			if($('#oldpwd').val()!=$('#beforepwd').val()){
				$('#beforePWD')
				.html(
						'<strong>이전 비밀번호랑 다릅니다.</strong>')
				.css('color', 'red');	
			}
			else {
				$('#beforePWD')
				.html('<strong>Clear</strong>')
				.css('color', 'blue');
			}
		});

	});
</script>


