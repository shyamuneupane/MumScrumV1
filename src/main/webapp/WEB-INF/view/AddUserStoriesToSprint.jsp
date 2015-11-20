<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ page import="com.mumscrumv1.model.Role" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

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
    <li><a href="view.userstory">View All User Stories</a></li>
    <li class="active"><a href="view.sprint"> View All Sprint </a></li>
    <li><a href="view.release" >View All release</a> </li>
    <li><a href="view.SelectAttributeForBurnDown">View BurnDown Chart</a> </li>
  </ul>
 <H3> Already Added userStories in sprint</H3>
<c:forEach var="UserStoriesSprint" items="${UserStoriesInSprint}">
<table class="table">
 <thead> 
 <tr><th>Remove</th>
 <th>ID </th>
	<th>Story Name</th>
	<th>Story Description </th>
	<th>Dev Est Hour</th>
	<th>Test Est Hour </th>

	<th>Dev Rem Hour</th>
	<th>Test Rem Hour </th>
	<th>Priority </th>
	<th>Status </th>
</tr>
</thead>
<tr>
<td><form action="RemoveStoryConfirm.sprint" method="get"> <input type="hidden" name="userStroryId" value="${UserStoriesSprint.getId()}">
 <input type="hidden" name="sprintId" value="${sprintId}">
	<input type="submit" value=" remove User Story from sprint"></form></a></a>
</td>
<td>
	<td>${UserStoriesSprint.getStoryName()} </td>
	<td>${UserStoriesSprint.getStoryDescription()} </td>
	<td>${UserStoriesSprint.getDevEstimateHour()} </td>
	<td>${UserStoriesSprint.getTesterEstimateHour()} </td>
	<td>${UserStoriesSprint.getDevRemainingHour()} </td>

	<td>${UserStoriesSprint.getPriority()} </td>
	<td>${UserStoriesSprint.getStatus()} </td>
	<td>${UserStoriesSprint.getDateCreated()} </td>
	<td>${UserStoriesSprint.getDateAssigned()} </td>
	<td>${UserStoriesSprint.getDateCompleted()} </td>

	</tr>
	</c:forEach>
	<tr>
	</table>
	
<table class="table">

	<H3> All other User Stories that is not assigned sprint</H3>
 <thead> 
 <tr>	<th>Add</th>
 <th>ID </th>
	<th>Story Name</th>
	<th>Story Description </th>
	<th>Dev Est Hour</th>
	<th>Test Est Hour </th>

	<th>Dev Rem Hour</th>
	<th>Test Rem Hour </th>
	<th>Priority </th>
	<th>Status </th>
</tr>
</thead>
<c:forEach var="UserStory" items="${UserStoriesInfo}">
<tr>
<td><td>
</>
<form action="addUserStoryConfirm.sprint" method="get"> <input type="hidden" name="userStroryId" value="${UserStory.getId()}">
 <input type="hidden" name="sprintId" value="${sprintId}">
	<input type="submit" value=" Assign user Story"></form></a></a>
</td>
<td>
	
	<td>${UserStory.getId()}</td>
	<td>${UserStory.getStoryName()} </td>
	<td>${UserStory.getStoryDescription()} </td>
	<td>${UserStory.getDevEstimateHour()} </td>
	<td>${UserStory.getTesterEstimateHour()} </td>
	<td>${UserStory.getDevRemainingHour()} </td>

	<td>${UserStory.getPriority()} </td>
	<td>${UserStory.getStatus()} </td>
	<!-- <td>${UserStory.getDateCreated()} </td>
	<td>${UserStory.getDateAssigned()} </td>
	<td>${UserStory.getDateCompleted()} </td> -->

	</tr>
</c:forEach>

</table>



</body>
</html>