package br.com.alura.algoritimos;

import br.com.alura.model.Produto;

public class TestaMenorPreco {

	public static void main(String[] args) {

		Produto produtos[] = { new Produto("Lamborgini", 1000000), new Produto("Lamborgini", 46000),
				new Produto("Lamborgini", 16000), new Produto("Lamborgini", 46000), new Produto("Lamborgini", 17000), null, null };

		int maisBarato = buscaMenor(produtos, 0, 4);

		System.out.println(produtos[maisBarato].getPreco());
	}

	public static int buscaMenor(Produto[] produtos, int inicio, int fim) {
		int maisBarato = 0;

		for (int atual = inicio; atual < fim; atual++) {
			if (produtos[atual].getPreco() < produtos[maisBarato].getPreco())
				maisBarato = atual;
		}
		return maisBarato;
	}

}
