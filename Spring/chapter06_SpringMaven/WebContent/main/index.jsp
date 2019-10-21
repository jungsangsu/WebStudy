<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        #mainA:link{
            color: black;text-decoration: none;
        }
        #mainA:visited{
            color: black;text-decoration: none;
        }
        #mainA:hover{
            color: chocolate;text-decoration: underline;font-weight: bold
        }
        #mainA:active{
            color: black;text-decoration: none;
        }
    </style>
    <title>index</title>
</head>
<body>
<p>***메인화면***</p>
<a id="mainA" href="/chapter06_SpringMaven/user/writeForm">입력</a><br>
<a id="mainA" href="/chapter06_SpringMaven/user/list">출력</a><br>
<a id="mainA" href="/chapter06_SpringMaven/user/modifyForm">수정</a><br>
<a id="mainA" href="/chapter06_SpringMaven/user/deleteForm">삭제</a><br>

</body>
</html>