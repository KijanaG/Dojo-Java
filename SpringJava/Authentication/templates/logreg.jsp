<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
    <head>
        <title>Registration Form</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <link rel="stylesheet" type="text/css" href="/css/intro.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>

    <body>
        <div id="window">
            <div class="container" id="login">
                <h2 id="login_title"> Login </h2>
                <form action="/login" method="POST" class="float-right" style="margin-left: 40px;">
                    <table>
                        <tbody>
						    <p style="color:red;" ><c:out value="${error}" /></p>
                            <tr>
                                <div class="col-2 form-group">Email:
                                    <input type="email" name="email">
                                </div>
                            </tr>

                            <tr>
                                <div class="col-2 form-group">Password:
                                    <input type="password" name="password">
                                </div>
                            </tr>
                        </tbody>
                    </table>
                    <div style="margin-left: 10px;">
                        <input class="btn btn-info" id="top" type="submit" value="Login">
                    </div>
                </form>
            </div> 
    <!-- ################################################################################################################################################### -->
            <div class="container" id="container">
                <h2 id="reg_title" style="margin-left: 48px;"> Registration </h2>
                <form:form action="/registration" method="POST" class="float-right" style="margin-left: 35px;" modelAttribute="user">
                    <table>
                        <tbody>
	                        <tr>

	                        </tr>
<!--                             <tr>
                                <div class="col-7 form-group">First Name:
                                    <input type="text" name="first_name">
                                </div>
                            </tr>

                            <tr>
                                <div class="col-7 form-group">Last Name:
                                    <input type="text" name="last_name">
                                </div>
                            </tr> -->

                            <tr>
                            	<form:errors path="email" style="color: red;" />
                                <div class="col-2 form-group">Email:
                                    <form:input type="email" path="email"/>
                                </div>
                            </tr>

                            <tr>
                         	   	<form:errors path="passwordConfirmation" style="color: red;" />
								<form:errors path="password" style="color: red;" />
                                <div class="col-2 form-group">Password:
                                    <form:input type="password" path="password"/>
                                </div>
                            </tr>
                            <tr>
                                <div class="col-7 form-group">Confirm Password:
                                    <form:password path="passwordConfirmation"/>
                                </div>
                            </tr>
                        </tbody>
                    </table>
                    <div style="margin-left: 10px;">
                        <input class="btn btn-info btn-lg" type="submit" value="Register">
                    </div>
                </form:form>
            </div>
        </div>
        <script>
            $('#container').css({'height':'auto','display':'table'})
            $('#login').css({'height':'auto','display':'table'})
        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    </body>
</html>