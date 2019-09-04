<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	//String name =  request.getParameter("name");

	String name = null;
	String id = null;
	/*
		//쿠키
		Cookie[] ar = request.getCookies(); //특정쿠키를 얻지못하고 모든 쿠키를 가지고온다.
		
		if(ar!=null)
		{
			for(int i=0; i<ar.length ;i++)
			{
	
				if(ar[i].getName().equals("memName")) name = ar[i].getValue();
				if(ar[i].getName().equals("memId")) id = ar[i].getValue();
			}
		}
	*/

	name = (String) session.getAttribute("memName");
	id = (String) session.getAttribute("memId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인OK</title>
</head>
<body>
	<img src="../image/lb.jpg" width="100" height="100"
		onclick="location.href ='../main/index.jsp'" style="cursor: pointer" />
	<h3><%=name%>님 로그인성공
	</h3>

	<br>
	<br>
	<input type="submit" value='회원정보수정'>
	<input type="button" value='로그아웃' onclick="location.href='logout.jsp'">
	<input type="button" value='Main' onclick="location.href='../main/index.jsp'">

</body>
</html>