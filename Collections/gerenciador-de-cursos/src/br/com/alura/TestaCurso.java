package br.com.alura;

import br.com.alura.model.Aula;
import br.com.alura.model.Curso;

public class TestaCurso {

	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções Java", "Paulo Silveira");
		
		//javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 21));
		javaColecoes.adiciona(new Aula("Modelando uma lista", 21));
		
		System.out.println(javaColecoes.getAulas());
	}

}
