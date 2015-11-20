<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<spring:url value="/resources/css/bootstrap.min.css" var="mainCss" />
<spring:url value="/resources/css/bootstrap.css" var="mainCss" />
<spring:url value="/resources/js/bootstrap.min.js" var="jqueryJs" />
<link href="${mainCss}" rel="stylesheet" />
<script src="${mainJs}"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Employee</title>
</head>
<body>
<%@ include file="Header.jsp" %>

<h3>Create the Employee for MumScrum System</h3>


	<form:form  class="form-horizontal" role="form" action="save.employee" method="post"
		modelAttribute="employee">
		</br>
		
			<!--<c:url value="/showMessage.html" var="messageUrl" />-->
			<div>
				<form:label path="firstName">First Name: </form:label>
				<form:input type="text" path="firstName" />
			</div>

			<div class="form-group">
				<form:label path="middleName">Middle Name: </form:label>
				<form:input type="text" path="middleName" />
			</div>

			<div class="form-group">
				<form:label path="lastName">Last Name: </form:label>
				<input type="text" path="lastName" />
			</div>
   <div class="form-group">
                                <label class="col-sm-2 control-label" for="UserName">Username</label>
                                <div class="col-xs-4">
                                    <form:input type="text" id ="username" path="userCredential.username" class="form-control"/>
                                </div>
                            </div>
                                
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="password">Password</label>
                                <div class="col-xs-4">
                                    <form:input type="text" id ="password" path="userCredential.password" class="form-control"/>
                                </div>
                            </div>
			<div>
				<form:label path="address.street">Street: </form:label>
				<form:input type="text" path="address.street" />
			</div>


			<div>
				<form:label path="address.city">City: </form:label>
				<form:input type="text" path="address.city" />
			</div>

			<div>
				<form:label path="address.state">State: </form:label>
				<form:input type="text" path="address.state" />
			</div>

			<div>
				<form:label path="address.zip">zip: </form:label>
				<form:input type="text" path="address.zip" />
			</div>

			<div>
				<form:label path="SSN">SSN: </form:label>
				<form:input type="text" path="SSN" />
			</div>
<div class="form-group">
				<label class="col-sm-2 control-label">Assign roles</label>
				<div class="col-xs-2">
					<label class="checkbox-inline"><input type="checkbox"
						value="Developer" name=userRole> Developer</label>
				</div>
				<div class="col-xs-2">
					<label class="checkbox-inline"><input type="checkbox"
						value="Tester" name="userRole">Tester</label>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"></label>
				<div class="col-xs-2">
					<label class="checkbox-inline"><input type="checkbox"
						value="ScrumMaster" name="userRole">Scrum master</label>
				</div>
				<div class="col-xs-2">
					<label class="checkbox-inline"><input type="checkbox"
						value="ProductOwner" name="userRole"> Product owner</label>
				</div>
			</div>
			<div>
				<input class="btn btn-info" type="submit" value="Create Employee" />
			</div>
			

		</fieldset>
	</form:form>

</body>
</html>


