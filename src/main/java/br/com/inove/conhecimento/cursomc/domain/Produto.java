package br.com.inove.conhecimento.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

/** agora fazer o mapeamento da classe para o JPA */

@Entity // a classe Produto é um entidade(tabela)
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	// checklist 1 - Criar os Atributos básicos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	
	//relacionamento de muito para muitos 

	/**
	 * checklist 2 - Associações (inicie as coleções) : de acordo com o projeto um
	 * Produto tem uma ou mais Categorias Produto 1 <----> 1* Categorias, logo em
	 * produtos teremos uma lista de Categorias.
	 */
@JsonBackReference	
@ManyToMany
@JoinTable(name="PRODUTO_CATEGORIA",
	joinColumns=@JoinColumn(name="produto_id"),
	inverseJoinColumns=@JoinColumn(name="categoria_id")
		
		)
	private List<Categoria> categorias = new ArrayList();

	// checklist 3- Construtores (não inclua coleções no construtor com parâmetro)

	// 1º Construor vazio
	public Produto() {

	}

	/**
	 * 2º Construtor nomeado aqui entra todos os atributos da classe menos o List
	 * pois ele já foi inicializado pelo ArrayList
	 */
	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	// checkList 3 - Gerar Getters e Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	// checkList - Gerar hashCode e equal(implementação padrão:somente id )
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
