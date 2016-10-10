package br.com.alura;

import java.util.Iterator;

import br.com.alura.model.Aluno;
import br.com.alura.model.Aula;
import br.com.alura.model.Curso;

public class TestaCursoComAluno {

	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as coleções Java", "Paulo Silveira");
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 21));
		javaColecoes.adiciona(new Aula("Modelando uma lista", 21));

		Aluno a1 = new Aluno("Rodrigo Turini", 34672);
		Aluno a2 = new Aluno("Guilherme Silveira", 5617);
		Aluno a3 = new Aluno("Mauricio Aniche", 17645);
		
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		//Métodos antigo de percorrer (antes do Java 5)
		Iterator<Aluno> iterador = javaColecoes.getAlunos().iterator();
		while(iterador.hasNext()){
			System.out.println(iterador.next());
		}
		
		//Vector<Aluno> vetor = new Vector<>();
		
		//Método novo (Java 8)
		System.out.println("Todos os alunos matriculados no curso ");
		javaColecoes.getAlunos().forEach(aluno -> {
			System.out.println(aluno);
		});
		
		System.out.println("O aluno " + a1 + " está matriculado? " + javaColecoes.estaMatriculado(a1));
		
		Aluno turini = new Aluno("Rodrigo Turini", 34672);
		System.out.print("E esse turini, está matriculado? ");
		System.out.println(javaColecoes.estaMatriculado(turini));
	}

}
