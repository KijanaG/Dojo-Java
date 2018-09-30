<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Survey Index</title>
	<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<div class="container" style="width: 700px; margin-top: 100px; border: 20px dashed blanchedalmond; padding: 5px;">
        <form action="/result" method="POST">
            <div class="form-group row">
                <label for="validationServer01" class="col-sm-2 col-form-label"> Name: </label>
                <div class="col-sm-10">
                    <input name = "name" class="form-control" placeholder="Enter Full Name" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="validationServer01" class="col-sm-2 col-form-label"> Dojo Location </label>
                <div class="col-lg-10">
                    <select id="sell" class="form-control" name="select">
                        <option>Seattle</option>
                        <option>San Jose</option>
                        <option>Burbank</option>
                        <option>Dallas</option>
                        <option>Chicago</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label for="validationServer01" class="col-sm-2 col-form-label"> Favorite Language </label>
                <div class="col-lg-10">
                    <select id="sell" class="form-control" name="language">
                        <option>Python</option>
                        <option>HTML & CSS</option>
                        <option>Java</option>
                        <option>JavaScript</option>
                        <option>Ruby</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="exampleFormControlTextarea1">Comment (optional):</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="message" required></textarea>
            </div>
            <input class="btn btn-outline-info" type="submit" value="Submit">
        </form>
    </div>
</body>
</html>