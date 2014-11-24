<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello page</title>
  </head>
  <body>
    <h1>Hello World from JSP!</h1>
    <hr/>
    <ul>
      <c:forEach var="person" items="${people}">
        <li>${person.email}: ${person.name}</li>
      </c:forEach>
    </ul>
  </body>
</html>
