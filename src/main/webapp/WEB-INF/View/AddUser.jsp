<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<title>Insert title here</title>
	<style type="text/css">
		table {
  			border-collapse: collapse;
		}

		table, th, td {
		  border: 1px solid black;
		}
	</style>

</head>
<body>
<div align="center">
<h1> User Details</h1>
<form action="addUser" method="post">
<table style="with: 80%">
<tr>
<td>Full Name: </td>
<td><input type="text" name="fullName" /></td>
</tr>
<tr>
<td>Address: </td>
<td><input type="text" name="address" /></td>
</tr>
<tr>
<td>Nationality: </td>
<td><input type="text" name="nationality" /></td>
</tr>
<tr>
<td>NIC No: </td>
<td><input type="text" name="NIC" /></td>
</tr>
</table>
<input type="submit" value="Submit"/>
</form>
</div>

</body>
</html>