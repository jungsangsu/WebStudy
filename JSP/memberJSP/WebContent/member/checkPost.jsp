<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.bean.ZipcodeDTO"%>
<%@ page import="member.dao.MemberDAO"%>
<%@ page import="java.util.ArrayList"%>


<%

	String sido = request.getParameter("sido");
	String sigungu = request.getParameter("sigungu");
	String roadname = request.getParameter("roadname");

	MemberDAO memberDAO = MemberDAO.getInstance();
	ArrayList<ZipcodeDTO> list = null;

	if (sido != null && roadname != null) {
		list = memberDAO.getZipcodeList(sido, sigungu, roadname);
	}
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>우편번호</title>
<style type="text/css">
td, option {
	font-size: 8pt;
}

#addressA:link {
	color: black;
	text-decoration: none;
}

#addressA:visited {
	color: black;
	text-decoration: none;
}

#addressA:hover {
	color: green;
	text-decoration: underline;
}

#addressA:active {
	color: black;
	text-decoration: none;
}
</style>
</style>
</style>
</head>
<body>
	<form name="checkPostForm" method="get" action="checkPost.jsp?">

		<table border="1" cellspacing="1" cellpadding="1" width="100%">
			<tr>
				<td width="70" align="Center">시도</td>
				<td><select name="sido">
						<option value="">시도검색</option>
						<option value="서울">서울</option>
						<option value="인천">인천</option>
						<option value="대전">대전</option>
						<option value="대구">대구</option>
						<option value="울산">울산</option>
						<option value="세종">세종</option>
						<option value="광주">광주</option>
						<option value="경기">경기</option>
						<option value="강원">강원</option>
						<option value="전남">전남</option>
						<option value="전북">전북</option>
						<option value="경남">경남</option>
						<option value="경북">경북</option>
						<option value="충남">충남</option>
						<option value="충북">충북</option>
						<option value="부산">부산</option>
						<option value="제주">제주</option>
				</select></td>
				<td width="70" align="Center">시,군,구</td>
				<td><input type="text" name="sigungu" id="sigungu"
					placeholder="시군구입력" style="width: 400px;"></td>

			</tr>

			<tr>
				<td width="70" align="Center">도로명</td>
				<td colspan="3"><input type="text" name="roadname" size="35">
					<input type="submit" value="검색"></td>
			</tr>

			<tr>
				<td align="Center">우편번호</td>
				<td colspan="3" align="Center">주소</td>
			</tr>



			<%
				if (list != null) {
			%>
			<%
				for (ZipcodeDTO zipcodeDTO : list) {
						String address = (zipcodeDTO.getSido() + " " + zipcodeDTO.getSigungu() + " "
								+ zipcodeDTO.getYubmyundong() + " " + zipcodeDTO.getRi() + " " + zipcodeDTO.getRoadname()
								+ " " + zipcodeDTO.getBuildingname());
			%>
			<tr>
				<td align="Center"><%=zipcodeDTO.getZipcode()%></td>
				<td colspan="3" align="Center"><a id="addressA" href="#"
					onclick="checkPostClose('<%=zipcodeDTO.getZipcode()%>','<%=address%>')"><%=address%></a></td>
			</tr>
			<%
				}
			%>
			<%
				}
			%>


		</table>
	</form>

</body>


<script type="text/javascript"
	src="http://localhost:8080/memberJSP//js/member.js"></script>
</html>