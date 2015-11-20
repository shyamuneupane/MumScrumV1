<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<head>
<body>
<%@ include file="Header.jsp" %>
<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a href="userStory.estimate/${currentUserId }">Testing Estimation</a></li>
    <li ><a href="userStory.updateWrok/${currentUserId }"> Update Work Log </a></li>
   
  </ul>

			<h3>Welcome to Tester Dashboard.</h3>
	
	<!-- 	<legend>Choose your Task </legend>
			
			<a href='<spring:url value="userStory.estimate/${currentUserId }"/>'>Estimate
				Testing for User Story</a><br> <br> <a
				href='<spring:url value="userStory.updateWrok/${currentUserId }"/>'>Update
				Work LOg</a>
 -->	
	</div>


</body>
</html>