<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<c:if test="${su>0 }">
	<h3>수정완료</h3>
</c:if>


<c:if test="${su<=0 }">
	<h3>글쓰기 실패 3초뒤에 다시 시도.</h3>
</c:if>

