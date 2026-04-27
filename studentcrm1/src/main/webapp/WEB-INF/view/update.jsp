<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpdateRegistration</title>
</head>
<body>
<h2 style="color:#F2D2BD; background-color:#954535; text-align:center;"> Update Here</h2>
<hr>
<hr>
	<form action="update" method="post"
		style="background-color: #FCF1E9; margin: auto; width: 300px; border: 4px solid black; padding: 20px; border-radius: 15px; text-align: center;">
			<label for="name">Name: </label> 
			<input type="text" name="name" id="name" value="<%=request.getAttribute("name")%>"/> 
		<br>
		<br> 
			<label for="email">Email: </label> 
			<input type="email" name="email"  id="email" value="<%=request.getAttribute("email")%>"/> 
		<br>
		<br>
		 	<label for="mobile">Mobile: </label> 
		 	<input type="text" name="mobile"  id="mobile" value="<%=request.getAttribute("mobile")%>"/> 
		<br>
		<br>
		<input type="hidden" name="oldemail" value="<%=request.getAttribute("email")%>">
			<button style="margin: 10px; padding: 8px" type="submit">Update</button>
	</form>

	

</body>
</html>