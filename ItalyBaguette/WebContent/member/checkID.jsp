<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<script src="../js/member.js" type="text/javascript"></script>
<link rel="stylesheet" href="../css/bootstrap.css">

<style type="text/css">
    body{
        background-color: antiquewhite;
        text-align: center;
        
    }
</style>
<meta charset="UTF-8">
<title>ID 중복체크</title>
</head>
<body>

	<c:if test="${param.condition == 1 }">
		<form name="" method="get" action="checkID.do">
			<h5>${param.id } 사용 불가능 합니다 </h5><br> <br> 아이디&nbsp;&nbsp;<input type="text"
				name="id" class="form-control" style="width: 200px; display: inline-block"> 
				<input type="submit" value="중복체크" class="form-control" style="width: 100px; display: inline-block">
				
		</form>
	</c:if>

	<c:if test="${param.condition== 2}">
		<br><br>
		<h5>${param.id } 사용가능</h5>
		<input type="button" value="사용하기" class="form-control" style="width: 100px; display: inline-block"
			onclick="checkIDClose('${param.id}')" />
	</c:if>
</body>

</html>