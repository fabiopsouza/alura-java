<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Home</h1>
	
	<h2>Bloqueio de logins quando não está logado</h2>
	<nav>
		<a>Link público</a>
		
		<security:authorize access="isAuthenticated()">
			<a>Link privado</a>
		</security:authorize>
	</nav>
	
	<ul>
		<c:forEach items="${produtos }" var="produto">
			<li>
				<a href='<c:url value="/produtos/detalhe/${produto.id }" />'>
					<h2>${produto.titulo }</h2>
					<small>Compre</small>
				</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>