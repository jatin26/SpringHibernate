<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
<c:forEach items="${result}" var="element"> 
  <tr>
    <td>${element.aemp}</td>
    <td>${element.aname}</td>
    <td>${element.alast}</td>
    
  </tr>
</c:forEach>
</table>


 <!--<table border=1>
	<tr>
	<th>EMPLOYEE DETAILS</th>
	</tr>
 	<tr>
 	  <th>${result}</th>
 	
	</tr>
</table>-->
</body>
</html>