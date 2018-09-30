<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ninja Gold Game</title>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/gold.css"/>
</head>
<body>
	<div class="container" style="background-color: antiquewhite; width: 255px; margin: 80px auto; border-radius: 10px;">
          <h4 style="display: inline-block; margin: 10px auto;"> Your Gold</h4>
          <h3 style="display: inline-block;"> <c:out value="${gold}" /></h3>
          <img style="width: 30px; height: 30px; display: inline-block; margin-left: 10px; margin-bottom: 12px;" alt="Ycoin.png" src="/img/cryptosteve.jpg">
          
      </div>
      <div class="row">
        <div class="container col-sm-2">
          <h1 style="font-size: 200%; margin-left: 30px;"> Farm </h1>
          <h5 style="margin: 20px auto;">(earns 10-20 golds)</h5>

          <form action="/process_money" method="POST">

            <input type="hidden" name="location" value="0">
            <input class="btn btn-primary text-center" type="submit" value="Find Gold">
          </form>
        </div>
        <div class="container col-sm-2">
            <h1 style="font-size: 200%; margin-left: 30px;"> Cave </h1>
            <h5 style="margin: 20px auto;">(earns 5-10 golds)</h5>
    
            <form action="/process_money" method="POST">

              <input type="hidden" name="location" value="1">
              <input  class="btn btn-primary text-center" type="submit" value="Find Gold">
            </form>
          </div>
          <div class="container col-sm-2">
              <h1 style="font-size: 200%; margin-left: 30px;"> House </h1>
              <h5 style="margin: 20px auto;">(earns 2-5 golds)</h5>
      
              <form action="/process_money" method="POST">

                <input type="hidden" name="location" value="2">
                <input  class="btn btn-primary text-center" type="submit" value="Find Gold">
              </form>
            </div>
            <div class="container col-sm-2">
                <h1 style="font-size: 200%; margin-left: 30px;"> Casino </h1>
                <h5 style="margin: 20px auto;">(earns 0-50 golds)</h5>
        
                <form action="/process_money" method="POST">

                  <input type="hidden" name="location" value="3">
                  <input  class="btn btn-primary text-center" type="submit" value="Find Gold">
                </form>
              </div>
        </div>
        <div class="container text-body">
        	<c:forEach var="i" items="${list}">
        	<c:choose>
	        	<c:when test="${fn:length(i)>73}">
	    	        <h6 style="width:100%; color:red;"><c:out value="${i}"/></h6>
	        	</c:when>
	        	<c:otherwise>
	        		<h6 style="width:100%; color:green;"><c:out value="${i}"/></h6>
	        	</c:otherwise>
        	</c:choose>
        	</c:forEach>
        </div>
</body>
</html>