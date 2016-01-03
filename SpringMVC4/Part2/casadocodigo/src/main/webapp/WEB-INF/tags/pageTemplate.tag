<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<%@ attribute name="title" required="true" %>
<%@ attribute name="extraScripts" fragment="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>${title }</title>
	
	<c:url value="/resources/css" var="cssPath"/>
	<link rel="stylesheet" href="${cssPath }/bootstrap.min.css">
	<link rel="stylesheet" href="${cssPath }/bootstrap-theme.min.css">
	
	<style type="text/css">
		body{
			padding: 60px 0px;
		}
	</style>
</head>
<body>
	<%@include file="/WEB-INF/views/cabecalho.jsp" %>
	
	<jsp:doBody />
	
	<jsp:invoke fragment="extraScripts"></jsp:invoke>
</body>
</html>