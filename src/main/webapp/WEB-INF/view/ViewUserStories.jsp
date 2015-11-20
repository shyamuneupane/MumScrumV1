<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ page import="com.mumscrumv1.model.Role" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of UserStories</title>
</head>
<body>

<%@ include file="Header.jsp" %>

<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a href="#">View All User Stories</a></li>
    <li><a href="view.sprint"> View All Sprint </a></li>
    <li><a href="view.release" >View All release</a> </li>
    <li><a href="view.SelectAttributeForBurnDown">View BurnDown Chart</a> </li>
  </ul>
  <h3> List of User Stories &nbsp; <a href="create.userStory"> Create User Stories</a></h3>
<table class="table">
  <thead>           
  
   <tr>
                            <th>Assign Dev/QA</th>
                            <th>Update</th>
                            <th>Delete</th>
                            <th>id</th>
                            <th>story Name</th>
                            <th>Story Description</th>
                            <th>Developer Estimate Hour</th>
                            <th>Tester Estimate Hour</th>
                            
                             <th>Priority</th>
                             <th>Status</th>

                        </tr>
                    </thead>
<c:forEach var="UserStory" items="${UserStoriesInfo}">
<tr>
<td><form action="addDelDevTester.UserStory" method="get">
<input type="hidden" name="UserStoryId" value="${UserStory.getId()}">
	<input type="submit" value="Assign Dev/QA"></form></a></a></td>

<td>
	<form action="update.userStory" method="get">
		<input type="hidden" name="id" value="${UserStory.getId()}">
		<input type="submit" value=" Update">
		</form>
</td>
<td><form action="delete.userStory" method="get"> <input type="hidden" name="id" value="${UserStory.getId()}">
	<input type="submit" value=" Delete"></form></a></a></td>
	
	<td>${UserStory.getId()}</td>
	<td>${UserStory.getStoryName()} </td>
	<td>${UserStory.getStoryDescription()} </td>
	<td>${UserStory.getDevEstimateHour()} </td>
	<td>${UserStory.getTesterEstimateHour()} </td>
	

	<td>${UserStory.getPriority()} </td>
	<td>${UserStory.getStatus()} </td>
	<td>${UserStory.getDateCreated()} </td>
	<td>${UserStory.getDateAssigned()} </td>
	<td>${UserStory.getDateCompleted()} </td>

	</tr>
</c:forEach>
</table>


</div>
</body>
</html>