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
<%@ page import="java.net.URLEncoder"%>

<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setId(id);
	memberDTO.setPwd(pwd);

	MemberDAO memberDAO = MemberDAO.getInstance();
	String name = memberDAO.Select(memberDTO);
	String email = memberDTO.getEmail1()+"@"+memberDTO.getEmail2();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form name="" method="post" action="modifyForm.jsp">
		<input type="hidden" name="id" value="<%=id%>">

		<%
			if (name != null) {
				/* response.sendRedirect("loginOk.jsp?name=" + URLEncoder.encode(id, "UTF-8")); */
				//쿠키
				/* Cookie cookie = new Cookie("memName", name);
				cookie.setMaxAge(30 * 60);
				response.addCookie(cookie); //클라이언트에 저장

				Cookie cookie2 = new Cookie("memId", id);
				cookie2.setMaxAge(30 * 60);
				response.addCookie(cookie2); //클라이언트에 저장
				*/
				//세션

				//HttpSession session2 = request.getSession(); // 세션 생성
				
				session.setAttribute("memName", name);
				session.setAttribute("memId", id);
				session.setAttribute("memEmail", email);
				
				response.sendRedirect("loginOk.jsp");

			} else {
				response.sendRedirect("loginFail.jsp");
			}
		%>

	</form>

</body>

<script src="http://localhost:8080/memberJSP//js/login.js"
	type="text/javascript"></script>
</html>