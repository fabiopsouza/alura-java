package br.com.alura.lista;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		
		//List<String> lista = new ArrayList<String>();
		//List<String> lista = Collections.synchronizedList(new ArrayList<String>());
		//List<String> lista = new Vector<String>(); -> assincrono por padrão
		
		Lista lista = new Lista();
		
		for (int i = 0; i < 10; i++)
			new Thread(new TarefaAdicionarElemento(lista, i)).start();
		
		new Thread(new TarefaImprimir(lista)).start();
		
		Thread.sleep(2000);
	}
	
}
