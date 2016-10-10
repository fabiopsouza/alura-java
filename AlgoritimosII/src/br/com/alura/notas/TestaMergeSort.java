package br.com.alura.notas;

import br.com.alura.model.Nota;

public class TestaMergeSort {

	public static void main(String[] args) {

		Nota[] notas = { new Nota("andre", 4), new Nota("carlos", 8.5), new Nota("ana", 10), new Nota("jonas", 3),
				new Nota("juliana", 6.7), new Nota("guilherme", 7), new Nota("paulo", 9), new Nota("mariana", 5),
				new Nota("lucia", 9.3) };

		ordenar(notas, 0, notas.length);
		
		for (Nota nota : notas) {
			System.out.println(nota.getAluno() + " - " + nota.getValor());
		}

	}

	public static void ordenar(Nota[] notas, int inicial, int termino) {
		int quantidade = termino - inicial;
		
		if(quantidade > 1){
			int meio = (inicial + termino) / 2;
			ordenar(notas, inicial, meio); //ordenar metade da esquerda
			ordenar(notas, meio, termino); //ordenar metade da direita
			intercalar(notas, inicial, meio, termino); //intercalar duas metades ordenadas
		}
	}

	private static void intercalar(Nota[] notas, int inicial, int miolo, int termino) {

		Nota[] resultado = new Nota[notas.length];
		
		int atual = 0;
		int atual1 = inicial;
		int atual2 = miolo;

		while (atual1 < miolo && atual2 < termino) {

			Nota nota1 = notas[atual1];
			Nota nota2 = notas[atual2];

			if (nota1.getValor() < nota2.getValor()) {
				resultado[atual++] = nota1;
				atual1++;
			} else {
				resultado[atual++] = nota2;
				atual2++;
			}
		}

		while (atual1 < miolo) {
			resultado[atual++] = notas[atual1++];
		}

		while (atual2 < termino) {
			resultado[atual++] = notas[atual2++];
		}
		
		for (int contador = 0; contador < atual; contador++) {
			notas[inicial + contador] = resultado[contador];
		}
	}

}
