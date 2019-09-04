<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>

<HTML>
<head>
<meta charset="UTF-8">
<title>modify.jsp</title>
<body>

	<% 	

	String id = request.getParameter("id");
	MemberDAO memberDAO = MemberDAO.getInstance();
	MemberDTO memberDTO = memberDAO.isExistID2(id);
		
	%>
	

	
	<form name="modifyForm" method="post" action="http://localhost:8080/memberJSP/member/modify.jsp">
		<table border="1" cellspacing="10" cellpadding="10">

			<tr>
				<!-- 이름 -->
				<td width="70" align="Center">이름</td>
				<td><input type="text" name="name" id="name" value ="<%= memberDTO.getName() %>" 
					style="width: 500px;"></td>
			</tr>


			<tr>
				<!-- 아이디 -->
				<td width="70" align="Center">아이디</td>
				<td><input type="text" name="id" id="id" value="<%=id %>"
					style="width: 500px;">
					
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
				<td><input type="radio" name="gender" id="gender"  value="0"
					checked="checked">남 <input type="radio" name="gender"
					value="1">여</td>
			</tr>


			<tr>
				<!-- 이메일 -->
				<td width="70" align="Center">이메일</td>
				<td><input type="text" name="email1" id="email1" value="<%=memberDTO.getEmail1() %>" style="width: 225px;">
					@ <input type="text" name="email2" id="email22" placeholder="직접입력" list="list"
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
				</select> - <input type="text" name="tel2" id="tel2" value="<%=memberDTO.getTel2() %>" style="width: 200px;">
					- <input type="text" name="tel3" id="tel3" value="<%=memberDTO.getTel3() %>" style="width: 200px;"></td>
			</tr>

			<tr>
				<td rowspan="3" align="Center">주소</td>
				<td><input type="text" name="zipcode" id="daum_zipcode" value="<%=memberDTO.getZipcode() %>" readonly> <input
					type="button" name="zipbutton" value="우편번호검색" onclick ="checkPost()"></td>
			</tr>
			<tr>
				<td><input type="text" name="addr1" id="daum_addr1" value="<%=memberDTO.getAddr1() %>"
					style="width: 500px;" readonly></td>
			</tr>
			<tr>
				<td><input type="text" name="addr2" id="daum_addr2"
					value="<%=memberDTO.getAddr2() %>" style="width: 500px;"></td>
			</tr>

			<tr>
				<td colspan="2" align="Center"><input type="button"
					value="회원수정" onclick ="checkupdate()"> <input
					type="reset" value="다시작성"></td>
			</tr>

		</table>
	</form>
</body>

<script type="text/javascript" src="http://localhost:8080/memberJSP//js/member.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script type="text/javascript">
window.onload=function()
{
	document.modifyForm.gender['<%=memberDTO.getGender()%>'].checked = true;
	<%--document.modifyForm.email2.value = '<%=memberDTO.getEmail2()%>' --%>
	document.modifyForm.tel1.value = '<%=memberDTO.getTel1()%>'
	document.getElementById("email22").value = '<%=memberDTO.getEmail2()%>'
}
</script>



</HTML>