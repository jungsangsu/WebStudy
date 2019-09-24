<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="../js/imageboard.js" type="text/javascript"></script>


<c:if test="${imageboardDTO!=null }">

	<table border="1" cellspacing="0" cellpadding="3" frame="hsides"
		rules="rows" width="500">

		<tr>
			<td rowspan="4"><img id="mainImg" alt="${imageboardDTO.image1 }" src="../storage/${imageboardDTO.image1 }" height="100"><img src="../img/zoom.png" onclick="detailView()"> </td>
			<th>상품명</th>
			<td>${imageboardDTO.imageName }</td>
		</tr>
		<tr>
			<th>단가</th>
			<td>${imageboardDTO.imagePrice }</td>
		</tr>
		<tr>
			<th>개수</th>
			<td>${imageboardDTO.imageQty }</td>
		</tr>
		<tr>
			<th>합계</th>
			<td>${imageboardDTO.imageQty*imageboardDTO.imagePrice }원</td>
		</tr>
		<tr>
			<th colspan="3">내용</th>
		</tr>
		<tr>
			<td colspan="3" height="200" valign="top"><pre
					style="white-space: pre-line; word-break: break-all;">${imageboardDTO.imageContent }</pre>
			</td>
		</tr>

	</table>

	<input type="button" value="목록"
		onclick="location.href='imageboardList.do?pg=${pg}'">

</c:if>
