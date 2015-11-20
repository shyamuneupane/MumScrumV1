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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Employee</title>
</head>
<body>

<%@ include file="Header.jsp" %>




<h3> List of Employees  &nbsp;  <a href="create.employee"> Create Employee</a></h3>

<table class="table">

<tr><th> Update Employee</th><th> Delete Employee</th><th>Name</th><th>Address</th><th>salary</th><th>SSN</th></tr>

<c:forEach var="EmployeeInfo" items="${AllEmployeeInfo}">


	
<tr><td><form action="update.employee" method="get"><input type="hidden" name="id" value="${EmployeeInfo.getEmployeeID()}"><input type="submit" value=" Update Employee"></form></a></a></td><td><form action="delete.employee" method="get"> <input type="hidden" name="id" value="${EmployeeInfo.getEmployeeID()}"><input type="submit" value=" Delete Employee"></form></a></a></td><td><th>${EmployeeInfo.getEmployeeID()}</th><td>${EmployeeInfo.firstName} &nbsp; ${EmployeeInfo.middleName} &nbsp; ${EmployeeInfo.lastName} </td><td>${EmployeeInfo.address} </td><td>${EmployeeInfo.salary} </td><td>${EmployeeInfo.SSN} </td></tr>

</c:forEach>
</table>


</body>
</html>