<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<h1>Valid NIC</h1>
<c:forEach var="user" items="${userDetails}">

	<c:set var="fname" value="${user.fullName}"/>
	<c:set var="add" value="${user.address}"/>
	<c:set var="nation" value="${user.nationality}"/>
	<c:set var="nId" value="${user.NIC}"/>
	<c:set var="bdy" value="${user.birthday}"/>
	<c:set var="age" value="${user.age}"/>
	<c:set var="gen" value="${user.gender}"/>

<tr>
<td>User Name:</td>
<td>${user.fullName}</td>
</tr>
<tr>
<td>Address:</td>
<td>${user.address}</td>
</tr>
<tr>
<td>Nationality:</td>
<td>${user.nationality}</td>
</tr>
<tr>
<td>NIC No:</td>
<td>${user.NIC}</td>
</tr>
<tr>
<td>Birthday:</td>
<td>${user.birthday}</td>
</tr>
<tr>
<td>Age :</td>
<td>${user.age}</td>
</tr>
<tr>
<td>Gender:</td>
<td>${user.gender}</td>
</tr>

 
</c:forEach>
</table>

	<c:url value="update" var="usupdate">
		<c:param name="fullName" value="${fname}"/>
		<c:param name="address" value="${add}"/>
		<c:param name="nation" value="${nation}"/>
		<c:param name="nic" value="${nId}"/>
		<c:param name="bdy" value="${bdy}"/>
		<c:param name="age" value="${age}"/>
		<c:param name="gender" value="${gen}"/>
	</c:url>
	
<a href="${usupdate}">
<input type="button" name="update" value="Update Details" />
</a> 

 
</body>
</html>