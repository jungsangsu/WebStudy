function checkWrite() {
	// if(document.paramForm.name.value==""){
	if (document.writeForm.title.value == "") {
		alert("제목을 입력하세요");
	} else if (document.writeForm.context.value == "") {
		alert("내용을 입력하세요");
	} else {
		document.writeForm.submit();
	}
}