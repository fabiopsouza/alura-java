package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {

	private EntityManager manager;

	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public Double mediaDaContaPeloTipo(Conta conta, TipoMovimentacao entrada){
		
		TypedQuery<Double>  query = manager.
				createQuery("select avg(m.valor) from Movimentacao m where m.conta=:pConta"
				+ " and m.tipoMovimentacao = :pTipo"
				+ " order by m.valor desc", Double.class);
		
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		query.setParameter("pConta", conta);
		
		Double media = query.getSingleResult();
		
		return media;
	}
}
