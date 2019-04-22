<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<style type = "text/css">
       
        .button-tt1{
        	 background: darkwhite; 
         color: black;
            border-radius: 40px;
            text-shadow: 0 1px 1px rgba(0, 0, 0, 1);
        }
        .button-tt{
         background: yellow; 
         color: black;
            border-radius: 40px;
            text-shadow: 0 1px 1px rgba(0, 0, 0, 1);
        }
        .button-success {
            background: rgb(50, 184, 10); 
         color: black;
            border-radius: 40px;
            text-shadow: 0 1px 1px rgba(0, 0, 0, 1);
        	
        }
        .button-error{
        background: rgb(202, 60, 60);
         color: black;
            border-radius: 40px;
        text-shadow: 0 1px 1px rgba(0, 0, 0, 1);
        }
        .button-warning {
            background: rgb(223, 117, 20); 
       	color: black;
            border-radius: 40px;
            text-shadow: 0 1px 1px rgba(0, 0, 0, 1);
        	
        }
        table.custom_class {
     margin: auto;
	
	border-collapse: collapse;
	border: 1px solid #fff; 
	border-style: hidden;
}
    table.custom_class caption {
	background-color: #f79646;
	color: #fff;
	font-size: large;
	font-weight: bold;
	letter-spacing: .3em;
}
     table.custom_class th {
  padding: 10px;
  background-color:#98dcff;
  border:solid 2px #006CFF;
} 
table.custom_class tr.even {
	background-color: #98dcff;
}
</style>
<body style="background-color: #000000;">
<div>

<table class="custom_class">
<caption>SPRING-MVC_HIBERNATE_CRUD</caption>
<thead>
<tr>
<th scope="col">EMP-ID</th>
<th scope="col">FIRST-NAME</th>
<th scope="col">LAST-NAME</th>
<th scope="col">INSERT-DATA</th>
</tr>
<tr>
<form action="add">
<th scope="col"><input type="number" name="t" placeholder="EMP_ID_EX_10206"/></th>
<th scope="col"><input type="text" name="t1" placeholder="FIRST_NAME" title="please only type ALPHABET"/></th>
<th scope="col"><input type="text" name="t2" placeholder="LAST_NAME"/ title="please only type ALPHABET"></th>
<th scope="col"><input type="submit" onclick="insert()" class="button-success"/></th>
</form>
</tr>
<tr>
<th scope="col">EMP-ID</th>
<th scope="col">FIRST-NAME</th>
<th scope="col">LAST-NAME</th>
<th scope="col">UPDATE-DATA</th>
</tr>
<tr>
<form action="update">
<th scope="col"><input type="number" name="x" placeholder="EMP_ID_EX_10206"></th>
<th scope="col"><input type="text" name="x1" placeholder="FIRST_NAME" title="please only type ALPHABET"></th>
<th scope="col"><input type="text" name="x2" placeholder="LAST_NAME" title="please only type ALPHABET"></th>
<th scope="col"><input type="submit" value="UPDATE" onclick="update()" class="button-warning pure-button"></th>
</form>
</tr>

<tr>
<th scope="col">EMP-ID</th>
<th scope="col">GET-DATA</th> 
</tr>
<tr>
<form action="get">
<th scope="col"><input type="number" name="x" placeholder="EMP_ID_EX_10206"/></th>
<th scope="col"><input type="submit" value="GET" class="button-tt1 pure-button">
</form>
</tr>
<tr>
<th scope="col">EMP-ID</th>
<th scope="col">DELETE-DATA</th>
</tr>
<tr>
<form action="delete">
<th scope="col"><input type="number" name="x" placeholder="EMP_ID_EX_10206"></th>
<th scope="col"><input type="submit" value="DELETE" onclick="delete1()" class="button-error"></th>
</form>
</tr>
<tr>
<th scope="col">GET-ALL-DATA IN TABLE</th>
</tr>
<tr>
<form action="getalldata">
<th scope="col"><input type="submit" value="ALL-RECORDS" class="button-tt pure-button"/>
</form>
</tr>
</thead>
</table>
</div>
</body>
</html>