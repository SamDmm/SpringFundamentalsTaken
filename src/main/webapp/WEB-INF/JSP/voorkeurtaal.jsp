<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<!DOCTYPE html>
<html lang="nl">
<head>
  <vdab:head title="Voorkeur taal"/>
</head>
<body>
	<vdab:menu/>
	<p>
		Je voorkeurtaal is ${voorkeurtaal ? "nederlands" : "niet nederlands"}.
	</p>
</body>
</html>