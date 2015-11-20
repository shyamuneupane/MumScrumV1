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
<fieldset>
<legend> <H4> </strong></H4></legend>
<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a href="view.userstory">View All User Stories</a></li>
    <li><a href="view.sprint"> View All Sprint </a></li>
    <li><a href="view.release" >View All release</a> </li>
    <li><a href="view.SelectAttributeForBurnDown">View BurnDown Chart</a> </li>
  </ul>
  
<table class="table">
<tr> <h2> Already Assigned Tester<h2></tr>
 <thead> 
 <tr>	<th>Address </th>
	<th>Birhdate</th>
	<th>Email </th>
	<th>FirstName </th>
	<th>MiddleName </th>

	<th>LastName </th>
	<th>MobilePhone </th>
	<th>OficeName </th>
	<th>Salary </th>
	<th>getSSN </th>

</tr>
</thead>
<tr>	<td>${TesterForUserStory.getAddress()} </td>
	<td>${TesterForUserStory.getBithday()} </td>
	<td>${TesterForUserStory.getEmail()} </td>
	<td>${TesterForUserStory.getFirstName()} </td>
	<td>${TesterForUserStory.getMiddleName()} </td>

	<td>${TesterForUserStory.getLastName()} </td>
	<td>${TesterForUserStory.getMobilePhone()} </td>
	<td>${TesterForUserStory.getOficeName()} </td>
	<td>${TesterForUserStory.getSalary()} </td>
	<td>${TesterForUserStory.getSSN()} </td>

	</tr>
</table>
<table class="table">	
	<tr> <h2> Already Assigned Developer<h2></tr>
 <thead> 
 <tr>	<th>Address </th>
	<th>Birhdate</th>
	<th>Email </th>
	<th>FirstName </th>
	<th>MiddleName </th>

	<th>LastName </th>
	<th>MobilePhone </th>
	<th>OficeName </th>
	<th>Salary </th>
	<th>getSSN </th>

</tr>
</thead>

<tr>	<td>${DevForUserStory.getAddress()} </td>
	<td>${DevForUserStory.getBithday()} </td>
	<td>${DevForUserStory.getEmail()} </td>
	<td>${DevForUserStory.getFirstName()} </td>
	<td>${DevForUserStory.getMiddleName()} </td>

	<td>${DevForUserStory.getLastName()} </td>
	<td>${DevForUserStory.getMobilePhone()} </td>
	<td>${DevForUserStory.getOficeName()} </td>
	<td>${DevForUserStory.getSalary()} </td>
	<td>${DevForUserStory.getSSN()} </td>

	</tr>
</tr>
</table>
<table class="table">
 
<tr> <h2> Availble Develper and Tester<h2></tr>
 <thead> 
 <tr>
 	<th>Assign as Developer </th>
	<th>Assign as Tester</th>	
 <th>Address </th>
	<th>Birhdate</th>
	<th>Email </th>
	<th>FirstName </th>
	<th>MiddleName </th>

	<th>LastName </th>
	<th>MobilePhone </th>
	<th>OficeName </th>
	<th>Salary </th>
	<th>getSSN </th>

</tr>
</thead>
<c:forEach var="employee" items="${EmployeeList}">

<tr>
<td>
<form action="AddDevNTesterConfirm.UserStory" method="get"> <input type="hidden" name="employeeId" value="${employee.getEmployeeID()}">
 <input type="hidden" name="UserStoryId" value="${UserStoryId}">
   <input type="hidden" name="assignedAs" value="Developer">
	<input type="submit" value=" Assign as Developer"></form></a></a>
</td>
<td>
<form action="AddDevNTesterConfirm.UserStory" method="get"> <input type="hidden" name="employeeId" value="${employee.getEmployeeID()}">
 <input type="hidden" name="UserStoryId" value="${UserStoryId}">
  <input type="hidden" name="assignedAs" value="Tester">
	<input type="submit" value=" Assign as Tester"></form></a></a>
</td>


	
	<td>${employee.getAddress()} </td>
	<td>${employee.getBithday()} </td>
	<td>${employee.getEmail()} </td>
	<td>${employee.getFirstName()} </td>
	<td>${employee.getMiddleName()} </td>

	<td>${employee.getLastName()} </td>
	<td>${employee.getMobilePhone()} </td>
	<td>${employee.getOficeName()} </td>
	<td>${employee.getSalary()} </td>
	<td>${employee.getSSN()} </td>

	</tr>
</c:forEach>

</table>
</div>

</fieldset>

</body>
</html>