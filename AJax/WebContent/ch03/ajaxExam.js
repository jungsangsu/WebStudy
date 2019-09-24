var xhr=null;
function startMethod(){
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = resultProcess;
	xhr.open("GET", "ajaxExam.xml", true);
	xhr.send(null);
}

function resultProcess(){
    if(xhr.readyState==4){
        if(xhr.status==200){
            processXML();
        }
    }
}

function processXML(){
    var xmlDoc = xhr.responseXML;
    
    var subjeckList = xmlDoc.getElementsByTagName("subject");
    var message = "";
    
    for(var i=0; i<subjeckList.length;i++){
        var subject = subjeckList.item(i);
        
        var codeNumber = subject.getElementsByTagName("codeNumber").item(0).firstChild.nodeValue;
        var titleName = subject.getElementsByTagName("titleName").item(0).firstChild.nodeValue;
        var roomNumber = subject.getElementsByTagName("roomNumber").item(0).firstChild.nodeValue;
        
        message+=("<tr><td width='100px'>"+codeNumber+"</td><td width='100px'>"+titleName+"</td><td width='100px'>"+roomNumber+"</td></tr>");
    }
    
    var dis = document.getElementById("resultDisplay");
    dis.innerHTML = message;

    
}