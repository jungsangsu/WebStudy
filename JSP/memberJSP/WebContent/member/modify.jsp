<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>

<HTML>
<head>
<meta charset="UTF-8">
<title>modify.jsp</title>
<body>

	<% 	
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String gender = request.getParameter("gender");
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	String phone1 = request.getParameter("tel1");
	String phone2 = request.getParameter("tel2");
	String phone3 = request.getParameter("tel3");
	String zipcode = request.getParameter("zipcode");
	String addr1 = request.getParameter("addr1");
	String addr2 = request.getParameter("addr2");
	%>
	<%
	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setName(name);
	memberDTO.setId(id);
	memberDTO.setPwd(pwd);
	memberDTO.setGender(gender);
	memberDTO.setEmail1(email1);
	memberDTO.setEmail2(email2);
	memberDTO.setTel1(phone1);
	memberDTO.setTel2(phone2);
	memberDTO.setTel3(phone3);
	memberDTO.setZipcode(zipcode);
	memberDTO.setAddr1(addr1);
	memberDTO.setAddr2(addr2);
	
	System.out.println(memberDTO.toString());
	MemberDAO memberDAO = MemberDAO.getInstance();
	int su = memberDAO.update(memberDTO);

	%>


</body>


<script type="text/javascript">
window.onload=function()
{
	if(<%=su%>==1)
	{
		alert("회원정보 수정 성공");
		location.href="loginForm.jsp";
	}else{
		alert("회원정보 수정 실패");
		location.href="modifyForm.jsp";
	}
	
}
</script>
</HTML>