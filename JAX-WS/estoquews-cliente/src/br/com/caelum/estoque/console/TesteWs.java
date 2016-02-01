package br.com.caelum.estoque.console;

import br.com.caelum.estoque.cliente.EstoqueWS;
import br.com.caelum.estoque.cliente.EstoqueWSService;
import br.com.caelum.estoque.cliente.Filtro;
import br.com.caelum.estoque.cliente.Filtros;
import br.com.caelum.estoque.cliente.Item;
import br.com.caelum.estoque.cliente.ListaItens;
import br.com.caelum.estoque.cliente.TipoItem;

public class TesteWs {

	public static void main(String[] args) {
		
		EstoqueWS cliente = new EstoqueWSService().getEstoqueWSPort();

		Filtros filtros = new Filtros();
		
		Filtro filtro = new Filtro();
		filtro.setNome("Galaxy Tab");
		filtro.setTipo(TipoItem.TABLET);
		filtros.getFiltro().add(filtro);
		
		ListaItens itens = cliente.todosOsItens(filtros);
		
		System.out.println("Quantidade: " + itens.getItem().size() + "\n");
		for (Item item : itens.getItem()) {
			System.out.println(item.getNome());
		}
	}

}
