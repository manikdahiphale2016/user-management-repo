<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
</head>
<body>
	<div align="center">
		<h2>Register User...!</h2>
		<form action="registerUser" method="POST">
			<table border="1">
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>PhoneNumber:</td>
					<td><input type="text" name="phoneNumber"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Register"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>