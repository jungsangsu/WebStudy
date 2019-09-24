<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	double[] maxTemperature = {10.2,11.0,12.9,9.0};

	for(int i=0;i<maxTemperature.length;i++){
		
		out.print(maxTemperature[i]);
		
		if(i<maxTemperature.length-1)
		{
			out.print(",");
		}
	}

%>