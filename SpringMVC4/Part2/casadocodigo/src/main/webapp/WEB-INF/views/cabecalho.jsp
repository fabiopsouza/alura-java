<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href='<c:url value="/"/>'>Casa do Código</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li>
        	<a href='<c:url value="/produtos"/>'>
        		<fmt:message key="menu.listaProdutos"/>
        	</a>
		</li>
        <li>
        	<a href='<c:url value="/produtos/form"/>'>
        		<fmt:message key="menu.cadastroProduto"/>
        	</a>
       	</li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<li>
      		<a href="?locale=pt" rel="nofollow">
      			<fmt:message key="menu.pt"/>
      		</a>
      	</li>
      	<li>
      		<a href="?locale=en_US" rel="nofollow">
      			<fmt:message key="menu.en"/>
      		</a>
      	</li>
      	<li>
      		<a href="">
      			<!--<security:authentication property="principal.username"/>-->
      			<security:authentication property="principal" var="usuario"/>
      			Usuário logado: ${usuario.username }
      		</a>
      	</li>
      	<li>
      		<a href='<c:url value="/logout"/>'>
      			Logout
      		</a>
      	</li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>	