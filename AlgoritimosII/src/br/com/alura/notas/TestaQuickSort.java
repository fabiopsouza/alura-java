package br.com.alura.notas;

import br.com.alura.model.Nota;

public class TestaQuickSort {

	public static void main(String[] args) {

		Nota guilherme = new Nota("guilherme", 7);
		Nota[] notas = { new Nota("andre", 4), new Nota("carlos", 8.5), new Nota("ana", 10), new Nota("jonas", 3),
				new Nota("juliana", 6.7), new Nota("lucia", 9.3), new Nota("paulo", 9), new Nota("mariana", 5),
				guilherme };

		ordenar(notas, 0, notas.length);

		for (Nota nota : notas) {
			System.out.println(nota.getAluno() + " - " + nota.getValor());
		}
	}

	private static void ordenar(Nota[] notas, int de, int ate) {
		int elementos = ate - de;

		if (elementos > 1) {
			int posicaoDoPivo = particionar(notas, de, ate);
			ordenar(notas, de, posicaoDoPivo);
			ordenar(notas, posicaoDoPivo + 1, ate);
		}
	}

	private static int particionar(Nota[] notas, int inicial, int termino) {

		int menoresEncontrados = 0;
		Nota pivo = notas[termino - 1];

		for (int analisando = 0; analisando < termino - 1; analisando++) {
			Nota atual = notas[analisando];

			if (atual.getValor() <= pivo.getValor()) {
				trocar(notas, analisando, menoresEncontrados);
				menoresEncontrados++;
			}
		}

		trocar(notas, termino - 1, menoresEncontrados);

		return menoresEncontrados;
	}

	private static void trocar(Nota[] notas, int de, int para) {
		Nota nota1 = notas[de];
		Nota nota2 = notas[para];

		notas[para] = nota1;
		notas[de] = nota2;
	}
}