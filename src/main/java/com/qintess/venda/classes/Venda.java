package com.qintess.venda.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.qintess.venda.dao.Modelo;

@Entity
@Table (name  = " Venda ")
public class Venda implements Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Vendaid;	
	@Column (nullable = false)
	private int cliente_id;
	@Column (nullable = false)
	private int desconto;	
	@Column (nullable = false)
	private int forma_pagamento;
	@Column (nullable = false)
	private Date data;
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY,
			mappedBy = "venda_id", orphanRemoval = true)
	private List<Venda_Itens> itensvenda = new ArrayList<>();

	public Venda(int Vendaid, int cliente_id, int desconto, int forma_pagamento, Date data,
			List<Venda_Itens> itensvenda) {
		this.Vendaid = Vendaid;
		this.cliente_id = cliente_id;
		this.desconto = desconto;
		this.forma_pagamento = forma_pagamento;
		this.data = data;
		this.itensvenda = itensvenda;
	}
	
	public Venda() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Venda [id=" + Vendaid + ", cliente_id=" + cliente_id + ", desconto=" + desconto + ", forma_pagamento="
				+ forma_pagamento + ", data=" + data + ", itensvenda=" + itensvenda + "]";
	}

	public int getVendaid() {
		return Vendaid;
	}

	public void setVendaid(int Vendaid) {
		this.Vendaid = Vendaid;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public int getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(int forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Venda_Itens> getItensvenda() {
		return itensvenda;
	}

	public void setItensvenda(List<Venda_Itens> itensvenda) {
		this.itensvenda = itensvenda;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}