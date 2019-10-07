<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<title>이태리바게트</title>


<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/index.css">
<link rel="shortcut icon" type="image⁄x-icon"
	href="../img/titlelogo.png">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body style="background-color: antiquewhite">

	<jsp:include page="../template/top.jsp" />
	<!-- Button to Open the Modal -->

	<c:if test="${display=='../template/body.jsp' }">
		<form name="loginForm" method="post" action="../member/loginAction.do">
			<div class="container">
				<!-- 로그인관련 -->
				<!-- The Modal -->
				<div class="modal" id="myModal">
					<div class="modal-dialog">
						<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">로그인</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>

							<!-- Modal body -->
							<div class="modal-body" style="text-align: center">
								&nbsp;&nbsp;아이디 :&nbsp;&nbsp;<input type="text" name="id"
									class="form-control" id="id" placeholder="ID"
									style="width: 200px; display: inline-block"><br>
								비밀번호 : <input type="password" name="pwd" id="pwd"
									class="form-control"
									style="width: 200px; display: inline-block" placeholder="PW">
								<div class="checkbox">
									<label for="cb1"> <input type="checkbox" id="cb1"
										name="autoLogin"> 자동로그인
									</label>
								</div>

							</div>
							<!-- Modal footer -->
							<div class="modal-footer">
								<div id="idpw_ment">
									<p></p>
								</div>
								<a id="kakao-login-btn"></a> <a
									href="http://developers.kakao.com/logout"></a>
								<button type="button" class="btn btn-primary"
									onclick="checklogin()">로그인</button>
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">취소</button>
							</div>
						</div>
					</div>
				</div>

			</div>
		</form>
	</c:if>


	<div class="bodyCenter"
		style="margin: auto; width: 80%; display: block;">
		<jsp:include page="${display }" />
	</div>

	<script type='text/javascript'>
		//<![CDATA[
		// 사용할 앱의 JavaScript 키를 설정해 주세요.
		Kakao.init('5cb26e6ff69edbfee1c2013c8ee80461');
		// 카카오 로그인 버튼을 생성합니다.
		Kakao.Auth.createLoginButton({
			container : '#kakao-login-btn',
			success : function(authObj) {
				alert(JSON.stringify(authObj));
			},
			fail : function(err) {
				alert(JSON.stringify(err));
			}
		});
		//]]>
	</script>
</body>
</html>