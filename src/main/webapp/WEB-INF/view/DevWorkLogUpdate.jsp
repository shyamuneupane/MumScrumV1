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
    <li ><a href="userStory.devEstimate/${currentUserId }">Developer Estimation</a></li>
    <li class="active" ><a href="userStory.updateDevWrok/${currentUserId}"> Update Work Log </a></li>
   
  </ul>
	<form:form modelAttribute="workLog" action="../workDevUpdate" method="post">

		<fieldset> <legend> Choose the User Story and
			Update your Work Log </legend> 

<label>Choose User Story </label>
			<<form:select path="userStory.id">
				<form:option value="0" label="--Select User Story Type" />
				<form:options items="${UserStoriesInfo}" itemLabel="StoryName"
					itemValue="id" />
			</form:select>
		<br>
			<br>
			<label>Your Estimation hours: </label>
		<input type="number" name="DevEffort"
			placeholder="your Estimation testing time in hours">
			<br>
			<br>
			<label>Day of work</label>
			<input type="number" min="1" step="1" name="WorkDay" placeholder="Day of work">
			<br>
			<br>
		<input type="submit" value="Submit">
		 </fieldset>

	</form:form>


</body>
</html>