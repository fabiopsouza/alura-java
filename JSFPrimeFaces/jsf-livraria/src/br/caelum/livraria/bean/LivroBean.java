package br.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LivroBean {

	private Livro livro = new Livro();

	public Livro getLivro(){
		return livro;
	}
	
	public void gravar(){
		System.out.println("Gravado Livro " + this.livro.getTitulo());
	}
	
}
