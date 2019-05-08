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
<style type="text/css">
body {
	background-color: offwhite;
}

.button-tt1 {
	background: darkwhite;
	color: black;
	border-radius: 40px;
	text-shadow: 0 1px 1px rgba(0, 0, 0, 1);
}

.button-tt {
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

.button-error {
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
	background-color: #98dcff;
	border: solid 2px #006CFF;
}

table.custom_class tr.even {
	background-color: #98dcff;
}
</style>
<body>

	<div>

		<h1>${delete2}</h1>
		<h1>${jasper}</h1>
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
					<form action="add" method="post">
						<th scope="col"><input type="number" name="aemp"
							placeholder="EMP_ID_EX_10206" />${result2}${result3}</th>
						<th scope="col"><input type="text" name="aname"
							placeholder="FIRST_NAME" title="please only type ALPHABET" /></th>
						<th scope="col"><input type="text" name="alast"
							placeholder="LAST_NAME" / title="please only type ALPHABET"></th>
						<th scope="col"><input type="submit" onclick="insert()"
							class="button-success" /></th>
					</form>
				</tr>
				<tr>
					<th scope="col">EMP-ID</th>
					<th scope="col">FIRST-NAME</th>
					<th scope="col">LAST-NAME</th>
					<th scope="col">UPDATE-DATA</th>
				</tr>
				<tr>
					<form action="update" method="post">
						<th scope="col"><input type="number" name="aemp"
							placeholder="EMP_ID_EX_10206">${updated1}${up}</th>
						<th scope="col"><input type="text" name="aname"
							placeholder="FIRST_NAME" title="please only type ALPHABET"></th>
						<th scope="col"><input type="text" name="alast"
							placeholder="LAST_NAME" title="please only type ALPHABET"></th>
						<th scope="col"><input type="submit" value="UPDATE"
							class="button-warning pure-button"></th>
					</form>
				</tr>

				<tr>
					<th scope="col">EMP-ID</th>
					<th scope="col">FIND-DATA</th>
				</tr>
				<tr>
					<form action="FIND" method="post">
						<th scope="col"><input type="number" name="aemp"
							placeholder="EMP_ID_EX_10206" />${find1}</th>
						<th scope="col"><input type="submit" value="FIND"
							class="button-tt1 pure-button">
					</form>
				</tr>
				<tr>
					<th scope="col">EMP-ID</th>
					<th scope="col">DELETE-DATA</th>
				</tr>
				<tr>
					<form action="delete" method="post">
						<th scope="col"><input type="number" name="aemp"
							placeholder="EMP_ID_EX_10206">${delete}${delete1}</th>
						<th scope="col"><input type="submit" value="DELETE"
							onclick="delete1()" class="button-error"></th>

					</form>
				</tr>
				<tr>
					<th scope="col">GET-ALL-DATA IN TABLE</th>
					<th scope="col">DOWNLOAD-JASPER-REPORT</th>
					<th scope="col">VIEW-JASPER-REPORT</th>
				</tr>
				<tr>
					<form action="getalldata" method="post">
						<th scope="col"><input type="submit" value="ALL-RECORDS"
							class="button-tt pure-button" />
					</form>
					<form action="getalldataPDF" method="post">
						<th scope="col"><input type="submit" value="DOWNLOAD"
							class="button-tt pure-button" />
					</form>
					<th><a href="jasper.jsp"><input type="submit" value="REPORT" class="button-tt pure-button"></a></th>				
				</tr>
			</thead>
		</table>
	</div>
	<center>
		<h1>${re}</h1>
	</center>
	<center>
		<h1>${findout}</h1>
	</center>
	<center>
		<h1>${insert}</h1>
	</center>
	<center>
		<h1>${found}</h1>
	</center>
	<center>
		<table border="5" bgcolor="#ccccff">
			<thead>
				<tr>
					<th scope="col">EMP_ID</th>
					<th scope="col">FIRST_NAME</th>
					<th scope="col">LAST_NAME</th>
				</tr>
				<tr>
					<th scope="col">${result1.aemp}</th>
					<th scope="col">${result1.aname}</th>
					<th scope="col">${result1.alast}</th>
				</tr>
			</thead>
		</table>
	</center>

</body>
</html>