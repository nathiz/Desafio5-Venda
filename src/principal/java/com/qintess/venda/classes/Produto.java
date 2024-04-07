package com.qintess.venda.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.qintess.venda.dao.Modelo;

@Entity
@Table (name  = " Produto ")
public class Produto implements Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Produtoid;
	@Column (precision = 10, scale = 2)
	private double preco_venda;
	@Column (nullable = false)
	private int min_estoque;
	@Column (name = "Nome  ", length = 45, nullable = false)
	private String nome;
	@Column (name = "Foto  ", length = 45, nullable = true)
	private String foto;
	
	public Produto(int Produtoid, double preco_venda, int min_estoque, String nome, String foto) {
		this.Produtoid = Produtoid;
		this.preco_venda = preco_venda;
		this.min_estoque = min_estoque;
		this.nome = nome;
		this.foto = foto;
	}

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Produto [id=" + Produtoid + ", preco_venda=" + preco_venda + ", min_estoque=" + min_estoque + ", nome=" + nome
				+ ", foto=" + foto + "]";
	}

	public int getProdutoid() {
		return Produtoid;
	}

	public void setProdutoid(int Produtoid) {
		this.Produtoid = Produtoid;
	}

	public double getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(double preco_venda) {
		this.preco_venda = preco_venda;
	}

	public int getMin_estoque() {
		return min_estoque;
	}

	public void setMin_estoque(int min_estoque) {
		this.min_estoque = min_estoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
