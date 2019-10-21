<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteForm</title>
</head>
<body>
	<p>
		삭제할 Id : <input type="text" name="deleteId" id="deleteId" /> <input
			type="button" value="검색" id="deleteBtn" />
	</p>

	<div id="resultDiv"></div>
</body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#deleteBtn').click(function(){
		$('#resultDiv').empty();
		
		if($('#deleteId').val()=='') {
			$('#resultDiv').text('아이디를 먼저 입력하세요');
			$('#resultDiv').css('color', 'red');
			$('#resultDiv').css('font-weight', 'bold');
			
		}else{
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringMaven/user/getUser',
				data: {'id': $('#deleteId').val()},
				dataType: 'json',
				success: function(data) {
					//alert(JSON.stringify(data));
					
					if(data.userDTO==null){
						$('#resultDiv').text("찾고자 하는 아이디가 없습니다").css('color', 'red').css('font-weight', 'bold');
					
					}else{
						$('#tableDiv').show();
						var result = confirm('정말로 삭제하시겠습니까?');
						if(result){
							$.ajax({
								type: 'post',
								url: '/chapter06_SpringMaven/user/delete',
								data: {'id': $('#deleteId').val()},
								success: function(){
									alert("삭제 완료!!");
									location.href='http://localhost:8080/chapter06_SpringMaven/main/index.do';
								},
								error: function(err){
									console.log(e);
									alert("실패 = "+e);
								}
							});
						}

					}
				},
				error: function(e) {
					console.log(e);
					alert("실패 = "+e);
				}
				
			});
		}
	});

});
</script>

</html>