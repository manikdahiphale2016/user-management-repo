<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>

	<div align="center">
		<h2>Login</h2>
		<form action="login" method="POST">
			<table border="1">
				<tr>
					<td>User/Email Name:</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>PhoneNumber:</td>
					<td><input type="password" name="phonenumber" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Login" /></td>
				</tr>
			</table>
		</form>
		<br>
		<h2>${msg }</h2>
	</div>
</body>
</html>