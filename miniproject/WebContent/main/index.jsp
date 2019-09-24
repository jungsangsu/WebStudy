<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/main.css">
<title>Insert title here</title>
</head>
<body>
	<div id="mainbodytable">
	<table border="1" id="bodyTable">
		<thead>
			<tr>
				<td colspan="2" align="Center"><jsp:include
						page="../template/top.jsp" /></td>
			</tr>
			<tr>
				<td colspan="2" align="Right"><jsp:include
						page="../template/nav.jsp" /></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td width="30%" height="300" align="Center"><jsp:include
						page="../template/left.jsp" /></td>
				<td align="Center"><jsp:include page="${display }" /></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td align="Right" colspan="2"><jsp:include
						page="../template/bottom.jsp"></jsp:include></td>
			</tr>
		</tfoot>
	</table>
	</div>
</body>
</html>