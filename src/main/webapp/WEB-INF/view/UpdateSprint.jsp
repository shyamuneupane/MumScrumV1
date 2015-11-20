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
<title>Insert title here</title>
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
   <form:form action="updateConfirm.sprint" method="post" modelAttribute="sprint">
     <fieldset>
			<legend><h3>Update Sprint </h3></legend>
			<form:hidden path="id"/>
			<div>
				<form:label path="SprintName">Sprint Name: </form:label> 
				<form:input type="text" path="SprintName" />
			</div>

			<div>
				<form:label path="SprintDescription">Sprint Description: </form:label> 
				<form:input type="text"	path="SprintDescription" />
			</div>

			<div>
				<form:label path="Status">Status: </form:label> 
				<input type="text"	path="Status"  />
			</div>

			<div>
				<form:label path="Priority">Priority: </form:label> 
				<form:input type="text"	path="Priority"  />
			</div>
			
<!-- 
			<div>
				<form:label path="NoOfWorkDayInSprint">Work_Day: </form:label> 
				<form:input type="text" path="NoOfWorkDayInSprint"	 />
			</div>

			<div>
				<form:label path="DateCreated">Date_Created: </form:label> 
				<form:input type="text" path="DateCreated"	 />
			</div>

			<div>
				<form:label path="DateCompleted">Date_Completed: </form:label> 
				<form:input type="text" path="DateCompleted"  />
			</div>

		 -->	
			<div>
				<input type="submit" value="Update Sprint" />
			</div>
	

		</fieldset>

  </form:form>
</div>
</body>
</html>


