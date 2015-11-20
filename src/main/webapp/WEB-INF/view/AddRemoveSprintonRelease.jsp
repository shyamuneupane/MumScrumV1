<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ page import="com.mumscrumv1.model.Role" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of UserStories</title>
</head>
<body>  
<%@ include file="Header.jsp" %>
<div class="container">
  <ul class="nav nav-tabs">
    <li><a href="view.userstory">View All User Stories</a></li>
    <li><a href="view.sprint"> View All Sprint </a></li>
    <li class="active"><a href="view.release" >View All release</a> </li>
    <li><a href="view.SelectAttributeForBurnDown">View BurnDown Chart</a> </li>
  </ul>
  <h3>Already Added Sprint in this relase</h3>
<table class="table">

<c:forEach var="AddedSprints" items="${SprintListInRelease}">
 <thead class="table"> 
 <tr>	<th>Remove</th>
 <th>ID </th>
	<th>Sprint Name</th>
	<th>Sprint Description </th>
	<th>Status</th>
	<th>Priority</th>
	<th>No of Working Day</th>
</tr>
</thead>

<tr>
<td><form action="RemoveSprintConfirm.release" method="get"> <input type="hidden" name="sprintId" value="${AddedSprints.getId()}">
 <input type="hidden" name="releaseId" value="${ReleaseId}">
	<input type="submit" value=" remove Sprint from Release"></form></a></a>
</td><td>${AddedSprints.getId()}</td>
	<td>${AddedSprints.getSprintName()} </td>
	<td>${AddedSprints.getSprintDescription()} </td>
	<td>${AddedSprints.getStatus()} </td>
	<td>${AddedSprints.getPriority()} </td>
	<td>${AddedSprints.getNoOfWorkDayInSprint()} </td>
<!--	<td>${AddedSprints.getDateCreated()} </td>
	<td>${AddedSprints.getDateCompleted()} </td>-->
</tr>
</c:forEach>
</table>

<h3>All other Sprint in this relase</h3>

<table class="table">
<c:forEach var="Sprint" items="${SprintListNotInRelease}">
 <thead> 
 <tr>	<th>Add</th>
 <th>ID </th>
	<th>Sprint Name</th>
	<th>Sprint Description </th>
	<th>Status</th>
	<th>Priority</th>
	<th>No of Working Day</th>
</tr>
</thead>


<tr>
<td><form action="AddSprintConfirm.release" method="get"> <input type="hidden" name="sprintId" value="${Sprint.getId()}">
 <input type="hidden" name="releaseId" value="${ReleaseId}">
	<input type="submit" value="Add Sprint from Release"></form>
</td>

	<td>${Sprint.getId()}</td>
	<td>${Sprint.getSprintName()} </td>
	<td>${Sprint.getSprintDescription()} </td>
	<td>${Sprint.getStatus()} </td>
	<td>${Sprint.getPriority()} </td>
	<td>${Sprint.getNoOfWorkDayInSprint()} </td>
	<td>${Sprint.getDateCreated()} </td>
	<td>${Sprint.getDateCompleted()} </td>
	
</tr>
</c:forEach>
</table>





</fieldset>

</body>
</html>