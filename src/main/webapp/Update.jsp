<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="studentDao.StudentDao"%>
<%@page import="studentData.StudentData"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdateDetails</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<style>
.navbar {
	border-radius: 0px;
}

.form-control {
	width: 75%;
}

.container {
	width: 800px;
	margin-top: 80px;
}

.mb {
	margin-left: 15px;
	width: 113%;
}

.btn {
	margin-left: 32%;
}
</style>
</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #6fa7d5;">
		<h2 align="center">Update Student Information</h2>
	</nav>


	<%
	String id = request.getParameter("id");
	StudentData studData = StudentDao.selectUserById(id);
	%>
	<div class="container">
		<form action="StudUpdate" method="post">

			<div class="mb">
				<label for="id" class="form-label">ID :</label> <input input
					type="text" class="form-control" name="id"
					value=" <%=studData.getId()%>" readonly="readonly">
			</div>
			<br>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="name" class="form-label">Student First Name :</label> <input
						type="text" class="form-control" name="studentName"
						value="<%=studData.getStudentName()%>">
				</div>
				<div class="form-group col-md-6">
					<label for="lastName" class="form-label">Student Last Name
						:</label> <input type="text" class="form-control" name="studentLastName"
						value="<%=studData.getStudentLastName()%>">
				</div>
			</div>
			<br>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="aadharNo" class="form-label">Aadhar Card No. :</label>
					<input type="text" class="form-control" name="AadharNo"
						value="<%=studData.getAadharNo()%> ">
				</div>

				<div class="form-group col-md-6">
					<label for="email" class="form-label">Email :</label> <input
						type="email" class="form-control" name="email"
						value="<%=studData.getEmail()%> ">
				</div>
			</div>
			<br>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="department" class="form-label"> Department :</label> <input
						type="text" class="form-control" name="department"
						value="<%=studData.getDepartment()%>">
				</div>
				<div class="form-group col-md-6">
					<label for="pwd" class="form-label"> Password :</label> <input
						type="password" class="form-control" name="password"
						value="<%=studData.getPassword()%>">
				</div>
			</div>
			<br>
			<div>
				<div class="btn">
					<button type="submit" class="btn btn-success">Edit & Save</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>