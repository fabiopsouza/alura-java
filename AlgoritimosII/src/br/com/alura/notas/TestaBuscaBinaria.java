package br.com.alura.notas;

import br.com.alura.model.Nota;

public class TestaBuscaBinaria {

	public static void main(String[] args) {

		Nota guilherme = new Nota("guilherme", 7);
		Nota[] notas = { new Nota("andre", 4), new Nota("carlos", 8.5), new Nota("ana", 10), new Nota("jonas", 3),
				new Nota("juliana", 6.7), new Nota("lucia", 9.3), new Nota("paulo", 9), new Nota("mariana", 5),
				guilherme };

		ordenar(notas, 0, notas.length);
		
		int encontrei = buscaBinaria(notas, 0, notas.length, 1);

		if(encontrei >= 0)
			System.out.println("Encontrei: " + encontrei + "\n");
		else
			System.out.println("Não encontrei\n");
		
		for (Nota nota : notas) {
			System.out.println(nota.getAluno() + " - " + nota.getValor());
		}
	}

	@SuppressWarnings("unused")
	private static int buscaLinear(Nota[] notas, double buscando){
		for (int atual = 0; atual < notas.length; atual++) {
			if(notas[atual].getValor() == buscando)
				return atual;
		}
		
		return -1; 
	}
	
	private static int buscaBinaria(Nota[] notas, int de, int ate, double buscando) {
		System.out.println("Buscndo " + buscando + " entre " + de + " e " + ate);
		int meio = (de + ate) / 2;
		
		if(de > ate) return -1;
		
		Nota nota = notas[meio];
		
		if(buscando == nota.getValor())
			return meio;
		
		if(buscando < nota.getValor())
			return buscaBinaria(notas, de, meio - 1, buscando);
		
		return buscaBinaria(notas, meio + 1, ate, buscando);
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