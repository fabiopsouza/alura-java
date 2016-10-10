package br.com.alura.banheiro;

public class Banheiro {

	private boolean ehSujo = true;

	public void fazNumero1() {

		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");

			while (ehSujo)
				esperaLaFora(nome);

			System.out.println(nome + " fazendo coisa rapida");
			dormeUmPouco(5000);
			this.ehSujo = true;
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando mao");
			System.out.println(nome + " saindo banheiro");
		}
	}

	

	public void fazNumero2() {
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");

			while (ehSujo)
				esperaLaFora(nome);

			System.out.println(nome + " fazendo coisa demorada");
			dormeUmPouco(10000);
			this.ehSujo = true;
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando mao");
			System.out.println(nome + " saindo banheiro");
		}
	}

	public void limpa() {
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			
			if(!ehSujo){
				System.out.println(nome + " não está sujo, vou sair");
				return;
			}
			
			System.out.println(nome + " limpando banheiro");
			dormeUmPouco(13000);
			this.ehSujo = false;

			this.notifyAll();
			
			System.out.println(nome + " saindo banheiro");
		}
	}

	private void esperaLaFora(String nome) {
		System.out.println(nome + " eca, o banheiro está sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
		}
	}
	
	private void dormeUmPouco(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
		}
	}

}
