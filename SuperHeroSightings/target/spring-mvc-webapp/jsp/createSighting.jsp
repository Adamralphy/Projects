<%-- 
    Document   : createOrganization
    Created on : Jul 24, 2017, 9:36:13 AM
    Author     : apprentice
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Organization</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <style>
            h2  {
                border-bottom:1px solid black;
            }
            th  {
                text-align:center;
            }
            td  {
                text-align:center;
            }

        </style>
    </head>
    <body>
        <div class="container">

            <h1>SuperHero Sightings!</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayIndexPage">Home</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sighting</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayHerosPage">Hero</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayPowersPage">Power</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Location</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organization</a></li>

                </ul>    
            </div>

            <div class="col-sm-6" style="border-right:1px solid black;height:500px;">
                <h2 align="center">Sightings</h2>


                <table id="contactTable" class="table table-hover">
                    <tr>
                        <th width="30%">Hero</th>
                        <th width="40%">Location</th>
                        <th width="30%">Date</th>

                    </tr>
                    <c:forEach var="sighting" items="${sightings}">
                        <tr>
                            <td>
                                <c:out value="${sighting.hero.heroName}"/>
                            </td>
                            <td>
                                <c:out value="${sighting.location.locationName}"/>
                            </td>
                            <td>
                                <c:out value="${sighting.sightDate}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </table>     


            </div>

            <div class="col-sm-6">

                <div class="navbar" style="margin-bottom:0px;">
                    <ul  id="contentNav" class="nav nav-tabs" style="display:table;margin:auto;">
                        <li id="one" role="presentation" class="active"><a href="#" onClick="return false;">Create New</a></li>
                        <li id="two" role="presentation"><a href="#" onClick="return false;">Update Info</a></li>
                        <li id="three" role="presentation"><a href="#" onClick="return false;">Remove</a></li>

                    </ul>    
                </div>
                <div class="col-sm-12" id="addSighting">
                    <h2 style="" align="center">Create Sighting</h2><br/>
                    <div class="form-group">
                        <form class="form-horizontal" 
                              role="form" method="POST" 
                              action="addSighting">
                            <label for="heroSelect" class="col-sm-4 control-label">Hero</label>
                            <div class="col-sm-8" style="padding-left:10px;">
                                <select style="" id="heroSelect" class="form-control" name="hero">
                                    <option>Select option</option>
                                    <c:forEach var="hero" items="${heros}">
                                        <option value="${hero.heroID}">${hero.heroName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <label for="locationSelect" class="col-sm-4 control-label">Location</label>
                            <div class="col-sm-8" style="padding-left:10px;">
                                <select style="" id="locationSelect" class="form-control" name="location">
                                    <option>Select option</option>
                                    <c:forEach var="location" items="${locations}">
                                        <option value="${location.locationID}">${location.locationName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-4 col-sm-8">
                                    <input type="submit" class="btn btn-default btn-primary" value="Create Sighting"/>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>

                <div class="col-sm-12" id="editSighting">
                    <h2 align="center">Update Sighting</h2><br/>
                    <div class="form-group form-horizontal">
                        <label for="sightingSelect" class="col-sm-4 control-label">Sighting</label>
                        <div class="col-sm-8" style="padding-left:10px;">
                            <select style="" id="sightingSelect" class="form-control" name="sighting">
                                <option>Select option</option>
                                <c:forEach var="sighting" items="${sightings}">
                                    <option value="${sighting.sightingID}">${sighting.hero.heroName} ${sighting.location.locationName}</option>
                                </c:forEach>
                            </select><br/><br/>
                        </div>
                    </div>
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="editSighting">
                        <div class="form-group">
                            <div class="">
                                <label for="location" class="col-sm-4 control-label">Location</label>
                                <select style="width:150px;" name="location">
                                    <c:forEach var="location" items="${locations}">
                                        <option value="${location.locationID}">${location.locationName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="">
                                <label for="hero" class="col-sm-4 control-label">Hero</label>
                                <select style="width:150px;" name="hero">
                                    <c:forEach var="hero" items="${heros}">
                                        <option value="${hero.heroID}">${hero.heroName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8">
                                <input type="hidden" class="form-control" name="id" id="sightingID"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-8">
                                <input type="submit" class="btn btn-default btn-primary" value="Update Info"/>
                            </div>
                        </div>
                    </form>

                </div>



                <div class="col-sm-12" id="deleteSighting">
                    <h2 align="center">Remove Sighting</h2>
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="deleteSighting">

                        <div class="form-group form-horizontal">
                            <label for="sightingSelect" class="col-sm-4 control-label">Sighting</label>
                            <div class="col-sm-8" style="padding-left:10px;">
                                <select style="" id="sightingSelect" class="form-control" name="sighting">
                                    <option>Select option</option>
                                    <c:forEach var="sighting" items="${sightings}">
                                        <option value="${sighting.sightingID}">${sighting.hero.heroName} ${sighting.location.locationName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class=" col-sm-8">
                                <input type="submit" class="btn btn-default btn-primary" value="Delete"/>
                            </div>
                        </div>
                    </form>
                </div>


            </div>

        </div>





    </body>

    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sighting.js"></script>
</html>
