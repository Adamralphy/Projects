<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Power</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <style>
            h2  {
                border-bottom:1px solid black;
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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sighting</a></li>
                    <li role="presentation""><a href="${pageContext.request.contextPath}/displayHerosPage">Hero</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayPowersPage">Power</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Location</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organization</a></li>

                </ul>    
            </div>

            <div class="col-sm-6" style="border-right:1px solid black;height:500px;">
                <h2 align="center">Powers</h2>


                <table id="profileTable" align="center">

                    <c:forEach var="power" items="${powers}">
                        <tr>
                            <td style="text-align:center">
                                <c:out value="${power.pDescription}"/>
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
                <div class="col-sm-12" id="addPower">
                    <h2 style="" align="center">Create Power</h2><br/>

                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="addPower">
                        <div class="form-group">
                            <label for="description" class="col-sm-4 control-label">Description</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="description" placeholder="Super Strength"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-8">
                                <input type="submit" class="btn btn-default btn-primary" value="Create Power"/>
                            </div>
                        </div>

                    </form>
                </div>

                <div class="col-sm-12" id="editPower">
                    <h2 align="center">Update Power</h2><br/>
                    <div class="form-group form-horizontal">
                        <label for="powerSelect" class="col-sm-4 control-label">Power</label>
                        <div class="col-sm-8" style="padding-left:10px;">
                            <select style="" id="powerSelect" class="form-control" name="power">
                                <option>Select option</option>
                                <c:forEach var="power" items="${powers}">
                                    <option value="${power.powerID}">${power.pDescription}</option>
                                </c:forEach>
                            </select><br/>
                        </div>
                    </div>
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="editPower">
                        <div class="form-group">
                            <label for="description" class="col-sm-4 control-label">Description</label>
                            <div class="col-sm-8">
                                <input id="edit-description" type="text" class="form-control" name="description" placeholder="Super Strength"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8">
                                <input type="hidden" class="form-control" name="id" id="powerID"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-8">
                                <input type="submit" class="btn btn-default btn-primary" value="Update Info"/>
                            </div>
                        </div>
                    </form>

                </div>



                <div class="col-sm-12" id="deletePower">
                    <h2 align="center">Remove Power</h2>
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="deletePower">

                        <div class="form-group form-horizontal">
                            <label for="powerSelect" class="col-sm-4 control-label">Power</label>
                            <div class="col-sm-8" style="padding-left:10px;">
                                <select style="" id="powerSelect" class="form-control" name="power">
                                    <option>Select option</option>
                                    <c:forEach var="power" items="${powers}">
                                        <option value="${power.powerID}">${power.pDescription}</option>
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
<script src="${pageContext.request.contextPath}/js/power.js"></script>
</html>

