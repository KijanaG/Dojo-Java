<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
	<title>${event.name}</title>
</head>
<body>
	<div class="mt-5 mb-4">
		<h1><c:out value="${event.name}" /></h1>
	</div>
	<br>
	<div class="container">
		<div class="col-lg-6 float-left">
			<h3>Host: <c:out value="${event.creator.firstName} ${event.creator.lastName}" /></h3>
			<h3><c:out value="${event.date}" /></h3>
			<h3><c:out value="${event.location}, ${event.state}" /></h3>
			<h3>Number of attendees: <c:out value="${event.attendees.size()}" /></h3>
			<table class="table table-striped">
				<thead>
					<td>Name </td>
					<td>Location</td>
				</thead>
				<tbody>
					<c:forEach items="${event.attendees}" var="person">
						<tr>
							<td><c:out value="${person.firstName} ${person.lastName}" /></td>
							<td><c:out value="${person.location}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-lg-6 float-right">
			<h2>Message Wall</h2>
			<div class="container mb-4" style="overflow:scroll;height:50vh;border:1px dashed black;">
				<c:forEach items="${messages}" var="message">
					<p class="pb-5"><c:out value="${message.user.firstName} ${message.user.lastName}" />: <c:out value="${message.comment}" /></p>
					<hr>
				</c:forEach>
			</div>
			<form:form method="post" modelAttribute="message" action="/addMessage/${event.id}">
				<form:errors path="message.*" />
				<h4 class="float-left">Add Comment:</h4>
				<form:input type="hidden" path="user" value="${user_id}"/>
				<form:input type="hidden" path="event" value="${event.id}"/>
				<form:textarea class="container-fluid" path="comment"></form:textarea>
				<form:button class="float-right" type="submit">Submit</form:button>
			</form:form>
		</div>
	</div>
</body>
</html>