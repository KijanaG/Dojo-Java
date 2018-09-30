<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Events</title>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
</head>
<body>
	<div class="container mt-5 mb-4">
		<h1 class="float-left">Welcome, <c:out value="${user.firstName}" /></h1>
		<a class="float-right" href="/logout">Logout</a>
	</div>
	<br>
	<div class="container mt-5">
		<h3 class="float-left">Here are some of the events in your state: </h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<td>Name</td>
					<td>Date</td>
					<td>Location</td>
					<td>Host</td>
					<td>Action / Status</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${inState}" var="event">
					<tr>
						<td> <a href="/event/${event.key.id}"><c:out value="${event.key.name}" /></a></td>
						<td><c:out value="${event.key.date}" /></td>
						<td><c:out value="${event.key.location}" /></td>
						<td><c:out value="${event.key.creator.firstName}" /></td>
						<td>
							<c:choose>
								<c:when test="${event.value == 0}">
									<a style="display:inline-block;"href="/edit/${event.key.id}">Edit</a>&nbsp;<form style="display:inline-block;"method="post" action="/delete/${event.key.id}"><input type="hidden" name="_method" value="delete"><span><input style="border:none; color:blue;background:rgba(5,5,5,0.0);" type="submit" value="Delete" ></span></form>
								</c:when>
								<c:when test="${event.value == 1}">
									<span style="color:orange;">Joining</span> <form style="display:inline-block;" action="/unjoin/${event.key.id}" method="post"><span><input style="border:none; color:purple;background:rgba(5,5,5,0.0);" type="submit" value="Cancel" ></span></form>
								</c:when>
								<c:otherwise>
									<form action="/join/${event.key.id}" method="post"><span><input style="border:none; color:green;background:rgba(5,5,5,0.0);" type="submit" value="Join" ></span></form>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
		<h3>Here are some of the events in other states: </h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<td>Name</td>
					<td>Date</td>
					<td>Location</td>
					<td>State</td>
					<td>Host</td>
					<td>Action / Status</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${outOfState}" var="event">
					<tr>
						<td><a href="/event/${event.key.id}"><c:out value="${event.key.name}" /></a></td>
						<td><c:out value="${event.key.date}" /></td>
						<td><c:out value="${event.key.location}" /></td>
						<td><c:out value="${event.key.state}" /></td>
						<td><c:out value="${event.key.creator.firstName}" /></td>
						<td>
							<c:choose>
								<c:when test="${event.value == 0}">
									<a style="display:inline-block;"href="/edit/${event.key.id}">Edit</a>&nbsp;<form style="display:inline-block;"method="post" action="/delete/${event.key.id}"><input type="hidden" name="_method" value="delete"><span><input style="border:none; color:blue;background:rgba(5,5,5,0.0);" type="submit" value="Delete" ></span></form>
								</c:when>
								<c:when test="${event.value == 1}">
									<span style="color:orange;">Joining</span> <form style="display:inline-block;" action="/unjoin/${event.key.id}" method="post"><span><input style="border:none; color:purple;background:rgba(5,5,5,0.0);" type="submit" value="Cancel" ></span></form>
								</c:when>
								<c:otherwise>
									<form style="display:inline-block;" action="/join/${event.key.id}" method="post"><span><input style="border:none; color:green;background:rgba(5,5,5,0.0);" type="submit" value="Join" ></span></form>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
	<div class="container float-left col-lg-6">
		<form:form method="post" action="/createEvent" modelAttribute="event">
			<h2>Create an Event</h2>
			<form:input type="hidden" path="creator" value="${user.id}"/>
			<table class="table float-left">
				<tbody>
					<tr>	
						<form:errors path="name" style="color:red;"/>
						<td>Name </td>
						<td> <form:input type="text" path="name" /> </td>
					</tr>
					<tr>
						<form:errors path="date" style="color:red;"/>
						<td>Date </td>
						<td> <form:input type="date" path="date" /> </td>
					</tr>
					<tr>
						<form:errors path="location" style="color:red;"/>
						<td>Location </td>
						<td> 
							<form:input type="text" path="location" /> 
							<form:select id="select" path="state" style="justify-content:center" >
                            	<form:option value ='AK'>AK</form:option><form:option value ='AL'>AL</form:option><form:option value ='AR'>AR</form:option><form:option value ='AZ'>AZ</form:option><form:option value ='CA'>CA</form:option><form:option value ='CO'>CO</form:option><form:option value ='CT'>CT</form:option><form:option value ='DC'>DC</form:option><form:option value ='DE'>DE</form:option><form:option value ='FL'>FL</form:option><form:option value ='GA'>GA</form:option><form:option value ='HI'>HI</form:option><form:option value ='IA'>IA</form:option><form:option value ='ID'>ID</form:option><form:option value ='IL'>IL</form:option><form:option value ='IN'>IN</form:option><form:option value ='KS'>KS</form:option><form:option value ='KY'>KY</form:option><form:option value ='LA'>LA</form:option><form:option value ='MA'>MA</form:option><form:option value ='MD'>MD</form:option><form:option value ='ME'>ME</form:option><form:option value ='MI'>MI</form:option><form:option value ='MN'>MN</form:option><form:option value ='MO'>MO</form:option><form:option value ='MS'>MS</form:option><form:option value ='MT'>MT</form:option><form:option value ='NC'>NC</form:option><form:option value ='ND'>ND</form:option><form:option value ='NE'>NE</form:option><form:option value ='NH'>NH</form:option><form:option value ='NJ'>NJ</form:option><form:option value ='NM'>NM</form:option><form:option value ='NV'>NV</form:option><form:option value ='NY'>NY</form:option><form:option value ='OH'>OH</form:option><form:option value ='OK'>OK</form:option><form:option value ='OR'>OR</form:option><form:option value ='PA'>PA</form:option><form:option value ='RI'>RI</form:option><form:option value ='SC'>SC</form:option><form:option value ='SD'>SD</form:option><form:option value ='TN'>TN</form:option><form:option value ='TX'>TX</form:option><form:option value ='UT'>UT</form:option><form:option value ='VA'>VA</form:option><form:option value ='VT'>VT</form:option><form:option value ='WA'>WA</form:option><form:option value ='WI'>WI</form:option><form:option value ='WV'>WV</form:option><form:option value ='WY'>WY</form:option>
                            </form:select>
						</td>
					</tr>
					<tr>
						<td><form:button type="submit"> Create </form:button></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
	<div class="container-right-half float-right"></div>
	</div>
</body>
</html>