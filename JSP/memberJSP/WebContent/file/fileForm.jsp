<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="" method="post" enctype="multipart/form-data"
		action="./fileUpload.jsp">
		<table border="1" cellspacing="10" cellpadding="10">

			<tr>
				<!-- 제목 -->
				<td width="70" align="Center">제목</td>
				<td><input type="text" name="subject" id="subject"
					placeholder="제목 입력" style="width: 500px;"></td>
			</tr>

			<tr>
				<!-- 내용 -->
				<td width="70" align="Center">내용</td>
				<td><textarea rows="30" cols="70" name="content"></textarea>
			</tr>

			<tr>
				<td colspan="2"><input type="file"
					name="upload1" size="50"></td>

			</tr>

			<tr>
				<td colspan="2"><input type="file"
					name="upload2" size="50"></td>

			</tr>

			<tr>
				<td colspan="2" align="Center"><input type="submit"
					value="파일올리기"> <input type="reset" value="다시작성"></td>
			</tr>

		</table>
	</form>
</body>
</html>