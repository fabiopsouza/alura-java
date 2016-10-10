package ed.listaligada;

public class TestaListaLigada {

	public static void main(String[] args) {
		ListaLigada lista = new ListaLigada();
		
		System.out.println(lista);
		lista.adicionaNoComeco("mauricio");
		
		System.out.println(lista);
		
		lista.adicionaNoComeco("paulo");
		
		System.out.println(lista);
		
		lista.adicionaNoComeco("guilherme");
		
		System.out.println(lista);
		
		lista.adiciona("paulo");
		
		System.out.println(lista);
		
		lista.adiciona(2, "cecilia");
		
		System.out.println(lista);
		
		lista.removeDoComeco();
		
		System.out.println(lista);
		
		lista.removeDoFim();
		
		System.out.println(lista);
		
		lista.adiciona("José");
		lista.adiciona("João");
		
		System.out.println(lista);
		
		lista.remove(2);
		
		System.out.println(lista);
		
		System.out.println(lista.contem("cecilia"));
		System.out.println(lista.contem("mauricio"));
	}
}