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
<form name="boardReplyForm" method="post" action="./QNAReply.do">
	<table class="table table-bordered"
		style="margin-top: 300px; width: 1000px; margin-left: auto; margin-right: auto; background-color: aliceblue">
		<tr>
			<th colspan="2">답글쓰기</th>
		</tr>
		<tr>
			<th width="150" style="text-align: center">제목</th>
			<td><input type="text" name="subject" id="subject"
				class="form-control" placeholder="제목 입력" style="width: 100%;"></td>
		</tr>

		<tr>
			<!-- 내용 -->
			<th width="150" style="text-align: center">내용</th>
			<td><textarea name = "content" id="content"></textarea></td>
		</tr>


		<tr>
			<td colspan="2" align="Center"><input type="button" value="답글쓰기"
				onclick="javascript:checkBoardReplyWrite()"> <input type="reset"
				value="다시작성"></td>
		</tr>

	</table>
	
	<input type="hidden" name="pseq" value="${requestScope.pseq }">
	<input type="hidden" name="pg" value="${requestScope.pg }">
	
</form>

<script src="../js/board.js" type="text/javascript"></script>