package br.com.inove.conhecimento.cursomc.domain;

//CAMADA DTO
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//Serializable(padrao:1L)
@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	// declarar os atributos da classe
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	/**
	 * Associações (inicie as coleções) : de acordo com o projeto uma Categoria tem
	 * vários Produtos  Categoria 1 <----> * Produtos , logo uma categoria tem uma 
	 * lista de produtos. 
	 */
	@JsonManagedReference
	@ManyToMany(mappedBy = "categorias")
	private List<Produto>produtos=new ArrayList<>();
	
	
	

	// Construtores (não inclua coleções no construtor com parâmetros)

	public Categoria() {

	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

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

	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	// gerar os hashCode e equals(implementação padrão:somente id)
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
