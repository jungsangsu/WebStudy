<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="imageboardWriteForm" method="post" action="./imageboardWrite.do" enctype="multipart/form-data">
		<table border="1" cellspacing="10" cellpadding="10">

			<tr>
				<!-- 상품코드 -->
				<td width="70" align="Center">상품코드</td>
				<td><input type="text" name="imageId" id="imageId"
					placeholder="상품코드 입력" style="width: 500px;"></td>
			</tr>

			<tr>
				<!-- 상품명 -->
				<td width="70" align="Center">상품명</td>
				<td><input type="text" name="imageName" id="imageName"
					placeholder="상품명 입력" style="width: 500px;"></td>
			</tr>

			<tr>
				<!-- 단가 -->
				<td width="70" align="Center">단가</td>
				<td><input type="text" name="imagePrice" id="imagePrice"
					placeholder="단가 입력" style="width: 500px;"></td>
			</tr>

			<tr>
				<!-- 단가 -->
				<td width="70" align="Center">갯수</td>
				<td><input type="text" name="imageQty" id="imageQty"
					placeholder="갯수 입력" style="width: 500px;"></td>
			</tr>

			<tr>
				<!-- 내용 -->
				<td width="70" align="Center">내용</td>
				<td><textarea rows="30" cols="70" name="imageContent"></textarea>
			</tr>

			<tr>
				<!-- 파일 -->
				<td colspan="2"><input type="file" name="image1" id="image1" style="width: 500px;"></td>
			</tr>


			<tr>
				<td colspan="2" align="Center"><input type="button" value="이미지 등록"
					onclick="javascript:checkimageBoardWrite()"> <input type="reset"
					value="다시작성"></td>
			</tr>

		</table>
	</form>
</body>

<script src="../js/imageboard.js" type="text/javascript"></script>
</html>