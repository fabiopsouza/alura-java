package br.com.alura.lista;

public class TarefaImprimir implements Runnable {

	private Lista lista;

	public TarefaImprimir(Lista lista) {
		this.lista = lista;
	}

	@Override
	public void run() {

//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {}
		
		synchronized (lista) {
			
			if(!lista.estaCheia()){
				try {
					System.out.println("indo esperar, aguardando notificação");
					lista.wait();
				} catch (InterruptedException e) {
				}
			}

			for (int i = 0; i < lista.tamanho(); i++)
				System.out.println(i + " - " + lista.pegaElemento(i));

		}
	}

}
