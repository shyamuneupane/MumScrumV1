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
  <div class="container">
  <ul class="nav nav-tabs">
    <li><a href="view.userstory">View All User Stories</a></li>
    <li><a href="view.sprint"> View All Sprint </a></li>
    <li class="active"><a href="view.release" >View All release</a> </li>
    <li><a href="view.SelectAttributeForBurnDown">View BurnDown Chart</a> </li>
  </ul>
        <form action="updateConfirm.release" method="post">

            <fieldset>
                <legend><h3>Update the following Release for MumScrum System</h3></legend>
                <!--<c:url value="/showMessage.html" var="messageUrl" />-->
                <div>
                    <input type="hidden"
                           name="id" value="${release.getId()}" required />
                </div>
                <div>
                    <label for="ReleaseName">Release Name: </label> 
                    <input type="text"
                           name="ReleaseName" value="${release.releaseName}" required />
                </div>
                <div>
                    <label for="Status">Status: </label> 
                    <input type="text"
                           name="Status" value="${release.status}" required />
                </div>
                <div>
                    <label for="EstimatedReleseDate">Estimated Release Date: </label> 
                    <input type="text"
                           name="EstimatedReleseDate" value="${release.estimatedReleseDate}" required />
                </div>
                <div>
                    <label for="ActualReleaseDate">Actual Release Date: </label> 
                    <input type="text"
                           name="ActualReleaseDate" value="${release.actualReleaseDate}" required />
                </div>
                <div>
                    <input type="submit" value="Update Release" />
                </div>
        </form>
        <div>
    </body>
</html>