<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="../css/board.css">
<form name="boardListForm" method="post" action="./boardSearch.do">
	<c:if test="${list!=null }">
		<table border="1" frame="hsides" rules="rows" cellspacing="0"
			cellpadding="5">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>

			<c:forEach var="boardDTO" items="${list }">
				<tr>
					<c:if test="${boardDTO.lev>0 }">
						<td align="center" width="100"> </td>
					</c:if>
					<c:if test="${boardDTO.lev==0 }">
						<td align="center">${boardDTO.seq }</td>
					</c:if>
					
					
					<td width="200"><c:if test="${boardDTO.lev!=0 }">
							<c:forEach var="i" begin="0" end="${boardDTO.lev }" step="1">
								&emsp;
							</c:forEach>

							<img alt="댓글아이콘" src="../img/reply.gif">
						</c:if> <a href="javascript:void(0)" id="subjectA"
						onclick="isLogin(${boardDTO.seq },${pg })"> ${boardDTO.subject }
					</a></td>
					<td align="center" width="100">${boardDTO.id }</td>
					<td align="center" width="100">${boardDTO.logtime }</td>
					<td align="center" width="100">${boardDTO.hit }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<div style="float: left; width: 700px; text-align: center;">
		${boardPaging.pagingHTML }</div><br>
	<select name="searchOption">
		<option value="subject">제목</option>
		<option value="id">id</option>
	</select> <input type="hidden" name="pg" value="1"> <input type="text"
		name="search" id="search" placeholder="검색어 입력"
		value="${requestScope.keyword }" style="width: 500px;"> <input
		type="submit" value="검색">
</form>

<script type="text/javascript">
function isLogin(seq,pg){
	if("${memId}"=="")
		alert("먼저 로그인하세요");
	else
		location.href="/miniproject/board/boardView.do?seq="+seq+"&pg="+pg;		
}
</script>



















