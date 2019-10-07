<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
#navbarTogglerDemo02 li ul {
	display: none;
	list-style: none; /* 평상시에는 안보이게 */
	padding-left: 10px;
	text-align: left;
}

#navbarTogglerDemo02 li:hover ul { /* 올리면 보이게 */
	display: block;
}

#titleBanner {
	color: chocolate;
	border-left-color: antiquewhite;
	font-weight: bold;
}
</style>

<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light"
	style="width: 100%;" id="navbar">
	<!-- 베너 사진 : 누르면 홈화면 -->
	<a class="navbar-brand" href="../main/index.do"><img
		src="../img/bannerName.JPG"></a>
	<!-- 메뉴바 버튼 -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">

			<li class="nav-item active" id="titleBanner">제품소개&nbsp;&nbsp;&nbsp;
				<ul>
					<li><a class="nav-link" href="#">신제품</a></li>
					<li><a class="nav-link" href="#">빵</a></li>
					<li><a class="nav-link" href="#">케이크</a></li>
					<li><a class="nav-link" href="#">샌드위치</a></li>
					<li><a class="nav-link" href="#">음료</a></li>
				</ul>
			</li>
			<li class="nav-item active" id="titleBanner">구매하기&nbsp;&nbsp;&nbsp;
				<ul>
					<li><a class="nav-link" href="#">이태 딜리버리</a></li>
					<li><a class="nav-link" href="#">딜리버리 메뉴</a></li>
					<li><a class="nav-link" href="#">이테데이</a></li>
				</ul>
			</li>
			<li class="nav-item active" id="titleBanner">프로모션&nbsp;&nbsp;&nbsp;
				<ul>
					<li><a class="nav-link" href="#">이벤트</a></li>
					<li><a class="nav-link" href="#">제휴카드 안내</a></li>
					<li><a class="nav-link" href="#">PB 공지</a></li>
				</ul>
			</li>
			<li class="nav-item active" id="titleBanner">매장찾기&nbsp;&nbsp;&nbsp;
				<ul>
					<li><a class="nav-link" href="../store/mapList.do">매장찾기</a></li>
					<li><a class="nav-link" href="#">고객센터</a></li>
				</ul>
			</li>
			<li class="nav-item active" id="titleBanner">문의하기&nbsp;&nbsp;&nbsp;
				<ul>
					<li><a class="nav-link" href="../board/QNA.do">질문하기</a></li>
					<c:if test="${sessionScope.memId=='admin' }">
					<li><a class="nav-link" href="../board/QNAList.do?pg=1">질문목록</a></li>
					</c:if>
					<li><a class="nav-link" href="#">자주하는 질문</a></li>
				</ul>
			</li>

		</ul>
	</div>
	<c:if test="${display=='../template/body.jsp' }">
		<c:if test="${sessionScope.memId==null }">
			<div class="login">
				<button type="button" class="btn btn-warning" data-toggle="modal"
					data-target="#myModal">로그인</button>

				<button type="button" class="btn btn-warning"
					onclick="location.href='../member/registerForm.do?'">회원가입</button>
			</div>
		</c:if>

		<c:if test="${sessionScope.memId!=null }">
			<h5 style="color: burlywood">${sessionScope.memId }님</h5>&nbsp;&nbsp;&nbsp;
			
		<div class="btn-group">
				<button type="button" class="btn btn-warning" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">내정보</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<div class="dropdown-menu">
					<a class="dropdown-item" href="../member/mypageForm.do">마이페이지</a>
					<a class="dropdown-item" href="../member/logoutAction.do">로그아웃</a>
				</div>
			</div>
		</c:if>
	</c:if>

	<c:if test="${display=='/member/registerForm.jsp' }">
		<h5 style="color: burlywood">회원가입을 환영합니다</h5>&nbsp;&nbsp;&nbsp;
	</c:if>


</nav>
