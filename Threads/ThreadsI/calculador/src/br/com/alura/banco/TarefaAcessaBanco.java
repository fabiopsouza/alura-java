package br.com.alura.banco;

public class TarefaAcessaBanco implements Runnable {

	private GerenciadorDeTransacao tx;
	private PoolDeConexao pool;

	public TarefaAcessaBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		
		synchronized (pool) {
			System.out.println("peguei a chave do pool");
			pool.getConnection();
			
			synchronized (tx) {
				System.out.println("começando a gerenciar a tx");
				tx.begin();
			}
		}
		
	}

}
