<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home page</title>
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

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 10px;
}

button {
	margin-left: 10px;
	margin-right: 10px;
}

form {
	margin-top: 10px;
}
</style>
</head>
<body>
	<h2>Student Info Home Page</h2>
	<a href="/insert"><button>INSERT DETAILS</button></a>
	<a href="/show"><button>SHOW DETAILS</button></a>

	<form action="/search" method="get">
		<input type="text" name="regno" id="regno"
			placeholder="search by Reg No." /> <input type="submit"
			value="search" />
	</form>
    
    <h3 style="color:red">${msg}</h3>
    
	<c:if test="${not empty student}">
		<table>
		 
			<tr>
				<th>Register No.</th>
				<th>Name</th>
				<th>DOB</th>
				<th>Mobile No.</th>
				<th>Gender</th>
				<th>Standard</th>
				<th>Home town</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>

			<tr>
				<td><c:out value="${student.regno}"></c:out></td>
				<td><c:out value="${student.name}"></c:out></td>
				<td><c:out value="${student.dob}"></c:out></td>
				<td><c:out value="${student.mobileno}"></c:out></td>
				<td><c:out value="${student.gender}"></c:out></td>
				<td><c:out value="${student.std}"></c:out></td>
				<td><c:out value="${student.hometown}"></c:out></td>
				<td><a href="/update?regno=${student.regno}"><button>update</button></a>
				<td><a href="/delete?regno=${student.regno}"><button>delete</button></a>
			</tr>

		</table>
	</c:if>

	<c:if test="${not empty list}">

		<table>
			<tr>
				<th>Register No.</th>
				<th>Name</th>
				<th>DOB</th>
				<th>Mobile No.</th>
				<th>Gender</th>
				<th>Standard</th>
				<th>Home town</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${list}" var="e">
				<tr>
					<td><c:out value="${e.regno}"></c:out></td>
					<td><c:out value="${e.name}"></c:out></td>
					<td><c:out value="${e.dob}"></c:out></td>
					<td><c:out value="${e.mobileno}"></c:out></td>
					<td><c:out value="${e.gender}"></c:out></td>
					<td><c:out value="${e.std}"></c:out></td>
					<td><c:out value="${e.hometown}"></c:out></td>
					<td><a href="/update?regno=${e.regno}"><button>update</button></a>
					<td><a href="/delete?regno=${e.regno}"><button>delete</button></a>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>

</html>
