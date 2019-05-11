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

<center><table border="5" bgcolor="#ccccff"> 
<thead>
<tr>
<th scope="col">EMP_ID</th>
<th scope="col">FIRST_NAME</th>
<th scope="col">LAST_NAME</th>
</tr>
</thead>
<tbody>
<c:forEach items="${result}" var="element"> 
  <tr>
    <th>${element.aemp}</th>
    <th>${element.aname}</th>
    <th>${element.alast}</th>
    
  </tr>
</c:forEach>
</tbody>
</table></center>
<center><table border="5" bgcolor="#ccccff"> 
<thead>
<tr>
<th scope="col">EMP_ID</th>
<th scope="col">FIRST_NAME</th>
<th scope="col">LAST_NAME</th>
</tr>
</thead>
<tbody>
<c:forEach items="${query}" var="element2"> 
  <tr>
    <th>${element2.aemp}</th>
    <th>${element2.aname}</th>
    <th>${element2.alast}</th>
    
  </tr>
</c:forEach>
</tbody>
</table></center>


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