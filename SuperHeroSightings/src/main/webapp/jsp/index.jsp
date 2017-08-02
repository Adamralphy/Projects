<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SuperHero Sightings</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>SuperHero Sightings</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayIndexPage">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sighting</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayHerosPage">Hero</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayPowersPage">Power</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Location</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organization</a></li>

                </ul>    
            </div>
            <div class="col-sm-6">
                <h2>Welcome!</h2>

            </div>
            <div class="col-sm-6" style="height:40em;border-left:1px solid black;">
                <h2>Latest Sightings</h2>

                <table id="contactTable" class="table table-hover">
                    <tr>
                        <th width="30%">Hero</th>
                        <th width="40%">Location</th>
                        <th width="30%">Date</th>

                    </tr>
                    <c:forEach var="sighting" items="${lastTen}">
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



                <hr/>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

