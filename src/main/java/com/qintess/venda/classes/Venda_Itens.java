package com.qintess.venda.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.qintess.venda.dao.Modelo;

@Entity
@Table (name  = " Venda_Itens ")
public class Venda_Itens implements Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendaItemId;	
	@OneToOne
	private Produto produto_id;
	@ManyToOne
	private Venda venda_id;
	@Column (nullable = false)
	private int quantidade;
	@Column (name = "Proco_Custo  ", precision = 10, scale = 2)
	private Double preco_custo;
	@Column (precision = 10, scale = 2)
	private Double preco_unit;
	
	public Venda_Itens(int vendaItemId, Produto produto_id, Venda venda_id, int quantidade, Double preco_custo, Double preco_unit) {
		this.vendaItemId = vendaItemId;
		this.produto_id = produto_id;
		this.venda_id = venda_id;
		this.quantidade = quantidade;
		this.preco_custo = preco_custo;
		this.preco_unit = preco_unit;
	}
	
	public Venda_Itens() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Venda_Itens [id=" + vendaItemId + ", produto_id=" + produto_id + ", venda_id=" + venda_id + ", quantidade="
				+ quantidade + ", preco_custo=" + preco_custo + ", preco_unit=" + preco_unit + "]";
	}
	public int getVendaItemId() {
		return vendaItemId;
	}
	public void setVendaItemId(int vendaItemId) {
		this.vendaItemId = vendaItemId;
	}
	public Produto getProduto_id() {
		return produto_id;
	}
	public void setProduto_id(Produto produto_id) {
		this.produto_id = produto_id;
	}
	public Venda getVenda_id() {
		return venda_id;
	}
	public void setVenda_id(Venda venda_id) {
		this.venda_id = venda_id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco_custo() {
		return preco_custo;
	}
	public void setPreco_custo(Double preco_custo) {
		this.preco_custo = preco_custo;
	}
	public Double getPreco_unit() {
		return preco_unit;
	}
	public void setPreco_unit(Double preco_unit) {
		this.preco_unit = preco_unit;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}