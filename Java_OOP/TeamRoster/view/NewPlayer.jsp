<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1>Add a player to team</h1>
	<form class="form" method="POST" action="/TeamRoster/Players">
		<label>First Name: </label>
		<input type="text" name="firstName" />
		<input type="text" name="lastName" />
		<input type="number" name="age" min="10" max="70"/>
		<input type="submit" value="Add"/>
	</form>
</body>
</html>