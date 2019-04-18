<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="add">
<table class="table table-dark">
<thead>
<tr>
<th scope="col">EMP-ID</th>
<th scope="col">FIRST-NAME</th>
<th scope="col">LAST-NAME</th>
<th scope="col">INSERT-DATA</th>
</tr>
</thead>
<tbody>
<tr>
<th scope="col"><input type="number" name="t"/></th>
<th scope="col"><input type="text" name="t1"/></th>
<th scope="col"><input type="text" name="t2"/></th>
<th scope="col"><input type="submit" onclick="insert()"/></th>
</tr>
</tbody>
</table>
</form>
<hr>
<form action="get">
<table>
<thead>
<tr>
<th scope="col">EMP-ID</th>
<th scope="col">GET-DATA</th> 
</tr>
</thead>
<tbody>
<tr>
<th scope="col"><input type="number" name="x"/></th>
<th scope="col"><input type="submit" value="GET">

</tr>
</tbody>
</table>
<hr>
</form>
<form action="update">
<table>
<thead>
<tr>
<th scope="col">EMP-ID</th>
<th scope="col">FIRST-NAME</th>
<th scope="col">LAST-NAME</th>
<th scope="col">UPDATE-DATA</th>
</tr>
</thead>
<tbody>
<tr>
<th scope="col"><input type="number" name="x"></th>
<th scope="col"><input type="text" name="x1"></th>
<th scope="col"><input type="text" name="x2"></th>
<th scope="col"><input type="submit" value="UPDATE" onclick="update()"></th>
</tr>
</tbody>
</table>
</form>
<hr>
<form action="delete">
<table>
<thead>
<tr>
<th scope="col">EMP-ID</th>
<th scope="col">DELETE-DATA</th>
</tr>
</thead>
<tbody>
<tr>
<th scope="col"><input type="number" name="x"></th>
<th scope="col"><input type="submit" value="DELETE" onclick="delete1()"></th>
</tr>
</tbody>
</table>
</form>
<hr>
<form action="getalldata">
<table>
<thead>
<tr>
<th scope="col">GET-ALL-RECORDS</th>
<tr>
</thead>
<tbody>
<tr>
<th scope="col"><input type="submit" value="ALL-RECORDS"/>
</tr>
</tbody>
</table>
</form>
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