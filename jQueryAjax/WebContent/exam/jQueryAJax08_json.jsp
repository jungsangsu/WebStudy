<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${param.id=='hong' && param.pwd=='111' }">
	{
		"result" : "ok"
	}
</c:if>

<c:if test="${param.id!='hong' || param.pwd!='111' }">
	{
		"result" : "fail"
	}
</c:if>