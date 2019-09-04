<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setCharacterEncoding("UTF-8");
%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>
<jsp:useBean id="memberDTO" class="member.bean.MemberDTO"
	scope="session"></jsp:useBean>


<HTML>
<head>
<meta charset="UTF-8">
<title>write.jsp</title>
<body>

	<jsp:setProperty property="name" name="memberDTO" />
	<jsp:setProperty property="id" name="memberDTO" />
	<jsp:setProperty property="pwd" name="memberDTO" />
	<jsp:setProperty property="gender" name="memberDTO" />
	<jsp:setProperty property="email1" name="memberDTO" />
	<jsp:setProperty property="email2" name="memberDTO" />
	<jsp:setProperty property="tel1" name="memberDTO" />
	<jsp:setProperty property="tel2" name="memberDTO" />
	<jsp:setProperty property="tel3" name="memberDTO" />
	<jsp:setProperty property="zipcode" name="memberDTO" />
	<jsp:setProperty property="addr1" name="memberDTO" />
	<jsp:setProperty property="addr2" name="memberDTO" />

	<%
		MemberDAO memberDAO = MemberDAO.getInstance();
		int su = memberDAO.write(memberDTO);
	%>
	<%
		if (su == 1) {
	%>
	회원가입을 축하합니다.
	<input type='button' value='로그인'
		onclick="location.href='loginForm.jsp'">
	<%
		} else {
	%>
	다시입력하세요.
	<%
		}
	%>


</body>
</HTML>