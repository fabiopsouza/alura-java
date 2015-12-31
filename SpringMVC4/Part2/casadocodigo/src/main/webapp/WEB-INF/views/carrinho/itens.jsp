<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Carrinho de compra</title>
</head>
<body>

	<a href='<c:url value="/carrinho/itens"/>'>Seu carrinho (${carrinhoCompras.quantidade })</a>	

	
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
					<form action='<c:url value="/pagamento/finalizar"/>' method="POST">
						<input type="submit" value="Finalizar compra"/>
					</form>
				</td>
			</tr>
		</tfoot>
	</table>
	

</body>
</html>