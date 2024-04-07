package com.qintess.venda.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.qintess.venda.dao.Modelo;

@Entity
@Table (name  = " Fornecedor_Has_Produto ")
public class Fornecedor_Has_Produto implements Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int FornecedorHasid;
	@ManyToOne
	@JoinColumn (name = "Fornecedor_id")
	private Fornecedor fornecedor_id;
	@ManyToOne 
	@JoinColumn (name = "Produto_id")
	private Produto produto_id;
	@Column (nullable = false)
	private int estoque;
	@Column (precision = 10, scale = 2)
	private Double preco_custo;
	
	public Fornecedor_Has_Produto(Fornecedor fornecedor_id, Produto produto_id, int estoque, Double preco_custo) {
		this.fornecedor_id = fornecedor_id;
		this.produto_id = produto_id;
		this.estoque = estoque;
		this.preco_custo = preco_custo;
	}
	
	public Fornecedor_Has_Produto() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Fornecedor_Has_Produto [fornecedor_id=" + fornecedor_id + ", produto_id=" + produto_id + ", estoque="
				+ estoque + ", preco_custo=" + preco_custo + "]";
	}
	
	public Fornecedor getFornecedor_id() {
		return fornecedor_id;
	}
	public void setFornecedor_id(Fornecedor fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
	}
	public Produto getProduto_id() {
		return produto_id;
	}
	public void setProduto_id(Produto produto_id) {
		this.produto_id = produto_id;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public Double getPreco_custo() {
		return preco_custo;
	}
	public void setPreco_custo(Double preco_custo) {
		this.preco_custo = preco_custo;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
