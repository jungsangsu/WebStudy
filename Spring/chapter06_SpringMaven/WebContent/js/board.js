function checkBoardWrite()
{
	if(document.QNAwriteForm.subject.value=="")
	{
		alert("제목을 입력하세요");
	}
	else{
		document.QNAwriteForm.submit();
	}
	
}

function checkBoardReplyWrite()
{
	if(document.boardReplyForm.subject.value=="")
	{
		alert("제목을 입력하세요");
	} else if(document.boardReplyForm.content.value=="")
	{
		alert("내용을 입력하세요");
	}
	else{
		document.boardReplyForm.submit();
	}
	
}