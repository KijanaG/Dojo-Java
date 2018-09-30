<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Languages</title>
	<%-- <%@ page isErrorPage="true" %> --%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>
<body>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Language</th>
				<th>Action</th>	
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${languages}" var="language">
				<tr>
					<td> <a href="/languages/${language.id}"><c:out value="${language.name}" /></a></td>
					<td> <c:out value="${language.creator}" /> </td>
					<td> <c:out value="${language.currentVersion}" /> </td>
					<td>
						<form:form action="/languages/${language.id}" method="delete" class="form">
							<input type="submit" value="Delete" />
						</form:form> 
						<a href="/languages/edit/${language.id}"> Edit </a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<form:form action="/languages" method="post" modelAttribute="language" class="form">
			<p>
				<form:label path="name">Name:</form:label>
				<form:errors path="name" />
				<form:input path="name" /> 
			</p>
			<p>
				<form:label path="creator">Creator:</form:label>
				<form:errors path="creator" />
				<form:input path="creator" />
			</p>
			<p>
				<form:label path="currentVersion">Version: </form:label>
				<form:errors path="currentVersion" />
				<form:input path="currentVersion" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
</body>
</html>