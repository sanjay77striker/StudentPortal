<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Page</title>
<style>
table {
	padding: 40px;
	background-color: lightblue;
	margin: auto;
	margin-top: 20px;
}

body {
	background-color: lightyellow;
	text-align: center;
}

td {
	text-align: left;
}
</style>
</head>
<body>
	<h2>Student Info Insert Page</h2>

	<form:form modelAttribute="studentdetails" method="post"
		action="/insert">
		<table>
			<tr>
				<td><form:label path="regno">REG NO</form:label></td>
				<td><form:input path="regno" /></td>
				<td><form:errors path="regno" /></td>
			</tr>
			<tr>
				<td><form:label path="name">NAME</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="dob">DOB</form:label></td>
				<td><form:input type="date" path="dob" /></td>
				<td><form:errors path="dob" /></td>
			</tr>
			<tr>
				<td><form:label path="mobileno">MOBILE</form:label></td>
				<td><form:input path="mobileno" /></td>
				<td><form:errors path="mobileno" /></td>
			</tr>
			<tr>
				<td><form:label path="gender">GENDER</form:label></td>
				<td><form:radiobutton path="gender" value="male" label="MALE" />
					<form:radiobutton path="gender" value="female" label="FEMALE" /></td>
				<td><form:errors path="gender" /></td>
			</tr>
			<tr>
				<td><form:label path="std">STD</form:label></td>
				<td><form:select path="std" items="${options}" /></td>
				<td><form:errors path="std" /></td>
			</tr>
			<tr>
				<td><form:label path="hometown">HOME TOWN</form:label></td>
				<td><form:input path="hometown" /></td>
				<td><form:errors path="hometown" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="INSERT" /></td>
			</tr>
		</table>
	</form:form>
	<a href="/home" ><button style="margin:10px">HOME</button></a>
</body>
</html>