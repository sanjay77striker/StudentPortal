<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
table {
	padding: 20px;
	background-color: lightblue;
	margin: auto;
}

body {
	background-color: lightyellow;
	text-align: center;
}
</style>

</head>
<body>
	<h1>Student Info Login Page</h1>
	<form method="post" action="/login">

		<table>
			<tr>
				<td><label for="userid">USER ID</label></td>
				<td><input type="text" name="userid" id="userid" /></td>
			</tr>
			<tr>
				<td><label for="password">PASSWORD</label></td>
				<td><input type="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="LOGIN"></td>
			</tr>
		</table>
	</form>
	<h3 style="color:red">${errormsg}</h3>
</body>
</html>