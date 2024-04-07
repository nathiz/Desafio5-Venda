package com.qintess.venda.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.qintess.venda.dao.Modelo;

@Entity
@Table (name  = " Fornecedor ")
public class Fornecedor implements Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Fornecedorid;
	@Column (name = "Nome ", length = 45, nullable = false)
	private String nome;
	@Column (name = "Telefone ", length = 45, nullable = false)
	private String telefone;
	@Column (name = "Contato ", length = 45, nullable = false)
	private String contato;

	public Fornecedor(int fornecedorid, String nome, String telefone, String contato) {
		Fornecedorid = fornecedorid;
		this.nome = nome;
		this.telefone = telefone;
		this.contato = contato;
	}
	
	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Fornecedor [Fornecedorid=" + Fornecedorid + ", nome=" + nome + ", telefone=" + telefone + ", contato="
				+ contato + "]";
	}
	public int getFornecedorid() {
		return Fornecedorid;
	}
	public void setFornecedorid(int fornecedorid) {
		Fornecedorid = fornecedorid;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
