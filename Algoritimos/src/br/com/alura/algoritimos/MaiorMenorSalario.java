package br.com.alura.algoritimos;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.model.Funcionario;

public class MaiorMenorSalario {

	private static double menorSalario;
	private static double maiorSalario;

	public static void main(String[] args) {
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(new Funcionario("Fernando", 3.200));
		funcionarios.add(new Funcionario("Alfredo", 6.000));
		funcionarios.add(new Funcionario("Flávio", 5.000));
		funcionarios.add(new Funcionario("Marcela", 2.200));
		
		buscarMaiorEMenorSalario(funcionarios);
		
		System.out.println("Menor salario: " + menorSalario + " e Maior salário: " + maiorSalario);
	}

	private static void buscarMaiorEMenorSalario(List<Funcionario> funcionarios) {
		
		funcionarios.forEach(funcionario -> {
			if(funcionario.equals(funcionarios.get(0))){ //primeiro
				menorSalario = funcionario.getSalario();
				maiorSalario = funcionario.getSalario();
			}
		
			if(funcionario.getSalario() < menorSalario)
				menorSalario = funcionario.getSalario();
			else if(funcionario.getSalario() > maiorSalario)
				maiorSalario = funcionario.getSalario();
		});
	}

}
