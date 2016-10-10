package br.com.alura.notas;

import br.com.alura.model.Nota;

public class TestaPivota {

	public static void main(String[] args) {

		Nota guilherme = new Nota("guilherme", 7);
		Nota[] notas = { new Nota("andre", 4), new Nota("carlos", 8.5), new Nota("ana", 10), new Nota("jonas", 3),
				new Nota("juliana", 6.7), new Nota("lucia", 9.3), new Nota("paulo", 9), new Nota("mariana", 5),
				guilherme  };

		int novaPosicao = particiona(notas, 0, notas.length);
		
		System.out.println("O pivo foi para: " + novaPosicao + "\n");
		
		for (Nota nota : notas) {
			System.out.println(nota.getAluno() + " - " + nota.getValor());
		}
	}

	private static int particiona(Nota[] notas, int inicial, int termino) {
		
		int menoresEncontrados = 0;
		Nota pivo = notas[termino - 1];
		
		for (int analisando = 0; analisando < termino - 1; analisando++) {
			Nota atual = notas[analisando];
			
			if(atual.getValor() <= pivo.getValor()){
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
