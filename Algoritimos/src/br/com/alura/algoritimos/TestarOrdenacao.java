package br.com.alura.algoritimos;

import br.com.alura.model.Produto;

public class TestarOrdenacao {

	public static void main(String[] args) {
		
		Produto produtos[] = { new Produto("Lamborgini", 1000000), new Produto("Jipe", 46000),
				new Produto("Brasília", 16000), new Produto("Smart", 46000), new Produto("Fusca", 17000) };
		
		//selectionSort(produtos, produtos.length);
		
		insertionSort(produtos, produtos.length);
		
		imprimir(produtos);
	}

	public static void selectionSort(Produto[] produtos, int quantidadeDeElementos) {
		for (int atual = 0; atual < quantidadeDeElementos; atual++) {			
			int menor = buscaMenor(produtos, atual, quantidadeDeElementos);
			
			Produto produtoAtual = produtos[atual];
			Produto produtoMenor = produtos[menor];
			
			produtos[atual] = produtoMenor;
			produtos[menor] = produtoAtual;
		}
	}

	private static void insertionSort(Produto[] produtos, int quantidadeDeElementos) {
		for (int atual = 0; atual < quantidadeDeElementos; atual++) {
			int analise = atual;
			while(analise > 0 && produtos[analise].getPreco() < produtos[analise - 1].getPreco()){
				Produto produtoAnalise = produtos[analise];
				Produto produtosAnaliseMenos1 = produtos[analise - 1];
				produtos[analise] = produtosAnaliseMenos1;
				produtos[analise - 1] = produtoAnalise;
				analise--;
			}
		}
	}
	
	public static int buscaMenor(Produto[] produtos, int inicio, int fim) {
		int maisBarato = 0;

		for (int atual = inicio; atual < fim; atual++) {
			if (produtos[atual] != null && produtos[atual].getPreco() < produtos[maisBarato].getPreco())
				maisBarato = atual;
		}
		
		return maisBarato;
	}

	public static void imprimir(Produto[] produtos) {
		for (Produto produto : produtos) {
			if(produto != null){
				System.out.println(produto.getNome() + " - " + produto.getPreco());
			}
		}
	}
}
