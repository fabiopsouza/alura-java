package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class TestaAluno {

	public static void main(String[] args) {

		// Set<String> alunos = new HashSet<>();
		Collection<String> alunos = new HashSet<>(); // genérico
		alunos.add("Rodrigo Turini");
		alunos.add("Alberto Souza");
		alunos.add("Nico Steppat");
		alunos.add("Sergio Lopes");
		alunos.add("Renan Saggio");
		alunos.add("Mauricio Aniche");
		alunos.add("Mauricio Aniche");
		alunos.add("Mauricio Aniche");
		alunos.add("Mauricio Aniche");

		boolean pauloEstaMatriculado = alunos.contains("Rodrigo Turini");
		System.out.println(pauloEstaMatriculado);

		alunos.forEach(aluno -> {
			System.out.println(aluno);
		});

		System.out.println(alunos);

		// Collections.sort(alunos); não compila, pois so funciona com listas
		List<String> alunosEmLista = new ArrayList<>(alunos);
		Collections.sort(alunosEmLista);
	}
}
