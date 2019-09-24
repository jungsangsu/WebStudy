var xhr = null;

function gugudanCalc(){
	var dan = document.getElementById("dan").value;
	
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = calc;
	xhr.open("GET", "gugudanCalc.jsp?dan="+dan, true);
	xhr.send();
	
}

function calc(){
	if(xhr.readyState == 4) {
		if(xhr.status == 200) {
			var resultDiv = document.getElementById("displayArea");
			resultDiv.innerHTML = xhr.responseText;
		}
	}
}