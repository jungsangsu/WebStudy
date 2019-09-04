function checkBoardWrite()
{
	if(document.boardWriteForm.subject.value=="")
	{
		alert("제목을 입력하세요");
	}
	else{
		document.boardWriteForm.submit();
	}
	
}

