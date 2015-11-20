<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<spring:url value="/resources/css/bootstrap.min.css" var="mainCss" />
<spring:url value="/resources/css/bootstrap.css" var="mainCss" />
<spring:url value="/resources/js/bootstrap.min.js" var="jqueryJs" />
<link href="${mainCss}" rel="stylesheet" />
<script src="${mainJs}"></script>
<meta charset="utf-8">
<title>MUMScrum Welcome</title>
</head>
<body>

		
<h2 class="text-center"> Welcome to Dashboard page. You have following roles</h2>


<div class="modal-body">
<h3> Employee Information</h3>
Name: ${EmployeeInfo.firstName} &nbsp; ${EmployeeInfo.lastName}</br>
SSN: ${EmployeeInfo.SSN} </br>
Address: ${EmployeeInfo.getAddress()}
<div class="modal-content">
	<div class="modal-body">
<h3> Roles Information</h3>

<c:forEach var="role" items="${roleInfo}">
Name: ${role.role } <br/>
Responsibilities:${role.roleDescription }<br/>

	<form action="Role.dashboard" method="get">
		<input type="hidden" name="CurrentRole" value="${role.role}">
		<input type="submit" value="Go to ${role.role }page"">
		</form>
</br>

.................................</br>

</c:forEach>
</div>
</div>
</div>
</body>
</html>