<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Checkerboard</title>
	<link href="/Checkerboar/assets/draw.css" rel="stylesheet">
</head>
<body>
 	<% Integer width= Integer.parseInt(request.getParameter("width"));  %>
 	 	<% Integer height= Integer.parseInt(request.getParameter("height"));  %>
	<h1> Checkerboard: <%= width %>w X <%= height %>h  </h1>
	<% for(int i=0;i< height;i++) { %>
		<div class ="box">
		<% for(int j=0;j<width;j++) { %>
			<% int pop; %>
			<% if((j+i)%2 ==0){ %>
				<% pop = 1; %>
			<% } else{ %>
				<% pop = 0; %>
			<% } %>
			<div class ="row<%= pop%>"></div>
		<% } %>
		</div>
	<% } %>
</body>
</html>