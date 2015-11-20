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
    <li class="active"><a href="#">View All User Stories</a></li>
    <li><a href="view.sprint"> View All Sprint </a></li>
    <li><a href="view.release" >View All release</a> </li>
    <li><a href="view.SelectAttributeForBurnDown">View BurnDown Chart</a> </li>
  </ul>
   <form:form action="save.userStory" method="post" modelAttribute="userStory">
     <fieldset>
			<legend><h3>Create the User Strories for MumScrum System</h3></legend>
			<!--<c:url value="/showMessage.html" var="messageUrl" />-->
			<div>
				<form:label path="StoryName">Story Name : </form:label> 
				<form:input type="text" path="StoryName" />
			</div>

			<div>
				<form:label path="StoryDescription">Story Description: </form:label> 
				<form:input type="text"	path="StoryDescription" />
			</div>

			<div>
				<form:label path="DevEstimateHour">Developer Estimate Hour: </form:label> 
				<form:input type="text"	path="DevEstimateHour"  />
			</div>

			<div>
				<form:label path="TesterEstimateHour">Tester Estimate Hour: </form:label> 
				<form:input type="text"	path="TesterEstimateHour"  />
			</div>
			

			<div>
				<form:label path="DevRemainingHour">Dev Remaining Hour: </form:label> 
				<form:input type="text" path="DevRemainingHour"	 />
			</div>
			<div>
				<form:label path="TesterRemainingHour">Dev Remaining Hour: </form:label> 
				<form:input type="text" path="TesterRemainingHour"	 />
			</div>
<!-- 
			<div>
				<form:label path="AssignedDeveloper">Assigned Developer: </form:label> 
				<form:input type="text" path="AssignedDeveloper"	 />
			</div>

			<div>
				<form:label path="AssignedTester">Assigned Tester: </form:label> 
				<form:input type="text" path="AssignedTester"  />
			</div>
 -->
			<div>
				<form:label path="Priority">Priority: </form:label> 
				<form:input type="text" path="Priority"	/>
			</div>
			
			<div>
				<form:label path="Status">Status: </form:label> 
				<form:input type="text" path="Status"	/>
			</div>
			<!-- 
			<div>
				<form:label path="CreatedBy">Created By: </form:label> 
				<form:input type="text" path="CreatedBy"	/>
			</div>
			
			<div>
				<form:label path="DateCreated">Date Created: </form:label> 
				<form:input type="text" path="DateCreated"	/>
			</div>
			
			<div>
				<form:label path="DateAssigned">Date Assigned: </form:label> 
				<form:input type="text" path="DateAssigned"	/>
			</div>
			
			<div>
				<form:label path="DateCompleted">Date Assigned: </form:label> 
				<form:input type="text" path="DateCompleted"	/>
			</div>
			
		 -->	

			<div>
				<input type="submit" value="Create User Story" />
			</div>


		</fieldset>

  </form:form>

</body>
</html>


