<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New License</title>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
</head>
<body>
	<h1>New License</h1>
	<form:form action="/licenses/new" method="post" modelAttribute="license">
		<form:label path="person">Person: </form:label>
		<form:select name="person" path="person">
			<c:forEach items="${persons}" var="person">
				<form:option value="${person}"><c:out value="${person.firstName} ${person.lastName}" /></form:option>
			</c:forEach>
		</form:select>
		<form:label path="state"> State: </form:label>
		<form:input path="state" />
		<form:label path="expiration_date">Expiration Date</form:label>
		<form:input path="expiration_date" type="date"/>
		<form:button type="submit"> Create </form:button>
	</form:form>
</body>
</html>