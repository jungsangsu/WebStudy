<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <div id="QNAimg" style="text-align: center"><img src="../img/QANtitle.JPG" width="100%" style="margin-top: 100px;">
        <br><br>
        
        <c:if test="${sessionScope.memId!=null }">
        <button type="button" class="btn btn-warning" data-toggle="modal"
					data-target="#myModal" onclick="location.href='../board/QNAwriteForm.do'">1:1 문의하기</button>
        </c:if>
        <c:if test="${sessionScope.memId==null }">
            <button type="button" class="btn btn-warning" data-toggle="modal"
					data-target="#myModal">로그인</button>
            
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
    </div>
