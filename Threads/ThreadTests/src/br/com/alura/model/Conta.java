package br.com.alura.model;

public class Conta {

	private double saldo;

	public Conta(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo(){
		return saldo;
	}

	public void saca(double valor) {
		this.saldo -= valor;
	}

	public synchronized void deposita(double valor) {
		this.saldo += valor;
	}

}
