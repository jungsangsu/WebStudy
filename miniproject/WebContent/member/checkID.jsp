<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.bean.MemberDTO"
	import="member.dao.MemberDAO"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script src="../js/member.js" type="text/javascript"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${param.condition == 1 }">
		<form name="" method="get" action="checkID.do">
			${param.id } 사용 불가능 합니다 <br>
			<br> 아이디<input type="text" name="id"> <input
				type="submit" value="중복체크">
		</form>
	</c:if>

	<c:if test="${param.condition== 2}">
		사용가능
		<input type="button" value="사용하기"
			onclick="checkIDClose('${param.id}')" />
	</c:if>
</body>


</html>