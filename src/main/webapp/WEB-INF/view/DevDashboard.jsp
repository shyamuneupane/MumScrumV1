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
    <li class="active"><a href="userStory.devEstimate/${currentUserId }">Developer Estimation</a></li>
    <li ><a href="userStory.updateDevWrok/${currentUserId}"> Update Work Log </a></li>
   
  </ul>
	<h3>Welcome to Developer Dashboard.</h3>
		

<!-- 
		<fieldset>
			<legend>Choose your Task </legend>
			<a  
				href='<spring:url value="userStory.devEstimate/${currentUserId }"/>'>Estimate
				Developing for User Story</a><br> <br> <a
				href='<spring:url value="userStory.updateDevWrok/${currentUserId}"/>'>Update
				Work LOg</a><br>
		</fieldset>
 -->

	</div>

</body>
</html>