<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="../css/board.css">
<form name="imageboardListForm" method="post" action="">
	<c:if test="${list!=null }">
		<table border="1" frame="hsides" rules="rows" cellspacing="0"
			cellpadding="5">
			<tr>

				<th><input type="checkbox" name="checkAll" id="checkAll"
					onclick="javascript:checkALL()">번호</th>
				<th>이미지</th>
				<th>상품명</th>
				<th>단가</th>
				<th>개수</th>
				<th>합계</th>
			</tr>

			<c:forEach var="imageboardDTO" items="${list }">

				<tr>
					<td align="center" width="100"><input type="checkbox"
						name="checkRow" value="${imageboardDTO.seq }">${imageboardDTO.seq }</td>
					<td><a href="javascript:void(0)"
						onclick="isLogin(${imageboardDTO.seq },${pg })"><img
							alt="${imageboardDTO.image1 }"
							src="../storage/${imageboardDTO.image1 }" height="100"></a></td>
					<td align="center" width="100">${imageboardDTO.imageName }</td>
					<td align="center" width="100">${imageboardDTO.imagePrice }</td>
					<td align="center" width="100">${imageboardDTO.imageQty }</td>
					<td align="center" width="100">${imageboardDTO.imageQty*imageboardDTO.imagePrice }원</td>
				</tr>
			</c:forEach>
		</table>

	</c:if>
	<div style="text-align: Left;">
		<input type="button" value="선택삭제" onclick="javascript:selectDelete()">
	</div>
</form>
<div style="float: left; width: 700px; text-align: center;">
	${boardPaging.pagingHTML }</div>

<script type="text/javascript">

	function isLogin(seq, pg) {
		if ("${memId}" == "")
			alert("먼저 로그인하세요");
		else
			location.href = "/miniproject/imageboard/imageboardView.do?seq=" + seq
					+ "&pg=" + pg;
	}
	
	function checkALL()
	{
		if(document.imageboardListForm.checkAll.checked==true)
			{
			for(i=0; i < imageboardListForm.checkRow.length; i++) {
				imageboardListForm.checkRow[i].checked=true;
			}
			}else{
				for(i=0; i < imageboardListForm.checkRow.length; i++) {
					imageboardListForm.checkRow[i].checked=false;
				}	
			}
	}
	
	function selectDelete()
	{
		var con = false;
		for(i=0; i < imageboardListForm.checkRow.length; i++) {
			if(imageboardListForm.checkRow[i].checked)
				{
					con = true
				}
		}
		if(con) /* 체크되어있음 */
			{
			var confirmflag = confirm("정말로 삭제하시겠습니까?");
				if(confirmflag){
					var jbAry = new Array();
					for(i=0; i < imageboardListForm.checkRow.length; i++) {
						if(imageboardListForm.checkRow[i].checked)
							{
								jbAry[i] = imageboardListForm.checkRow[i].value;
							}
					}
					
					location.href = "/miniproject/imageboard/imageboardDelete.do?list=" + jbAry;

				}
			}
		else{ /* 체크안됨 */
			alert("항목을 선택하세요");
		}
	}
</script>