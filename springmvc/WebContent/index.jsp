<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<style type = "text/css">
       
        table.custom_class {
     margin: auto;
	
	border-collapse: collapse;
	border: 1px solid #fff; /*for older IE*/
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
<th scope="col"><input type="text" name="t1" placeholder="FIRST_NAME"/></th>
<th scope="col"><input type="text" name="t2" placeholder="LAST_NAME"/></th>
<th scope="col"><input type="submit" onclick="insert()"/></th>
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
<th scope="col"><input type="text" name="x1" placeholder="FIRST_NAME"></th>
<th scope="col"><input type="text" name="x2" placeholder="LAST_NAME"></th>
<th scope="col"><input type="submit" value="UPDATE" onclick="update()"></th>
</form>
</tr>

<tr>
<th scope="col">EMP-ID</th>
<th scope="col">GET-DATA</th> 
</tr>
<tr>
<form action="get">
<th scope="col"><input type="number" name="x" placeholder="EMP_ID_EX_10206"/></th>
<th scope="col"><input type="submit" value="GET">
</form>
</tr>
<tr>
<th scope="col">EMP-ID</th>
<th scope="col">DELETE-DATA</th>
</tr>
<tr>
<form action="delete">
<th scope="col"><input type="number" name="x" placeholder="EMP_ID_EX_10206"></th>
<th scope="col"><input type="submit" value="DELETE" onclick="delete1()"></th>
</form>
</tr>
<tr>
<th scope="col">GET-ALL-DATA IN TABLE</th>
</tr>
<tr>
<form action="getalldata">
<th scope="col"><input type="submit" value="ALL-RECORDS"/>
</form>
</tr>
</thead>
</table>
</div>
<script>
function insert()
{
	alert("data is insert");
}
function update()
{
	alert("data is updated");	
}
function delete1()
{
	alert("data is delete");	
}
</script>
</body>
</html>