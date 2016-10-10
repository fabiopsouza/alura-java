package ed.pilha;

import java.util.Stack;

public class TesteDaPilha {

	public static void main(String[] args) {
		Pilha pilha = new Pilha();
		
		pilha.push("Mauricio");
		System.out.println(pilha);
		
		pilha.push("Guilherme");
		System.out.println(pilha);
		
		pilha.pop();
		pilha.pop();
		System.out.println(pilha);
		
		System.out.println("está vazia? " + pilha.vazia());
		
		pilha.push("Marcelo");
		System.out.println(pilha);
		
		System.out.println("está vazia? " + pilha.vazia());
		
		Stack<String> stack = new Stack<String>();
		stack.push("Mauricio");
		stack.push("Marcelo");
		
		System.out.println(stack);
		
		String nome = stack.peek(); //Retorna o elemento que o pop removeria
		System.out.println(nome);
	}

}
