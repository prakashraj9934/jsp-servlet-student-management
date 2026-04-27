<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: 0px;
	background-color: #EADDCA;
}

.navbar {
	display: flex;
	justify-content: space-between;
	align-items: center;
	background-color: #6E260E;
	padding: 10px 20px;
	color: #F2D2BD;
}

.nav-links a {
	border: 1px solid white;
	padding: 5px;
	margin-left: 20px;
	text-decoration: none;
	color: #F2D2BD;
	font-weight: bold;
}

/* 🔥 Add this (VERY IMPORTANT) */
.nav-links a:visited {
	color: #F2D2BD;
}

.nav-links a:hover {
	color: white;
	background-color: black;
	border-radius: 3px;
}

.nav-links a:active {
	color: white;
}

.navbar a:active {
	color: #F2D2BD;
}

.navbar a:visited {
	color: #F2D2BD;
}

.logout {
	display: inline; 
}

 .logout button {
  border: 1px solid white;
  padding: 5px;
  margin-left: 20px;
  background: transparent;
  color: #F2D2BD;
  font-weight: bold;
  cursor: pointer;
}

.logout button:hover {
  color: white;
  background-color: black;
  border-radius: 3px;
}
</style>
</head>
<body>
	<div class="navbar">
		<h1>
			<a href="register">Student Managment System</a>
		</h1>
		<div class="nav-links">
			<a href="register">Add Student</a> <a href="students">View
				Students</a>
			<form class="logout" action="logout" method="post">
				<button>Logout</button>
			</form>
		</div>



	</div>

</body>
</html>