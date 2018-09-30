<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current visit count</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<br>
	<br>
	<h2>You have visited <a href="/">http://your_server</a> <c:out value="${count}"/> times.</h2>
	<a href="/">Test another visit?</a>
	<a href="/reset"><button> Reset  </button> </a>
</body>
</html>