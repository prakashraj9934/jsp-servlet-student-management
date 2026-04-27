<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view students</title>
</head>
<style>
td {
  text-align: center;
  padding: 6px;
}

.delete-btn {
  padding: 4px 9px;
  background-color: red;
  color: white;
  text-decoration: none;
  border-radius: 2px;
}
.update-btn {
  padding: 4px 9px;
  background-color: green;
  color: white;
  text-decoration: none;
  border-radius: 2px;
}

/* Hover effect */
.delete-btn:hover {
  background-color: darkred;
}

.update-btn:hover {
  background-color: darkgreen;
}
.massage {
bottom-margin:10;
}
</style>
<body>
	<h2 style="color:#F2D2BD; background-color:#954535; text-align:center;">All Students</h2>
	<table  border="1" style="margin:auto; width:60%; font-size:18px;" >
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>


		<%
	ResultSet result = (ResultSet)request.getAttribute("result");
	while(result.next()){%>

		<tr>
			<td><%= result.getString(1) %></td>
			<td><%= result.getString(2) %></td>
			<td><%= result.getString(3) %></td>
			<td><a class="delete-btn" href="delete?email=<%=result.getString(2)%>">delete</a></td>
			<td><a class="update-btn" href="update?email=<%=result.getString(2)%>&mobile=<%=result.getString(3)%>&name=<%=result.getString(1)%>">update</a></td>
			
		</tr>
		
		<%} %>
		




	</table>
		<div class="massage">
		<% if(request.getAttribute("massage") != null){
			out.println("<p style='color:green; text-align:center;'>" + request.getAttribute("massage") + "</p>");
		}
			%>
		</div>

</body>
</html>