<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details</title>
</head>
<body>
<%
String fullname = request.getParameter("fullName");
String address = request.getParameter("address");
String nationalty = request.getParameter("nation");
String nic = request.getParameter("nic");
String bdy = request.getParameter("bdy");
String age = request.getParameter("age");
String gender = request.getParameter("gender");


%>
<form action="update" method="post">
Full Name <input type="text" name="fullName" value="<%= fullname %>">
Address <input type="text" name="address" value="<%= address %>"></br>
Nationality <input type="text" name="nationality" value="<%= nationalty %>">
NIC NO <input type="text" name="NIC" value="<%= nic %>"></br>
Birthday <input type="text" name="birthday" value="<%= bdy %>"></br>
Gender <input type="text" name="age" value="<%= age %>"></br>
Gender <input type="text" name="gender" value="<%= gender %>"></br>
<input type="submit" name="submit" value="Update Details">

</form>

</body>
</html>