<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <c:import url="/WEB-INF/JSP/head.jsp">
    <c:param name="title" value="Saus raden"/>
  </c:import>
</head>
<body>
  <h1>Saus raden</h1>
  <p>Te raden saus: ${spel.sausNaamMetPuntjes}</p>
  <c:url value="/sauzen/raden" var="url"/>
  <c:choose>
  <c:when test="${spel.gewonnen}">U hebt gewonnen, de saus was ${spel.sausNaam}</c:when>
  <c:when test="${spel.verloren}">U hebt verloren, de saus was ${spel.sausNaam}</c:when>
  <c:otherwise>
    <form:form action= "${url}" modelAttribute="sausRadenForm" method="post" id="radenForm">
      <form:label path="letter">Letter: </form:label>
      <form:input path="letter" size="1" maxLength="1" required="required" autofocus="autofocus" />
      <input type="submit" value="Raden" id="gokKnop">
    </form:form>
  
  </c:otherwise>
	  
  </c:choose>
  
  <c:url value="/sauzen/raden/nieuwspel" var="url"/>
  <form method="post" action="${url}">
    <input type="submit" value="Nieuw spel">
  </form>
  <img src="<c:url value="/images/${spel.verkeerdeBeurten}.png"/>" alt="${spel.verkeerdeBeurten} verkeerde beurten">
  
</body>
</html>