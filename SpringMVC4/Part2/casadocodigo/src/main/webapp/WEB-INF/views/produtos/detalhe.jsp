<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html lang="pt-BR">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width">
	<link rel="shortcut icon" href="//cdn.shopify.com/s/files/1/0155/7645/t/187/assets/favicon.ico?13414332408319958314" type="image/ico"/>
	<link href="https://plus.google.com/108540024862647200608" rel="publisher">


	<title>${produto.titulo } - Casa do Código</title>

	<link rel="alternate" type="application/json+oembed" href="http://www.casadocodigo.com.br/products/livro-java8.oembed" />

	<link rel="canonical" href="http://www.casadocodigo.com.br/products/livro-java8" />
</head>
<body class="produto">
	<header role="banner" class="cabecalhoPrincipal container">
		

		<div id="navegacaoCabecalho" class="cabecalhoPrincipal-navegacao">
			

			<a tabindex="2" class="cabecalhoPrincipal-itemNavegacao cabecalhoPrincipal-mostraCategoriasEBusca" href="#navegacaoCabecalho">
				<img class="cabecalhoPrincipal-iconeItemNavegacao"
					 src="//cdn.shopify.com/s/files/1/0155/7645/t/187/assets/search.svg?13414332408319958314"
					 alt="Abrir navegação por categorias e busca">
			</a>

			<a tabindex="-1" class="cabecalhoPrincipal-itemNavegacao cabecalhoPrincipal-escondeCategoriasEBusca" href="#">
				<img class="cabecalhoPrincipal-iconeItemNavegacao"
					 src="//cdn.shopify.com/s/files/1/0155/7645/t/187/assets/search.svg?13414332408319958314"
					 alt="Ir para ao topo da página">
			</a>

			<a tabindex="3" href="/cart" title="Ir para sacola de compras" class="sacola cabecalhoPrincipal-itemNavegacao">
				<svg width="28px" height="34px" viewBox="0 0 28 34" role="img" aria-labelledby="sacolaLabel" class="sacola-icone">
					<title id="sacolaLabel">
						Você tem 0 itens na sacola
					</title>
					<path fill="#f8965d" d="M1.66666667,26.9714355 L18.3333333,26.9714355 C19.2533333,26.9714355 20,26.2247689 20,25.3047689 L20,6.97143555 C20,6.05143555 19.2533333,5.30476888 18.3333333,5.30476888 L14.9916667,5.30476888 C14.9516667,2.53643555 12.735,0.30476888 10,0.30476888 C7.265,0.30476888 5.04833333,2.53643555 5.00833333,5.30476888 L1.66666667,5.30476888 C0.746666667,5.30476888 0,6.05143555 0,6.97143555 L0,25.3047689 C0,26.2247689 0.746666667,26.9714355 1.66666667,26.9714355 L1.66666667,26.9714355 Z M12.5,10.3047689 L7.5,10.3047689 C7.04,10.3047689 6.66666667,9.93143555 6.66666667,9.47143555 C6.66666667,9.01143555 7.04,8.63810221 7.5,8.63810221 L12.5,8.63810221 C12.96,8.63810221 13.3333333,9.01143555 13.3333333,9.47143555 C13.3333333,9.93143555 12.96,10.3047689 12.5,10.3047689 L12.5,10.3047689 Z M10,1.97143555 C11.8116667,1.97143555 13.285,3.45976888 13.325,5.30476888 L6.675,5.30476888 C6.715,3.45976888 8.18833333,1.97143555 10,1.97143555 L10,1.97143555 Z"></path>
					<g>
						<circle cx="19.5" cy="24.8047689" r="8.5" role="presentation" fill="#FFF"/>
						<text text-decoration="none" text-anchor="middle" x="19.5" y="30" class="sacola-contador">
							${carrinhoCompras.quantidade }
						</text>
					</g>
				 </svg>
			</a>
		</div>
	</header>


	<main>
		

<article id="${produto.id }" itemscope itemtype="http://schema.org/Book">
	<header class="cabecalhoProduto container">
	
	<div class="cabecalhoProduto-tituloEAutor">
		<h1 itemprop="name" class="cabecalhoProduto-titulo">
			<span class="cabecalhoProduto-titulo-principal" role="presentation">
				${produto.titulo }
			</span>
			<span class="cabecalhoProduto-titulo-sub" role="presentation">
				 ${produto.descricao }
			</span>
		</h1>
		<span class="cabecalhoProduto-nomeAutor">
			Paulo Silveira, Rodrigo Turini
		</span>
	</div>
	



</header>
	
<form action='<c:url value="/carrinho/add"/>' method="POST" class="adicionarAoCarrinho">
	<ul class="adicionarAoCarrinho-listaOfertas">
	
		<input type="hidden" value="${produto.id }" name="produtoId"/>
	
		<c:forEach items="${produto.precos }" var="preco">
			<li class="adicionarAoCarrinho-oferta" itemprop="offers" itemscope itemtype="http://schema.org/Offer">
				<label class="adicionarAoCarrinho-infosDaOferta" for="product-variant-970167977">
					<span class="adicionarAoCarrinho-tipoDaOferta" role="presentation" itemprop="category"
						  itemscope itemtype="http://schema.org/Ebook">
						<span class="adicionarAoCarrinho-tipoDaOferta-nome">
							${preco.tipo }
						</span>						
					</span>
					<p class="adicionarAoCarrinho-preco">
						<small class="adicionarAoCarrinho-preco-promocao">
							<del class="adicionarAoCarrinho-preco-promocao-valor">R$ 39,80</del> por
						</small>
						<span class="adicionarAoCarrinho-preco-valor" itemprop="price">
							${preco.valor }
						</span>
					</p>
				</label>
				
				<input type="radio" name="tipoPreco" value="${preco.tipo }"/>
			</li>
		</c:forEach>
	
		<button type="submit" name="id" value="970167977" title="Compre o E-book">
			Comprar
		</button>
	</ul>
</form>

	
	<section class="conteudoDoLivro infoSection" itemprop="description">
		<h2 class="infoSection-titulo">
			Conteúdo
		</h2>
		
		<p class="infoSection-texto">
			Você é um programador com boa fluência em Java? Está na hora de dar mais um passo.
		</p>
	
		<p class="infoSection-texto">
			Quase 20 anos após sua primeira versão, um novo Java surge com novidades importantes. Entre os principais recursos, a linguagem recebe default methods, method references e lambdas. São conceitos simples, mas que trazem importantes possibilidades. Durante o livro, exploraremos esses e outros avanços. Sempre com exemplos práticos e apresentando onde utiliza-los, migrando o código legado do dia a dia para o novo paradigma funcional do Java 8.
		</p>
		<p class="infoSection-texto">
			Com esse tripé de conceitos, a API conseguiu evoluir de uma maneira interessante. Os pacotes java.util.stream e java.util.function serão explorados com profundidade, apresentando formas sucintas para trabalhar com coleções e outros tipos de dados. Streams e Collectors farão parte da sua rotina e serão tão essenciais nas suas aplicações quanto já são as Collections e o java.io.
		</p>
		<p class="infoSection-texto">
			Por último, veremos como a nova API de java.time vem mudar da água pro vinho a forma de trabalhar com datas e horários.
		</p>
		<p class="infoSection-texto">
			
		</p>		
		<p class="infoSection-texto">
			Ainda curioso para entender melhor as possibilidades? Se queremos ordenar todos os usuários de uma List por pontos, e filtrar apenas os que possuem mais de 100, far&#237;amos assim no Java 7:
		</p>
		</section>

		<section class="infosAdicionaisDoLivro infoSection">
		<h2 class="infoSection-titulo">
			Dados do produto
		</h2>
		<dl class="infosAdicionaisDoLivro-info">
			<dt class="infosAdicionaisDoLivro-info-titulo">
				Número de páginas:
			</dt>
			<dd class="infosAdicionaisDoLivro-info-valor" itemprop="numberOfPages">
				${produto.paginas }
			</dd>
			
			<dt class="infosAdicionaisDoLivro-info-titulo">
				ISBN:
			</dt>
			<dd class="infosAdicionaisDoLivro-info-valor" itemprop="isbn">
				978-85-66250-46-6
			</dd>
			
			<dt class="infosAdicionaisDoLivro-info-titulo">
				Data de publicação:
			</dt>
			<dd class="infosAdicionaisDoLivro-info-valor">
				<fmt:formatDate pattern="dd/MM/yyyy" value="${produto.dataLancamento.time }" />
			</dd>
		</dl>
		</section>
	
	</article>
  </main>	
</body>
</html>
