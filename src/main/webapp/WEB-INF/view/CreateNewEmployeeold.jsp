<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<!DOCTYPE html> 
<!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp" %>
   <form:form action="save.employee" method="post" modelAttribute="employee">
     <fieldset>
			<legend><h3>Create the Employee for MumScrum System</h3></legend>
			<!--<c:url value="/showMessage.html" var="messageUrl" />-->
			<div>
				<form:label path="firstName">First Name: </form:label> 
				<form:input type="text" path="firstName" />
			</div>

			<div>
				<form:label path="middleName">Middle Name: </form:label> 
				<form:input type="text"	path="middleName" />
			</div>

			<div>
				<form:label path="lastName">Last Name: </form:label> 
				<input type="text"	path="lastName"  />
			</div>

			<div>
				<form:label path="address.street">Street: </form:label> 
				<form:input type="text"	path="address.street"  />
			</div>
			

			<div>
				<form:label path="address.city">City: </form:label> 
				<form:input type="text" path="address.city"	 />
			</div>

			<div>
				<form:label path="address.state">State: </form:label> 
				<form:input type="text" path="address.state"	 />
			</div>

			<div>
				<form:label path="address.zip">zip: </form:label> 
				<form:input type="text" path="address.zip"  />
			</div>

			<div>
				<form:label path="SSN">SSN: </form:label> 
				<form:input type="text" path="SSN"	/>
			</div>

			<div>
				<input type="submit" value="Create Employee" />
			</div>


		</fieldset>

  </form:form>

</body>
</html>


