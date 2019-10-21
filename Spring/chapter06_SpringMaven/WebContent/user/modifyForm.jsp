<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
	검색할 Id : 
	<input type="text" name="searchId" id="searchId"/>
	<input type="button" value="검색" id="searchBtn"/>
</p>

<div id="resultDiv"></div>

<form id="modifyForm" action="">
<div id="tableDiv">
<table border="1" cellpadding="5" cellspacing="0">
  <tr>
  	<td width="100">이름</td>
  	<td>
  	  <input type="text" name="name" id="name">
  	  <div id="nameDiv"></div>
  	</td>
  </tr>
  <tr>
  	<td>아이디</td>
  	<td>
  	  <input type="text" name="id" id="id" readonly>
  	</td>
  </tr>
  <tr>
  	<td>비밀번호</td>
  	<td>
  	  <input type="text" name="pwd" id="pwd">
  	  <div id="pwdDiv"></div>
  	</td>
  </tr>
  <tr>
  <td colspan="2" align="center">
    <input type="button" id="modifyBtn" value="수정"/>
	<input type="reset" id="resetBtn" value="취소"/>
  </td>
 </tr>
</table>
</div>
</form>
</body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#tableDiv').hide();
	
	$('#searchBtn').click(function(){
		$('#resultDiv').empty();
		
		
		if($('#searchId').val()=='') {
			$('#resultDiv').text('아이디를 먼저 입력하세요');
			$('#resultDiv').css('color', 'red');
			$('#resultDiv').css('font-weight', 'bold');
			
		}else{
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringMaven/user/getUser',
				data: {'id': $('#searchId').val()},
				dataType: 'json',
				success: function(data) {
					//alert(JSON.stringify(data));
					
					if(data.userDTO==null){
						$('#resultDiv').text("찾고자 하는 아이디가 없습니다").css('color', 'red').css('font-weight', 'bold');
					
					}else{
						$('#tableDiv').show();
						$('#name').val(data.userDTO.name);
						$('#id').val(data.userDTO.id);
						$('#pwd').val(data.userDTO.pwd);
					}
				},
				error: function(e) {
					console.log(e);
					alert("실패 = "+e);
				}
				
			});
		}
	});
	
	$('#modifyBtn').click(function(){
		$('#nameDiv').empty();
		$('#pwdDiv').empty();
		
		if($('#name').val()==''){
			$('#nameDiv').text('이름을 입력하세요')
			$('#nameDiv').css('color','red')
			$('#nameDiv').css('font-size','8pt')
			$('#nameDiv').css('font-weight','bold')
		
		}else if($('#pwd').val()==''){
			$('#pwdDiv').text('비밀번호를 입력하세요')
			$('#pwdDiv').css('color','red')
			$('#pwdDiv').css('font-size','8pt')
			$('#pwdDiv').css('font-weight','bold')
		
		}else{
			//$('#modifyBtn').submit();
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringMaven/user/modify',
				data: $('#modifyForm').serialize(),
				success: function(){
					alert('수정 완료!!');
					location.href='http://localhost:8080/chapter06_SpringMaven/main/index.do';
				}
			});
		}
	});

	$('#resetBtn').click(function(){
		$('div').empty();
	});
});
</script>
</html>












