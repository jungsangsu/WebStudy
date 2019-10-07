<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

  <script src="../js/board.js" type="text/javascript"></script>
  <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
  <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
  <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
  
  <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
  <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>

  <script>
    $(document).ready(function() {
        $('#content').summernote({
		
		height: 300,                 // set editor height
		minHeight: null,             // set minimum height of editor
		maxHeight: null,             // set maximum height of editor
		focus: true                  // set focus to editable area after initializing summernote
  
  
		});
    });
  </script>

<form name="QNAModifyForm" method="post" action="./QNAModify.do">
	<input type="hidden" name="seq" id="seq" value="${seq }" /> <input
		type="hidden" name="pg" id="pg" value="${pg }" />
	<table class="table table-bordered"
		style="margin-top: 300px; width: 1000px; margin-left: auto; margin-right: auto; background-color: aliceblue">

		<tr>
			<!-- 제목 -->
			<td width="70" align="Center">제목</td>
			<td><input type="text" name="subject" id="subject" class="form-control"
				value="${boardDTO.subject }" placeholder="제목 입력"
				style="width: 100%;"></td>
		</tr>

		<tr>
			
			<!-- 내용 -->
			<th width="150" style="text-align: center">내용</th>
			<td><textarea name = "content" id="content">${boardDTO.content }</textarea></td>
		</tr>


		<tr>
			<td colspan="2" align="Center"><input type="button" value="글수정" class="btn btn-outline-secondary"
				onclick="javascript:checkBoardModify()"> <input type="reset" class="btn btn-outline-secondary"
				value="다시작성"></td>
		</tr>

	</table>
</form>
<script type="text/javascript">
	function checkBoardModify() {
		if (document.QNAModifyForm.subject.value == "") {
			alert("제목을 입력하세요");
			document.getElementById("subject").focus();
		} else if (document.QNAModifyForm.content.value == "") {
			alert("내용을 입력하세요");
			document.getElementById("content").focus();
		} else {
			document.QNAModifyForm.submit();
		}
	}
</script>
</html>