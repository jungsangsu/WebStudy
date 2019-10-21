<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body {
	background-color: blanchedalmond;
}
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<script type="text/javascript" src="../js/bootstrap.js"></script>

<title>WriteForm</title>
</head>
<body>
	<form id="writeForm" method="post" action="./write">
		<table class="table table-bordered"
			style="margin-top: 100px; width: 500px; margin-left: auto; margin-right: auto; background-color: aliceblue">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" id="name"
					class="form-control">&nbsp;&nbsp;<span id="span_name"
					style="color: red"></span></td>
			</tr>

			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" id="id" class="form-control">
					&nbsp;&nbsp;<span id="span_id" style="color: red"></span>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" id="pwd"
					class="form-control">&nbsp;&nbsp;<span id="span_pwd"
					style="color: red"></span></td>
			</tr>
			<tr align="Center">
				<td colspan="2" align="center"><input type="button"
					id="writeBtn" value="등록" class="form-control" /> <input
					type="reset" id="resetBtn" class="form-control" value="취소" /></td>

			</tr>
		</table>


	</form>
</body>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.4.1.min.js"></script>

<script type="text/javascript">
	$('#writeBtn')
			.click(
					function() {
						$('#span_name').empty();
						$('#span_id').empty();
						$('#span_pwd').empty();

						if ($('#name').val() == '') {
							$('#span_name').text('이름을 입력하세요')
							$('#span_name').css('color', 'red')
							$('#span_name').css('font-size', '8pt')
							$('#span_name').css('font-weight', 'bold')

						} else if ($('#id').val() == '') {
							$('#span_id').text('아이디를 입력하세요')
							$('#span_id').css('color', 'red')
							$('#span_id').css('font-size', '8pt')
							$('#span_id').css('font-weight', 'bold')

						} else if ($('#pwd').val() == '') {
							$('#span_pwd').text('비밀번호를 입력하세요')
							$('#span_pwd').css('color', 'red')
							$('#span_pwd').css('font-size', '8pt')
							$('#span_pwd').css('font-weight', 'bold')

						} else {
							$
									.ajax({
										type : 'post',
										url : '/chapter06_SpringMaven/user/write',
										data : $('#writeForm').serialize(),
										success : function() {
											alert('등록 완료!!');
											location.href = 'http://localhost:8080/chapter06_SpringMaven/main/index';
										}
									});
						}
					});

	$('#id').focusout(function() {
		if ($('#id').val() == '') {
			$('#span_id').text('먼저 아이디를 입력하세요')
			$('#span_id').css('color', 'magenta')
			$('#span_id').css('font-size', '8pt')
			$('#span_id').css('font-weight', 'bold')
		} else {
			$('#span_id').empty();
			$.ajax({
				type : 'post',
				url : '/chapter06_SpringMaven/user/checkId',
				data : 'id=' + $('#id').val(),
				dataType : 'text',
				success : function(data) {
					if (data == 'exist') {
						$('#span_id').text('사용 불가능')
						$('#span_id').css('color', 'magenta')
						$('#span_id').css('font-size', '8pt')
						$('#span_id').css('font-weight', 'bold')

					} else if (data == 'not_exist') {
						$('#span_id').text('사용 가능')
						$('#span_id').css('color', 'blue')
						$('#span_id').css('font-size', '8pt')
						$('#span_id').css('font-weight', 'bold')
					}
				},
				error : function(err) {
					console.log(err);
					alert("실패");
				}
			});
		}
	});

	$('#resetBtn').click(function() {
		$('span').empty();
	});
</script>
</html>

