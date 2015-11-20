<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
  <%@ include file="Header.jsp" %>
  
	<form action="updateConfirm.employee" method="post">

		<fieldset>
			<legend><h3>Update the following Employee for MumScrum System</h3></legend>
			<!--<c:url value="/showMessage.html" var="messageUrl" />-->
			<div>
			 <input type="hidden"
					name="id" value="${EmployeeInfo.getEmployeeID()}" required />
			</div>
			<div>
				<label for="firstName">First Name: </label> <input type="text"
					name="firstName" value="${EmployeeInfo.firstName}" required />
			</div>

			<div>
				<label for="middleName">Middle Name: </label> <input type="text"
					name="middleName" value="${EmployeeInfo.middleName}" />
			</div>

			<div>
				<label for="lastName">Last Name: </label> 
				<input type="text"
					name="lastName" value="${EmployeeInfo.lastName}" required />
			</div>

			<div>
				<label for="street">Street: </label> <input type="text"
					name="street" value="${EmployeeInfo.address.street}" required />
			</div>

			<div>
				<label for="city">City: </label> <input type="text" name="city"
					value="${EmployeeInfo.address.city}" required />
			</div>

			<div>
				<label for="state">State: </label> <input type="text" name="state"
					value="${EmployeeInfo.address.state}" required />
			</div>

			<div>
				<label for="zip">zip: </label> <input type="text" name="zip"
					value="${EmployeeInfo.address.zip}" required />
			</div>

			<div>
				<label for="ssn">SSN: </label> <input type="text" name="ssn"
					value="${EmployeeInfo.SSN}" required />
			</div>

			<div>
				<input type="submit" value="Update Employee" />
			</div>


		</fieldset>
		</form>
</body>
</html>