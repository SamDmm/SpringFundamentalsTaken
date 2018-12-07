<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <c:import url="/WEB-INF/JSP/head.jsp">
    <c:param name="title" value="snacks (begin naam)"/>
  </c:import>
</head>
<body>
  <h1>Snacks (begin naam)</h1>
  <c:url value="/snacks" var="url"/>
  <form:form action="${url}" modelAttribute="beginNaamForm" method="get">
    <form:label path="beginnaam">Begin naam: <form:errors path="beginnaam"/></form:label>
    <form:input path="beginnaam" autofocus="autofocus"/>
    <input type="submit" value="zoeken">
    <form:errors/>
  </form:form>
  <c:if test="${not empty snacks}">
    <ul>
    <c:forEach var="snack" items="${snacks}">
      <li>${snack.naam}</li>
    </c:forEach>
    </ul>
  </c:if>
</body>
</html>