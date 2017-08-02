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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayHerosPage">Hero</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayPowersPage">Power</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Location</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organization</a></li>

                </ul>    
            </div>

            <div class="col-sm-6" style="border-right:1px solid black;height:500px;">
                <h2 align="center">Organizations</h2>


                <table id="profileTable" align="center">

                    <c:forEach var="org" items="${organizations}">
                        <tr>
                            <td style="text-align:center">
                                <c:out value="${org.orgName}"/>
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
                <div class="col-sm-12" id="addOrg">
                    <h2 style="" align="center">Create Organization</h2><br/>

                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="addOrganization">
                        <div class="form-group">
                            <label for="name" class="col-sm-4 control-label">Name</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="name" placeholder="I.J.L.S.A."/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-sm-4 control-label">Description</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="description" placeholder="A group of SuperHero Sidekicks"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-sm-4 control-label">Address</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="address" placeholder="Bikini Bottom"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phoneNumber" class="col-sm-4 control-label">Phone Number</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="phoneNumber" placeholder="6549873214"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-8">
                                <input type="submit" class="btn btn-default btn-primary" value="Create Organization"/>
                            </div>
                        </div>

                    </form>
                </div>

                <div class="col-sm-12" id="editOrg">
                    <h2 align="center">Update Organization</h2><br/>
                    <div class="form-group form-horizontal">
                        <label for="orgSelect" class="col-sm-4 control-label">Organization</label>
                        <div class="col-sm-8" style="padding-left:10px;">
                            <select style="" id="orgSelect" class="form-control" name="organization">
                                <option>Select option</option>
                                <c:forEach var="organizations" items="${organizations}">
                                    <option value="${organizations.organizationID}">${organizations.orgName}</option>
                                </c:forEach>
                            </select><br/>
                        </div>
                    </div>
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="editOrganization">
                        <div class="form-group">
                            <label for="name" class="col-sm-4 control-label">Name</label>
                            <div class="col-sm-8">
                                <input id="edit-name" type="text" class="form-control" name="name" placeholder="I.J.L.S.A."/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-sm-4 control-label">Description</label>
                            <div class="col-sm-8">
                                <input id="edit-description" type="text" class="form-control" name="description" placeholder="A group of SuperHero Sidekicks"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-sm-4 control-label">Address</label>
                            <div class="col-sm-8">
                                <input id="edit-address" type="text" class="form-control" name="address" placeholder="Bikini Bottom"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phoneNumber" class="col-sm-4 control-label">Phone Number</label>
                            <div class="col-sm-8">
                                <input id="edit-phoneNumber" type="text" class="form-control" name="phoneNumber" placeholder="6549873214"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8">
                                <input type="hidden" class="form-control" name="id" id="orgID"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-8">
                                <input type="submit" class="btn btn-default btn-primary" value="Update Info"/>
                            </div>
                        </div>
                    </form>

                </div>



                <div class="col-sm-12" id="deleteOrg">
                    <h2 align="center">Remove Organization</h2>
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="deleteOrganization">

                        <div class="form-group form-horizontal">
                            <label for="orgSelect" class="col-sm-4 control-label">Organization</label>
                            <div class="col-sm-8" style="padding-left:10px;">
                                <select style="" id="orgSelect" class="form-control" name="organization">
                                    <option>Select option</option>
                                    <c:forEach var="organizations" items="${organizations}">
                                        <option value="${organizations.organizationID}">${organizations.orgName}</option>
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
<script src="${pageContext.request.contextPath}/js/organization.js"></script>
</html>
