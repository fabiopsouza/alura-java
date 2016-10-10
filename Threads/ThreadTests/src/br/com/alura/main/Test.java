package br.com.alura.main;

import java.util.Date;

import br.com.alura.model.Conta;
import br.com.alura.runners.FazDeposito;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		Date inicio = new Date();
		
//		BarraDeProgresso barra = new BarraDeProgresso();
//		Thread t1 = new Thread(barra);
//		t1.start();
//		
//		CopiadorDeArquivo copiador = new CopiadorDeArquivo();
//		Thread t2 = new Thread(copiador);
//		t2.start();
		
		Conta c1 = new Conta(500.0);
		FazDeposito acao = new FazDeposito(c1);
		Thread t1 = new Thread(acao);
		Thread t2 = new Thread(acao);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Saldo: " + c1.getSaldo());
		System.out.println(new Date().getTime() - inicio.getTime());
	}

}
