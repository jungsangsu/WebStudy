<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	window.onload = function() {
		alert("이미지 글쓰기 성공하였습니다");
		location.href = "/miniproject/imageboard/imageboardList.do?pg=1";
	}
</script>