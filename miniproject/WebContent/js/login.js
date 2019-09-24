function checklogin() {
	if (document.loginForm.id.value == "") {
		alert("아이디을 입력하세요");
	} else if (document.loginForm.pwd.value == "") {
		alert("패스워드를 입력하세요");
	} else {
		document.loginForm.submit();
	}
}

