package br.com.alura.model;

public class Nota {

	private String aluno;
	private double valor;

	public Nota(String aluno, double valor) {
		this.aluno = aluno;
		this.valor = valor;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
