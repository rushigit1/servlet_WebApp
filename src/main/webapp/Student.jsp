<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Information</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />


<style type="text/css">
.navbar {
	border-radius: 0px;
}

.addStdTag {
	color: #23527c;
	text-decoration: underline;
}

.addStdTag:hover {
	color: #337ab7;
	text-decoration: underline;
}

h3#addStudent {
	margin-left: 20px;
	margin-top: 0px;
	font-family: inherit;
	font-weight: 500;
	font-family: inherit;
}

h1 {
	font-weight: 500;
}

form {
	margin-top: 40px;
}
</style>
</head>
<body>

	<nav class="navbar navbar-light" style="background-color: #6fa7d5;">
		<h3 id=addStudent>
			<a class="addStdTag" href='dashboard.jsp'>View All Information</a>
		</h3>
		<h1 align="center">Add New Student</h1>
	</nav>
	<br>

	<div class="container">
		<form action="SaveServlet" method="post">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="firstName">Student Name:</label> <input type="text"
						class="form-control" name="studentName" required="required"
						placeholder="Enter Name">
				</div>
				<div class="form-group col-md-6">
					<label for="lastName">Student Last Name:</label> <input type="text"
						class="form-control" name="studentLastName" required="required"
						placeholder="Enter Last Name">
				</div>
			</div>
			<br>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="aadharN">Aadhar Card No:</label> <input type="text"
						class="form-control" name="AadharNo" required="required"
						placeholder="Enter Aadhar No.">
				</div>
				<div class="form-group col-md-6">
					<label for="eMail">Email</label> <input type="email"
						class="form-control" name="email" required="required"
						placeholder="abc@gmail.com">
				</div>
			</div>
			<br>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="dpart">Department</label> <input type="text"
						class="form-control" name="department" id=pid
						placeholder="Department">
				</div>
				<div class="form-group col-md-6">
					<label for="pwd">Enter Password</label> <input type="password"
						class="form-control" name="password" id=pid placeholder="Password">
				</div>
			</div>
			<br>
			<div align="center">
				<div>
					<button type="submit" class="btn btn-success">Save_Details</button>
					<button type="reset" class="btn btn-success">Reset</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>