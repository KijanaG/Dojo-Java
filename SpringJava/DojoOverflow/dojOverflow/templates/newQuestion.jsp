<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Question</title>
<%-- 	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<h1>What is your question?</h1>
	<form method="post" action="/questions/new" class="form-group">
	<table>
		<tbody>
			<tr>
				<td><label>Question:</label></td>
				<td><textarea name="query" rows="4" cols="30"></textarea></td>
			</tr>
			<tr>
				<td><label>Tags:</label> </td>
				<td><input type="text" name="tags" /></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">Submit</button></td>			
			</tr>
		</tbody>
	</table>
	</form>
</body>
</html>