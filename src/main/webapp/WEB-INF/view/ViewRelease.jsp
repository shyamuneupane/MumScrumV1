
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Release Page</title>
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
 <h3> List of Releases <strong> &nbsp;<a href="create.release"> Create Release</a></strong></H3>

  
                <table class="table">
                    <thead>
                        <tr>
                        
                            <th>Update</th>
                            <th>Delete</th>
                            <th>Add remove</th>
                            <th>id</th>
                            <th>Release Name</th>
                            <th>Status</th>
                            <th>Estimated Release Date</th>
                            <th>Actual Release Date</th>
                           

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="release" items="${releases}" varStatus="loopStatus" >
                            <tr>
                            	
                                <td><form action="update.release" method="get">
                                        <input type="hidden" name="id" value="${release.getId()}">
                                        <input type="submit" value=" Update Release"></form></td>
                                <td>
                                    <form action="delete.release" method="get"> 
                                        <input type="hidden" name="id" value="${release.getId()}">
                                        <input type="submit" value=" Delete Release">
                                        
                                    </form></td>
                                      <td><form action="AddRemoveSprinton.Release" method="get">
								<input type="hidden" name="ReleaseID" value="${release.getId()}">
								<input type="submit" value="Add/Remove Sprints"></form></td>
                                <td>${release.id}</td>
                                <td width="20%">${release.releaseName}</td>
                                <td> ${release.status}     </td>
                                <td> ${release.estimatedReleseDate}     </td>
                                <td> ${release.actualReleaseDate}     </td>
                              
							
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
     
    </body>

</html>
