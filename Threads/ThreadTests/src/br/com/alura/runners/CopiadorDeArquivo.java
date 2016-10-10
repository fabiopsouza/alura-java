package br.com.alura.runners;

public class CopiadorDeArquivo implements Runnable {

	public void run() {
		for(int i = 0; i<10000; i++)
			System.out.println("copiador de arquivo...");
	}

}
