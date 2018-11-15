<%@ page contentType="text/html" pageEncoding="UTF-8" session='false'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html lang='nl'>
<head>
	<c:import url='/WEB-INF/JSP/head.jsp'>
		<c:param name='title' value='Frituur frida'/>
	</c:import>
</head>
<body>
	<h1>Frituur Frida</h1>
	<c:if test='${reedsBezocht}'>
		<h2>Welkom terug</h2>
	</c:if>
	<h2>Vandaag zijn we ${openGesloten}</h2>
	<img src="images/${openGesloten}.png" alt="${openGesloten}">
	<h2>Adres</h2>
	${adres.straat} ${adres.huisNr} <br>
	${adres.gemeente.postCode} ${adres.gemeente.naam}
</body>
</html>