<%@page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate title="Lista de Produtos">

	<jsp:attribute name="extraScripts">
		<script>
			console.log("Para renderizar um script para a página é obrigatório o uso de jsp:body e o jsp:attribute deve vir antes de jsp:body")
		</script>
	</jsp:attribute>

	<jsp:body>
		<div class="container">
			<h1>Lista de Produtos</h1>
		
			<div>${sucesso }</div>
			<div>${falha }</div>
		
			<table class="table table-bordered table-striped table-hover">
				<tr>
					<th>Título</th>
					<th>Descrição</th>
					<th>Páginas</th>
				</tr>
				<c:forEach items="${produtos }" var="produto">
					<tr>
						<td>
							<a href="produtos/detalhe/${produto.id }">${produto.titulo }</a>
						</td>
						<td>${produto.descricao }</td>
						<td>${produto.paginas }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</jsp:body>
</tags:pageTemplate>