<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="dataDTO" class="exam.bean.DataDTO" scope="session"/>
<jsp:setProperty property="x" name="dataDTO"/>
<jsp:setProperty property="y" name="dataDTO"/>

<HTML>
<head>
<meta charset="UTF-8">
<title>sum</title>
<body>



<h5><jsp:getProperty property="x" name="dataDTO"/>+<jsp:getProperty property="y" name="dataDTO"/>
 = <%=dataDTO.getX()+dataDTO.getY()%></h5>
<form name="sumForm" method="get" action="./mul.jsp">

<input type ="submit" value="곱구하기" >
</form>



</script>
</body>
</HTML>
