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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Attribute</title>
</head>
<body>
<%@ include file="Header.jsp" %>
<div class="container">
  <ul class="nav nav-tabs">
    <li><a href="view.userstory">View All User Stories</a></li>
    <li><a href="view.sprint"> View All Sprint </a></li>
    <li><a href="view.release" >View All release</a> </li>
    <li class="active"><a href="view.SelectAttributeForBurnDown">View BurnDown Chart</a> </li>
  </ul>
                <legend><h3>Select the following attribute for viewing the BurnDown chart</h3></legend>
<form:form action="view.BurnDownChart" method="post" modelAttribute="sprint" >

 <form:select path="SprintName">
 	<form:options items="${sprintList}"></form:options>
 </form:select></br>
 <form:button>get Sprint BurnDown</form:button>
 </form:form>

</div>
<body>

</body>
</html>