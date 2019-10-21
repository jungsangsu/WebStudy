<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:if test="${sessionScope.memId==null }">
	 <jsp:include page="/member/loginForm.jsp" />
</c:if>
<c:if test="${sessionScope.memId!=null }">
	${sessionScope.memId }님 환영합니다.<br>
	<br>
	<input type="submit" value='회원정보수정'
		onclick="location.href='/miniproject/member/modifyForm.do?id=${sessionScope.memId}'">
	<input type="button" value='로그아웃'
		onclick="location.href='../member/logoutAction'">
	<input type="button" value='Main'
		onclick="location.href='../main/index'">

</c:if>

