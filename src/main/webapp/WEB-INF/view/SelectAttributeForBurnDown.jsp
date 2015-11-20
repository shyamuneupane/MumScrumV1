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
    <li><a href="view.userstory">View All User Stories</a></li>
    <li ><a href="view.sprint"> View All Sprint </a></li>
    <li><a href="view.release" >View All release</a> </li>
    <li class="active"><a href="view.SelectAttributeForBurnDown">View BurnDown Chart</a> </li>
  </ul>

 <H3> List of Sprints<strong> &nbsp;<a href="create.sprint"> Create Sprints</a></strong></H3>


<table class="table">
<c:forEach var="Sprint" items="${SprintInfo}">
<tr>
<td><form action="view.BurnDownChart" method="post">
<input type="hidden" name="sprintId" value="${Sprint.getId()}">
	<input type="submit" value=" View BurnDown Effort"></form></a></a></td>
<td>

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