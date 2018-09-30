<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Survey Index</title>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
     <div class="container" style="width: 700px; margin-top: 100px; border: 8px dashed palevioletred; padding: 5px;">
          <div class=" row">
              <label for="validationServer01" class="col-sm-2 col-form-label">Name: </label>
              <div class="col-sm-10">
                  <p style="margin-top: 10px;"> <c:out value="${name}" /> </p>
              </div>
          </div>
          <div class=" row">
              <label for="validationServer01" class="col-sm-2 col-form-label"> Dojo Location: </label>
              <div class="col-sm-10">
                  <p> <c:out value="${location}" /> </p>
              </div>
          </div>
          <div class=" row">
              <label for="validationServer01" class="col-sm-2 col-form-label"> Favorite Language: </label>
              <div class="col-lg-10">
                  <p> <c:out value="${language}" /> </p>
              </div>
          </div>
          <div class="">
              <label for="exampleFormControlTextarea1">Comment:</label>
              <p> <c:out value="${message}" /> </p>
          </div>
    </div>
</body>
</html>