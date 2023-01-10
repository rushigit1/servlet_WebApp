<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="studentDao.StudentDao"%>
<%@page import="studentData.StudentData"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<title>Student Data</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />

<meta charset="ISO-8859-1">
<style>
.navbar {
	border-radius: 0px;
}

#searchBy {
	margin-left: 900px;
	margin-top: 50px;
}

h2 {
	font-size: 34px;
	margin-top: 40px;
}

#addStudent {
	margin-left: 100px;
	margin-top: 20px;
}



.addStdTag {
	color: #23527c;
	text-decoration: underline;
}

select#searchByField {
	height: 25px; .
	addStdTag: hover{ 
	color: #337ab7;
	text-decoration: underline;
}
</style>
</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #6fa7d5;">
		<h2 align="center">All Student Information</h2>
	</nav>
	<h3 id=addStudent>
		<a class="addStdTag" href='Student.jsp'>Add New Student</a>
	</h3>

	<form id='searchBy'>

		<label for="select">Search By...</label> <select class="col-sm"
			aria-label=".form-select example" name="searchByField"
			id="searchByField">
			<option value="StudentName">First Name</option>
			<option value="StudentLastName">Last Name</option>
			<option value="AadharNo">Aadhar No</option>
			<option value="email">Email</option>
			<option value="department">Department</option>
		</select> <input type='search' id='query' name='searchText'
			placeholder='Search...'>
		<button class="btn btn-success">Search</button>
	</form>


	<%
	if (request.getParameter("searchText") != null && request.getParameter("studentLastName") != null
			&& request.getParameter("password") != null) {
	%>
	<h2 id="result">Search Result</h2>
	<%
	} else {
	%>
	<div class="container">
		<h3 align="center">
			<b>Student Data</b>
		</h3>
		<%
		}
		%>


		<table class="table table-striped table-bordered">
			<tr class="info">
				<th>Id</th>
				<th>Student First Name</th>
				<th>Student Last Name</th>
				<th>Aadhar No</th>
				<th>Email</th>
				<th>Department</th>
				<th>Password</th>
				<th>Edit</th>
				<th>Delete</th>

				<%
				List<StudentData> list;

				if (request.getParameter("searchText") != null) {

					list = StudentDao.searchUser(request.getParameter("searchText"), request.getParameter("searchByField"));

				}

				else {
					list = StudentDao.selectAllStudentList();
				}

				for (StudentData studData : list) {
				%>
			
			<tr>
				<td><%=studData.getId()%></td>
				<td><%=studData.getStudentName()%></td>
				<td><%=studData.getStudentLastName()%></td>
				<td><%=studData.getAadharNo()%></td>
				<td><%=studData.getEmail()%></td>
				<td><%=studData.getDepartment()%></td>
				<td><%=studData.getPassword()%></td>
				<td><a href='Update.jsp?id= <%=studData.getId()%>'><button type="button" class="btn btn-primary">edit</button></a></td>
				<td><a href='DeleteServlet?id= <%=studData.getId()%>' onclick="return confirm('Are you sure you want to delete this student?');"><button type="button" class="btn btn-danger">delete</button></a></td>
			</tr>

			<%
			}
			%>

		</table>
	</div>
	

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>
</html>