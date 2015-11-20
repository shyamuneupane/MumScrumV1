<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<spring:url value="/resources/css/bootstrap.min.css" var="mainCss" />
<spring:url value="/resources/css/bootstrap.css" var="mainCss" />
<spring:url value="/resources/js/bootstrap.min.js" var="jqueryJs" />
<link href="${mainCss}" rel="stylesheet" />
<script src="${mainJs}"></script>
<meta charset="utf-8">
<title>MUMScrum Welcome</title>
</head>
<body style="background-repeat: no-repeat ; 	background-size: 390px 300px;"

    background="<spring:url value="/resources/image/headerImage.jpg"  /> ">
    
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h2 class="text-center">Welcome to MUM Scrum</h2>
				<h5 class="text-center">"A Scrum Tool For Managing Scrum Project"</h5>
			</div>
			<div class="modal-body">
				<form class="col-md-12 center-block" action="mumscrum.dashboard"
					method="post">
					<br><br>
					<label for="inputUsername">User Name</label> <input type="text"
						name="username" id="inputEmail" class="form-control"
						placeholder="User Name" required="" autofocus=""><br>
					<label for="inputPassword">Password</label> <input type="password"
						name="password" id="inputPassword" class="form-control"
						placeholder="Password" required=""><br>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
						in</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>