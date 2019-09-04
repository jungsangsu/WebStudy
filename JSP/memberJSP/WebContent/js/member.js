function checkWrite() {
	if (document.writeForm.name.value == "") {
		alert("이름을 입력하세요");
	} else if (document.writeForm.id.value == "") {
		alert("아이디을 입력하세요");
	} else if (document.writeForm.pwd.value == "") {
		alert("패스워드를 입력하세요");
	} else if (document.writeForm.repwd.value == "") {
		alert("패스워드 확인값을 넣어주세요");
	} else if (document.writeForm.pwd.value != document.writeForm.repwd.value) {
		alert("패스워드값이 맞지않습니다");
	} else if(document.writeForm.id.value != document.writeForm.check.value){
		alert("중복체크를 확인해주세요");
	} else {
		document.writeForm.submit();
	}
}

function checkupdate() {
	if (document.modifyForm.name.value == "") {
		alert("이름을 입력하세요");
	} else if (document.modifyForm.id.value == "") {
		alert("아이디을 입력하세요");
	} else if (document.modifyForm.pwd.value == "") {
		alert("패스워드를 입력하세요");
	} else if (document.modifyForm.repwd.value == "") {
		alert("패스워드 확인값을 넣어주세요");
	} else if (document.modifyForm.pwd.value != document.modifyForm.repwd.value) {
		alert("패스워드값이 맞지않습니다");
	} else {
		document.modifyForm.submit();
	}
}


function checkID(){
	var sID = document.writeForm.id.value; 
	if(sID =="")
	{
		alert("먼저 ID를 입력해주세요");
	}else{
		window.open("http://localhost:8080/memberJSP/member/checkID.jsp?id="+sID,"","width=450 height=100 left=300 top=100 locations=yes");
	}
}

function checkIDClose(id)
{
	opener.writeForm.id.value = id;
	opener.writeForm.check.value = id;
	window.close();
	opener.writeForm.pwd.focus();
}


function checkPost()
{
	window.open("./checkPost.jsp?","","width=700 height=500");
}


function checkPostClose(zipcode, address)
{

//	opener.writeForm.zipcode.value = zipcode;
//	opener.writeForm.addr1.value = address;
//	window.close();
//	opener.writeForm.addr2.focus();
	
//	opener.document.forms[0].zipcode.value = zipcode;
//	opener.document.forms[0].addr1.value = address;
//	window.close();
//	opener.document.forms[0].addr2.focus();
	
	opener.document.getElementById("daum_zipcode").value = zipcode;
	opener.document.getElementById("daum_addr1").value = address;
	window.close();
	opener.document.getElementById("daum_addr2").focus();
}

function checkFirst() {
	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName
							: data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
				// document.getElementById("sample6_extraAddress").value =
				// extraAddr;

			} else {
				// document.getElementById("sample6_extraAddress").value = '';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('daum_zipcode').value = data.zonecode;
			document.getElementById("daum_addr1").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("daum_addr2").focus();
		}
	}).open();
}