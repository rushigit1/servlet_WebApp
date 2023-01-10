<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<form action='LoginServlet' method = "post">
		<table>
			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="studentName" id=Fid
					placeholder="First Name"></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><input type="text" name="studentLastName" id=Lid
					placeholder="Last Name"></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password" id=pid
					placeholder="Password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" placeholder="Enter" onclick = "alert('You are Successfully Login Your Account')" ></td>
			</tr>
		</table>
	</form>


</body>
</html>