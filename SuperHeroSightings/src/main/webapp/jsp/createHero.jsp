<%-- 
    Document   : createHero
    Created on : Jul 23, 2017, 6:55:48 PM
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
        <title>Add Hero</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
        <style>
            h2  {
                border-bottom:1px solid black;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <h1>Super Hero Sightings!</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayIndexPage">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sighting</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayHerosPage">Hero</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayPowersPage">Power</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Location</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organization</a></li>

                </ul>    
            </div>

            <div class="col-sm-6" style="border-right:1px solid black;height:500px;">
                <h2 align="center">Heros</h2>


                <table id="profileTable" align="center">

                    <c:forEach var="hero" items="${heros}">
                        <tr>
                            <td style="text-align:center">
                                <c:out value="${hero.heroName}"/>
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

                <div class="col-sm-12" id="addHero">
                    <h2 align="center">Create Hero</h2>
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="addHero">
                        <div class="form-group">
                            <label for="name" class="col-sm-4 control-label">Name</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="name" placeholder="The Elastic Waistband"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-sm-4 control-label">Description</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="description" placeholder="Has the ability to become very flexible."/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="isGood" class="col-sm-4 control-label">Are they Good?</label>
                            <div class="col-sm-8">
                                <input type="radio" class="" name="isGood" value="true"/>Yes
                                <input type="radio" class="" name="isGood" value="false"/>No
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="">
                                <label for="organization" class="col-sm-4 control-label">Organizations</label>
                                <select style="width:150px;" multiple name="organization">
                                    <c:forEach var="currentOrganization" items="${organizations}">
                                        <option value="${currentOrganization.organizationID}">${currentOrganization.orgName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="">
                                <label for="power" class="col-sm-4 control-label">Powers</label>
                                <select style="width:150px;" multiple name="power">
                                    <c:forEach var="currentPower" items="${powers}">
                                        <option value="${currentPower.powerID}">${currentPower.pDescription}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-8">
                                <input type="submit" class="btn btn-default btn-primary" value="Create Hero"/>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="col-sm-12" id="editHero">
                    <h2 align="center">Update Hero</h2>
                    <div class="form-group form-horizontal">
                        <label for="heroSelect" class="col-sm-4 control-label">Hero</label>
                        <div class="col-sm-8" style="padding-left:10px;">
                            <select style="" id="heroSelect" class="form-control" name="hero">
                                <option>Select option</option>
                                <c:forEach var="hero" items="${heros}">
                                    <option value="${hero.heroID}">${hero.heroName}</option>
                                </c:forEach>
                            </select><br/>
                        </div>
                    </div>


                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="editHero">
                        <div class="form-group">
                            <label for="name" class="col-sm-4 control-label">Name</label>
                            <div class="col-sm-8">
                                <input id="edit-name" type="text" class="form-control" name="name" placeholder="The Elastic Waistband"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-sm-4 control-label">Description</label>
                            <div class="col-sm-8">
                                <input id="edit-description" type="text" class="form-control" name="description" placeholder="Has the ability to become very flexible."/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="isGood" class="col-sm-4 control-label">Are they Good?</label>
                            <div class="col-sm-8">
                                <input id="edit-isGoodHero" type="radio" class="" name="isGood" value="true"/>Yes
                                <input id="edit-isGoodHero" type="radio" class="" name="isGood" value="false"/>No
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="">
                                <label for="organization" class="col-sm-4 control-label">Organizations</label>
                                <select style="width:150px;" multiple name="organization">
                                    <c:forEach var="currentOrganization" items="${organizations}">
                                        <option value="${currentOrganization.organizationID}">${currentOrganization.orgName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="">
                                <label for="power" class="col-sm-4 control-label">Powers</label>
                                <select style="width:150px;" multiple name="power">
                                    <c:forEach var="currentPower" items="${powers}">
                                        <option value="${currentPower.powerID}">${currentPower.pDescription}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8">
                                <input type="hidden" class="form-control" name="id" id="heroID"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-8">
                                <input type="submit" class="btn btn-default btn-primary" value="Update Hero"/>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="col-sm-12" id="deleteHero">
                    <h2 align="center">Remove Hero</h2>
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="deleteHero">

                        <div class="form-group form-horizontal">
                            <label for="heroSelect" class="col-sm-4 control-label">Hero</label>
                            <div class="col-sm-8" style="padding-left:10px;">
                                <select style="" id="heroSelect" class="form-control" name="hero">
                                    <option>Select option</option>
                                    <c:forEach var="hero" items="${heros}">
                                        <option value="${hero.heroID}">${hero.heroName}</option>
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



            </div> <!-- End col div -->

        </div>
    </body>

    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/hero.js"></script>
</html>
