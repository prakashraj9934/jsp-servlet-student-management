<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<style>
body {
	margin: 0px;
	background-color: #EADDCA;
}

.navbar h1 {
	background-color: #6E260E;
	padding: 10px 20px;
	color: #F2D2BD;
}

form {
	background-color: #FCF1E9;
	margin: auto;
	width: 300px;
	border: 4px solid black;
	padding: 20px;
	border-radius: 15px;
	text-align: center;
}

.heading h1{
	color: #F2D2BD;
	background-color: #954535;
	text-align: center;
}
}
</style>
<body>
	<div class="navbar">
		<h1>Student Managment System</h1>
	</div>
	<div class="heading"><h1>Login here</h1></div>
	<hr>
	<form action="login" method="post">
		<label for="email">Email: </label> <input type="text" name="email"
			id="email"> <br> <br> <label for="password">Email:
		</label> <input type="password" name="password" id="password"> <br>
		<br>
		<button type="submit">login</button>

	</form>
	<%
	if (request.getAttribute("error") != null) {
		out.println(request.getAttribute("error"));
	}
	%>
</body>
</html>