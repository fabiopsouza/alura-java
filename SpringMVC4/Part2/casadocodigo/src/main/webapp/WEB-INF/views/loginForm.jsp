<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Casa do Codigo</title>

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
	<div class="container">
	
		<h1>Login da Casa do Código</h1>
	
		<!-- form:form seta o path inicial como "produto" e já adiciona o hidden com token -->
		<form:form servletRelativeAction="/login" method="POST" 
					commandName="produto" enctype="multipart/form-data">
			<div class="form-group">
				<label>E-mail</label>
				<input name="username" type="text" class="form-control"/>
				<form:errors path="titulo"/>
			</div>
			<div class="form-group">
				<label>Senha</label>
				<input name="password" type="password" class="form-control"/>
				<form:errors path="descricao"/>
			</div>
			
			<button type="submit" class="btn btn-primary">Logar</button>
		</form:form>
	</div>
</body>
</html>