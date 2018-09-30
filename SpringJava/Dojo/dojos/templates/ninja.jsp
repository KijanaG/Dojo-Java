<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Ninja</title>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
</head>
<body>
	<h1>New Ninja</h1>
	<br>
	<form:form method="post" modelAttribute="ninja" action="/ninjas/new">
		<form:label path="dojo">Dojo:
			<form:select path="dojo" name="dojo">
				<c:forEach items="${dojos}" var="dojo">
					<form:option value="${dojo.id}"> <c:out value="${dojo.name}" /> </form:option>
				</c:forEach>
			</form:select>
		</form:label>
		<form:label path="firstName">First Name:
			<form:input type="text" path="firstName" />
		</form:label>
		<form:label path="lastName">Last Name:
			<form:input type="text" path="lastName"/>
		</form:label>
		<form:label path="age">Age:
			<form:input type="number" min="15" max="65" path="age"/>
		</form:label>
		<form:button type="submit">Add Ninja</form:button>
	</form:form>
</body>
</html>