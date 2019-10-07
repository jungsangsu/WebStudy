<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<c:if test="${boardDTO!=null }">

<table class="table table-bordered"
		style="margin-top: 300px; width: 1000px; margin-left: auto; margin-right: auto; background-color: aliceblue">
		<tr>
			<th colspan="3" id="subjectA">${boardDTO.subject }</th>
		</tr>
		<tr>
			<th width="150">글번호 : ${boardDTO.seq }</th>
			<th width="150">작성자 : ${boardDTO.id }</th>
			<th width="150">조회수 : ${boardDTO.hit }</th>
		</tr>
		<tr>
			<td colspan="3" height="200" valign="top"><pre
					style="white-space: pre-line; word-break: break-all;">${boardDTO.content }</pre>
			</td>
		</tr>

	</table>

    
    <div style="text-align: center">
	<input type="button" value="목록"
		onclick="location.href='QNAList.do?pg=${pg}'">


	<c:if test="${ sessionScope.memId == boardDTO.id}">
		<input type="button" value="글수정"
			onclick="location.href='QNAModifyForm.do?seq=${boardDTO.seq }&pg=${pg }'">
		<input type="button" value="글삭제" onclick="location.href='QNADelete.do?seq=${boardDTO.seq }&pg=${pg }'">
	</c:if>
	<input type="button" value="답글"
		onclick="location.href='QNAReplyForm.do?pseq=${boardDTO.seq }&pg=${pg }'">
    </div>
</c:if>

