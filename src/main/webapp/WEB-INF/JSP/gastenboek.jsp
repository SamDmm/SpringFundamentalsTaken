<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <vdab:head title="Gastenboek"></vdab:head>
</head>
<body>
  <vdab:menu/>
  <h1>Gastenboek</h1>
  <c:if test="">
    <c:url value="/gastenboek/toevoegen" var="url"/>
    <form:form action="${url}" modelAttribute="gastenboekEntry" method="post">
      <form:label path="naam">Naam: </form:label>
      <form:input path="naam"/>
      <form:label path="bericht">Bericht: </form:label>
      <form:input path="bericht"/>
    </form:form>
  </c:if>
  <c:forEach var="gastenboekEntry" items="${gastenboekList}">
    <p>${gastenboekEntry.datum} ${gastenboekEntry.naam}</p>
    <p>${gastenboekEntry.bericht}</p>
  </c:forEach>
</body>
</html>