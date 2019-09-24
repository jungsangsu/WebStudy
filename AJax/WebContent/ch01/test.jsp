<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="birth" value="${fn:split(param.yymmdd,'/') }"/>
<c:set var="year" value="${birth[0] }"/>
<c:set var="month" value="${birth[1] }"/>
<c:set var="day" value="${birth[2] }"/>

<jsp:useBean id="now" class="java.util.Date"/>
<fmt:formatDate var="today" value="${now }" pattern="yyyy"/>

현재년도 ${today } 입니다.
${param.name}님의 생일은 ${year}년 ${month }월 ${day }일 입니다</br>
나이는 ${2019-year+1}살 입니다.