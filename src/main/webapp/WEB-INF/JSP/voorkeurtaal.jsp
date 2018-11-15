<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html lang="nl">
<head>
	<c:import url='/WEB-INF/JSP/head.jsp'>
		<c:param name='title' value='Voorkeurtaal'/>
	</c:import>
</head>
<body>
	<p>
		Je voorkeurtaal is ${voorkeurtaal ? "nederlands" : "niet nederlands"}.
	</p>
</body>
</html>