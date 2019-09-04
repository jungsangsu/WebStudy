<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="member.bean.MemberDTO"
    import="member.dao.MemberDAO" %>

<%
	String id = request.getParameter("id");
	MemberDAO memberDAO = MemberDAO.getInstance();
	boolean exist = memberDAO.isExistID(id);
%>

<!DOCTYPE html>
<html>
<head>
<script src="../js/member.js" type="text/javascript"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(exist){ %>
	<form name ="" method ="get" action ="checkID.jsp">
		<%= id %> 사용 불가능 합니다
		<br><br>
		아이디<input type="text" name ="id" >
		<input type ="submit" value="중복체크">
	</form>		
	<%}else{ %>
	사용가능
	<input type="button" value ="사용하기" onclick ="checkIDClose('<%=id%>')"/>
	<%} %>
</body>



</html>