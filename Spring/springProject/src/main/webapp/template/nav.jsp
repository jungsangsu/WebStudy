<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/main.css">

<div id="nav">
<c:if test="${sessionScope.memId!=null }">
	<a href="../board/boardWriteForm.do">글쓰기</a>

	<c:if test="${sessionScope.memId == 'admin' }">
		<a href="../imageboard/imageboardWriteForm.do">이미지 등록</a>
	</c:if>
</c:if>
<a href="../board/boardList.do?pg=1">목록</a>
<a href="../imageboard/imageboardList.do?pg=1">이미지 목록</a>

</div>