package br.com.alura.runners;

import br.com.alura.model.Conta;

public class FazDeposito implements Runnable{

	private Conta conta;

	public FazDeposito(Conta conta) {
		this.conta = conta;
	}

	public void run() {
		conta.deposita(100.0);
	}

}
