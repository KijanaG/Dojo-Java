<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
</head>
<body>
	<c:choose>
		<c:when test="${!bool}">
			<h1>Create A New Team!</h1>
			<form class="form" method="POST" action="/TeamRoster/Teams">
				<label>Team Name: </label>
				<input type="text" name="teamName" />
				<input type="submit" value="Create"/>
			</form>
		</c:when>
		<c:otherwise>
			<h1 class="float-left"> ${name} </h1>
			<h5 class="float-right" style="margin-top:20px; margin-right: 20px;"> <a href="/TeamRoster/Players?teamName=${name}">Add New Player</a> </h5>
			<br>	
			<br>	
			<table class="table table-striped">
				<thead>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
					<th>Action</th>
				</thead>
					<tbody>
					<c:if test="${size > 0}">
						<c:forEach begin="0" end="${size}" var="i" items="${players}">
							<c:forEach items="${i}" var="j">
							<tr>
								<td><c:out value="${j.value[0]}"/></td>
								<td><c:out value="${j.value[1]}"/></td>
								<td><c:out value="${j.value[2]}"/></td>
								<td> <a href="/TeamRoster/DeletePlayer?id=${j.key}&name=${name}"> Delete </a> </td>
							</tr>
							</c:forEach>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>