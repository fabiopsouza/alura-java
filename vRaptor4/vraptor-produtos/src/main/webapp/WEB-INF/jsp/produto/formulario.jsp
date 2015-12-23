<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<title>Novo Produto</title>
</head>
<body>
	<div class="container">
	
		<h1>Adicionar Produto</h1>
	
		<form action="<c:url value="/produto/adiciona"/>" method="POST">
			Nome: <input type="text" class="form-control" name="produto.nome" />
			Valor: <input type="text" class="form-control" name="produto.valor" /> 
			Quantidade: <input type="text" class="form-control" name="produto.quantidade" />
			<button type="submit" class="btn btn-primary">Adicionar</button>
		</form>
		
		<c:forEach items="${errors}" var="erro">
			${erro.category} - ${erro.message} <br>
		</c:forEach>
	</div>

</body>
</html>