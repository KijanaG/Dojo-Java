<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prototype Roster</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
</head>
<body>
	<h1 class="float-left"> Prototype Roster </h1>
	<h5 class="float-right" style="margin-top:20px; margin-right: 20px;"> <a href="/TeamRoster/Teams">Add New Team</a> </h5>
	<br>
	<br>
	<table class="table table-striped">
		<thead>
			<th>Team</th>
			<th>Players</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:if test="${total != null}">
				<c:forEach begin="0" end="${total}" var="i" items="${roster}">
					<c:forEach items="${i}" var="j">
					<tr>
						<td><c:out value="${j.key}"/></td>
						<td><c:out value="${j.value.size()}"/></td>
						<td> <a href="/TeamRoster/Teams?nameOfTeam=${j.key}">Details</a> &nbsp; <a href="/TeamRoster/DeleteTeam?team=${j.key}">Delete</a> </td>
					</tr>
					</c:forEach>
				</c:forEach>
			</c:if>
		</tbody>
	</table>


</body>

</html>