<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
<h2 style="color:#F2D2BD; background-color:#954535; text-align:center;"> Register Here</h2>
<hr>
<hr>
	<form action="register" method="post"
		style="background-color: #FCF1E9; margin: auto; width: 300px; border: 4px solid black; padding: 20px; border-radius: 15px; text-align: center;">
		<label for="name">Name: </label> <input type="text" name="name"
			placeholder="enter name" id="name"> <br>
		<br> <label for="email">Email: </label> <input type="email"
			name="email" placeholder="enter email" id="email"> <br>
		<br> <label for="mobile">Mobile: </label> <input type="text"
			name="mobile" placeholder="enter mobile.no" id="mobile"> <br>
		<br>
		<button style="margin: 10px; padding: 8px" type="submit">ADD</button>
	</form>

	<%
	if(request.getAttribute("message") != null){
		out.println(request.getAttribute("massage"));
	}
%>

</body>
</html>