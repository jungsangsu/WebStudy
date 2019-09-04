<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam</title>

</head>
<body>
	<form name="inputForm" method="get" action="./sum.jsp">
		<table border="1" cellspacing="10" cellpadding="10">


			<!-- X -->
			<tr>
				<td width="70" align="Center">X</td>
				<td><input type="text" name="x" id="x" placeholder="X입력"
					style="width: 500px;"></td>
			</tr>


			<!-- Y -->
			<tr>
				<td width="70" align="Center">Y</td>
				<td><input type="text" name="y" id="y" placeholder="Y입력"
					style="width: 500px;"></td>
			</tr>

			
			<tr>
				<td colspan="2" align="Center"><input type="button"
					value="합구하기" onclick="javascript:checkWrite()"> <input
					type="reset" value="다시작성"></td>
			</tr>

		</table>
	</form>
</body>


</html>

<script>
	function checkWrite() {
	// if(document.paramForm.name.value==""){
	if (document.inputForm.x.value == "") {
		alert("X을 입력하세요");
	} else if (document.inputForm.y.value == "") {
		alert("Y를 입력하세요");
	}  else {
		document.inputForm.submit();
	}
}

</script>
