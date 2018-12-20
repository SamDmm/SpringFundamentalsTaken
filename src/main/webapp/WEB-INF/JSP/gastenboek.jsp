<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
  <vdab:head title="Gastenboek"></vdab:head>
</head>
<body>
  <vdab:menu/>
  <h1>Gastenboek</h1>
  <c:choose>
    <c:when test="${empty gastenboekEntry}">
      <c:url value="/gastenboek/toevoegen" var="url"/>
      <a href="${url}">Toevoegen</a>
    </c:when>
    <c:otherwise>
      <c:url value="/gastenboek" var="url"/>
      <form:form action="${url}" modelAttribute="gastenboekEntry" method="post">
        <form:label path="naam">Naam: <form:errors path="naam"/></form:label>
        <form:input path="naam" autofocus="autofocus" required="required"/>
        <form:label path="bericht">Bericht: <form:errors path="naam"/></form:label>
        <form:textarea path="bericht" required="required" rows="5" cols="80"/>
        <input type="submit" value="Toevoegen">
      </form:form>
    </c:otherwise>
  </c:choose>
  <c:if test="${not empty gastenboekList}">
    <c:url value="/gastenboek/verwijderen" var="url"/>
    <form:form action="${url}" method="post">
    <dl>
    <c:forEach var="gastenboekEntry" items="${gastenboekList}">
      <dt><spring:eval expression="gastenboekEntry.datum"/> ${gastenboekEntry.naam}<input type="checkbox" name="verwijderid" value="${gastenboekEntry.id}"/></dt>
      <dd>${gastenboekEntry.bericht}</dd>
    </c:forEach>
    </dl>
    <input type="submit" value="verwijderen">
        </form:form>
  </c:if>
</body>
</html>