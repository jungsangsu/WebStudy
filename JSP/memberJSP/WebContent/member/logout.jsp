<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%
	/*
		Cookie[] ar = request.getCookies();
		if (ar != null) {
			for (int i = 0; i < ar.length; i++) {
				if (ar[i].getName().equals("memName")) {
					ar[i].setMaxAge(0);
					response.addCookie(ar[i]);
				}
				if (ar[i].getName().equals("memId")) {
					ar[i].setMaxAge(0);
					response.addCookie(ar[i]);
				}
			}
		}
	*/

	session.removeAttribute("memName");
	session.removeAttribute("memId");
	session.removeAttribute("memEmail");
	//session.invalidate(); //새션 모두 지움 무효화
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>

<script type="text/javascript">
	window.onload = function() {
		alert("로그아웃");
		location.href = "../main/index.jsp";
	}
</script>
</html>