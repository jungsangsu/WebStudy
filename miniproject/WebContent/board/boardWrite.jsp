<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<c:if test="${requestScope.su > 0}">
	<h3>글쓰기 성공.</h3>
	<input type="button" value="목록"
		onclick="location.href='/miniproject/board/boardList.do?pg=1'">
</c:if>
<c:if test="${requestScope.su <=0 } ">
	<h3>글쓰기 실패.</h3>
</c:if>
