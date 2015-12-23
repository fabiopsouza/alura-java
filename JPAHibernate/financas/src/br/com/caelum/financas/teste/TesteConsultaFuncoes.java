package br.com.caelum.financas.teste;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncoes {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(12);
		
//		MovimentacaoDao dao = new MovimentacaoDao(manager);
//		Double media = dao.mediaDaContaPeloTipo(conta, TipoMovimentacao.SAIDA);
		
		TypedQuery<Double>  query = manager.
				createNamedQuery("mediaDaContaPeloTipoMovimentacao", Double.class);
		
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		query.setParameter("pConta", conta);
		
		Double media = query.getSingleResult();
		
		System.out.println(media);
	}

}
