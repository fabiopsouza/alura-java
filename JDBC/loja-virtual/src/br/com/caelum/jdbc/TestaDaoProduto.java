package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.dao.ProdutosDao;
import br.com.caelum.jdbc.modelo.Produto;

public class TestaDaoProduto {

	public static void main(String[] args) throws SQLException {

		Produto mesa = new Produto("Mesa azul", "Mesa com 4 pés");

		try (Connection con = new ConnectionPool().getConnection()) {
			ProdutosDao dao = new ProdutosDao(con);
			dao.salva(mesa);
			System.out.println("A mesa foi inserida com sucesso: " + mesa + "\n");
			
			List<Produto> produtos = dao.lista();
			
			for (Produto produto : produtos) {
				System.out.println(produto);
			}
		}
	}

}
