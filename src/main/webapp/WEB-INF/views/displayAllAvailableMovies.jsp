<%--
  Created by IntelliJ IDEA.
  User: BO034731
  Date: 23/01/2015
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

    <head>
        <title>Display All Movies</title>
    </head>
    <body>
        <h4>Display All Movies</h4>

        <c:forEach var="movieRental" varStatus="f" items="${allMoviesList}">
            <c:out value="${movieRental.id}"/><br/>
            <c:out value="${movieRental.title}"/><br/>
            <c:out value="${movieRental.category}"/><br/>
            <c:out value="${movieRental.checkOut}"/><br/>
            <c:out value="${movieRental.returnDate}"/><br/>
        </c:forEach>

    </body>

</html>
