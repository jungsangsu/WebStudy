function checkimageBoardWrite()
{
	if(document.imageboardWriteForm.imageId.value=="")
	{
		alert("상품코드을 입력하세요");
	}else if(document.imageboardWriteForm.imageName.value==""){
		alert("상품명을 입력하세요");
	}else if(document.imageboardWriteForm.imagePrice.value==""){
		alert("단가를 입력하세요");
	}else if(document.imageboardWriteForm.imageQty.value==""){
		alert("갯수를 입력하세요");
	}else if(document.imageboardWriteForm.imageContent.value==""){
		alert("내용를 입력하세요");
	}
	else{
		document.imageboardWriteForm.submit();
	}
}

function detailView(){
	var img = document.getElementById("mainImg").getAttribute("alt");
	window.open("http://localhost:8080/miniproject/imageboard/imageDetail.jsp?img="+img,"","width=500,height=500,top=300,left=300,location=yes");
}



