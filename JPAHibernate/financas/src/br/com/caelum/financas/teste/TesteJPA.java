package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setId(4);
		conta.setTitular("Fabio Santos");
		conta.setBanco("HSBC");
		conta.setNumero("123456");
		conta.setAgencia("123");

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		//em.persist(conta); insere
		
		//em.find(Conta.class, 1);
		
		//em.merge(conta); isert ou update dependendo se ja existe
		
		//Conta contaARemover = em.find(Conta.class, 10);
		//em.remove(contaARemover);
		
		em.getTransaction().commit();
		em.close();
	}

}
