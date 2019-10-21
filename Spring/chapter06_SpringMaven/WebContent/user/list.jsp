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
<title>Insert title here</title>
</head>
<body>
	<div id="display">
		<a href="../main/index"><img src="../img/back.png" width="100px"></a>
		<table class="table table-bordered" id="table"
			style="margin-top: 100px; width: 500px; margin-left: auto; margin-right: auto; background-color: aliceblue">
			<tr style="text-align: center">
				<th width="100">이름</th>
				<th width="100">아이디</th>
				<th width="100">비밀번호</th>
			</tr>
			<tbody id="t"></tbody>
		</table>
		<select name="key" id="key" value="선택">
			<option value="" selected="selected">-- 선택 --</option>
			<option value="id">ID</option>
			<option value="name">NAME</option>
		</select> <input type="text" id="content"> <input type="button"
			id="searchBtn" value="검색">
	</div>

</body>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$.ajax({
		type : 'post',
		url : '/chapter06_SpringMaven/user/getList',
		dataType : 'json',
		success : function(data) {
			//alert(JSON.stringify(data));

			$.each(data.list, function(index, items) {
				$('<tr/>').append($('<td/>', {
					align : 'center',
					text : items.name
				})).append($('<td/>', {
					align : 'center',
					text : items.id
				})).append($('<td/>', {
					align : 'center',
					text : items.pwd
				})).appendTo('#table');

			});

			/* index	items
			  0		{'name': '홍길동', 'id': 'hong', 'pwd': '111'}
			  1		{'name': '코난',  'id': 'conan', 'pwd': '111'}
			  2		{'name': '또치',  'id': 'ddochi', 'pwd': '111'}	 */

		},
		error : function(e) {
			console.log(e);
			alert("실패");
		}
	});

	$('#searchBtn').click(function() {

		if ($('#key option:selected').val() == '') {
			alert("검색 옵션을 선택해주세요");
		} else {
			$.ajax({
				type : 'post',
				url : '/chapter06_SpringMaven/user/search',
				data : {
					'key' : $('#key').val(),
					'content' : $('#content').val()
				},
				dataType : 'json',
				success : function(data) {
					$('td').remove();

					$.each(data.list, function(index, items) {
						$('<tr/>').append($('<td/>', {
							align : 'center',
							text : items.name
						})).append($('<td/>', {
							align : 'center',
							text : items.id
						})).append($('<td/>', {
							align : 'center',
							text : items.pwd
						})).appendTo('#table');

					});

					/* index	items
					  0		{'name': '홍길동', 'id': 'hong', 'pwd': '111'}
					  1		{'name': '코난',  'id': 'conan', 'pwd': '111'}
					  2		{'name': '또치',  'id': 'ddochi', 'pwd': '111'}	 */

				},
				error : function(e) {
					console.log(e);
					alert("실패");
				}
			});
		}

	});
</script>
</html>