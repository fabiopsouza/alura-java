package br.com.caelum.estoque.modelo.item;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) //Orient ao JAX-B para se basear nas propriedades não get/set
public class ListaItens {

	@XmlElement(name="item")
	private List<Item> itens;

	public ListaItens(List<Item> itens) {
		this.itens = itens;
	}
	
	//Construtor para o JAX-B
	ListaItens() {
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
}
