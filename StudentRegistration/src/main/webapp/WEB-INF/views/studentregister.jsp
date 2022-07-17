<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align = "center">
<h1>Student Registration</h1>
<form action="<%= request.getContextPath()%>/register" method ="post">
<table style = "with: 80%">
<tr>
<td>First Name : </td>
<td><input type= "text" name="firstName" /></td>
</tr>
<tr>
<td>Last Name : </td>
<td><input type= "text" name="lasttName" /></td>
</tr>
<tr>
<td>Password : </td>
<td><input type= "password" name="password" /></td>
</tr>
<tr>
<td>Address : </td>
<td><input type= "text" name="address" /></td>
</tr>
<tr>
<td>Mobile No : </td>
<td><input type= "text" name="mobile" /></td>
</tr>
</table>
<input type = "submit" value = "Register" />
</form>
</div>

</body>
</html>