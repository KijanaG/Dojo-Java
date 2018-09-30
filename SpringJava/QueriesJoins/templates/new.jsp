<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Queries</title>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Language</th>
				<th>Percentage</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${table}" var="t"> 
				<tr>
					<td> <c:out value="${t[0]}" /> </td>
					<td> <c:out value="${t[1]}" /> </td>
					<td> <c:out value="${t[2]}" /> </td>
					<td> <c:out value="${t[3]}" /> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>