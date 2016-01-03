<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>


<tags:pageTemplate title="Carrinho de compras">

	<a href='<c:url value="/carrinho"/>'>Seu carrinho (${carrinhoCompras.quantidade })</a>	

	
	<table>
		<thead>
			<tr>
				<td>Item</td>
				<td>Preço</td>
				<td>Quantidade</td>
				<td>Total</td>
				<td></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${carrinhoCompras.itens }" var="item">
				<tr>
					<td>${item.produto.titulo }</td>
					<td>${item.preco }</td>
					<td>
						<input type="number" min="0" name="quantidade" value="${carrinhoCompras.getQuantidade(item) }"/>
					</td>
					<td>${carrinhoCompras.getTotal(item) }</td>
					<td>
						<form action="<c:url value="/carrinho/remover?produtoId=${item.produto.id }&tipoPreco=${item.tipoPreco }"/>" method="POST">
							<input type="image" src="#" alt="img-excluir"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td><strong>Total:</strong> </td>
				<td>
					<strong>${carrinhoCompras.total }</strong>
				</td>
			</tr>
			<tr>
				<td>
					<form:form servletRelativeAction="/pagamento/finalizar" method="POST">
						<input type="submit" value="Finalizar compra"/>
					</form:form>
				</td>
			</tr>
		</tfoot>
	</table>

</tags:pageTemplate>