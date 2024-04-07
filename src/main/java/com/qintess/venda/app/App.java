package com.qintess.venda.app;

import java.util.Date;

import com.qintess.venda.classes.Fornecedor;
import com.qintess.venda.classes.Fornecedor_Has_Produto;
import com.qintess.venda.classes.Produto;
import com.qintess.venda.classes.Venda;
import com.qintess.venda.classes.Venda_Itens;
import com.qintess.venda.dao.GenericDao;

public class App {

	private static int estoqueAtual = 0;
	
	public static void main(String[] args) {
	
		System.out.println("Funcionandooo!!");
		
		Produto produto1 = new Produto();
		Produto produto2 = new Produto();
		
		GenericDao<Produto> daoProduto = new GenericDao<Produto>();		
		GenericDao<Produto> daoProduto2 = new GenericDao<Produto>();		
		
		produto1.setNome("Xbox One");
		produto1.setMin_estoque(5);
		produto1.setPreco_venda(1800.00);
		daoProduto.saveOrUpdate(produto1);
		
		produto2.setNome("PS5");
		produto2.setMin_estoque(4);
		produto2.setPreco_venda(5000.00);
		daoProduto2.saveOrUpdate(produto2);

		Venda venda1 = new Venda();
		
		GenericDao<Venda> daoVenda = new GenericDao<Venda>();		
		
		venda1.setCliente_id(1);
		venda1.setData(new Date());
		venda1.setDesconto(1);
		daoVenda.saveOrUpdate(venda1);
				
		Fornecedor fornecedor1 = new Fornecedor();
		Fornecedor fornecedor2 = new Fornecedor();
		
		GenericDao<Fornecedor> daoFornecedor = new GenericDao<Fornecedor>();		
		GenericDao<Fornecedor> daoFornecedor2 = new GenericDao<Fornecedor>();		
		
		fornecedor1.setNome("Estrela");
		fornecedor1.setTelefone("11 96578-5768");
		fornecedor1.setContato("contato@esttrela.com.br");
		daoFornecedor.saveOrUpdate(fornecedor1);
		
		fornecedor2.setNome("Smart");
		fornecedor2.setTelefone("11 93455-3344");
		fornecedor2.setContato("contato@smart.com.br");
		daoFornecedor2.saveOrUpdate(fornecedor2);
		
		Fornecedor_Has_Produto fornecedorhas1 = new Fornecedor_Has_Produto();
		Fornecedor_Has_Produto fornecedorhas2 = new Fornecedor_Has_Produto();
		
		GenericDao<Fornecedor_Has_Produto> daoFornecedorhas = new GenericDao<Fornecedor_Has_Produto>();		
		GenericDao<Fornecedor_Has_Produto> daoFornecedorhas2 = new GenericDao<Fornecedor_Has_Produto>();	
		
		fornecedorhas1.setEstoque(400);
		fornecedorhas1.setFornecedor_id(fornecedor1);
		fornecedorhas1.setPreco_custo(1000.00);
		fornecedorhas1.setProduto_id(produto1);
		daoFornecedorhas.saveOrUpdate(fornecedorhas1);
		
		fornecedorhas2.setEstoque(120);
		fornecedorhas2.setFornecedor_id(fornecedor2);
		fornecedorhas2.setPreco_custo(1600.00);
		fornecedorhas2.setProduto_id(produto2);
		daoFornecedorhas2.saveOrUpdate(fornecedorhas2);
		
		Venda_Itens vendaItens1 = new Venda_Itens();
		Venda_Itens vendaItens2 = new Venda_Itens();
		
		GenericDao<Venda_Itens> daoItens = new GenericDao<Venda_Itens>();
		GenericDao<Venda_Itens> daoItens2 = new GenericDao<Venda_Itens>();
		
		vendaItens1.setQuantidade(3);
		vendaItens1.setVenda_id(venda1);
		vendaItens1.setProduto_id(produto1);
		vendaItens1.setPreco_unit(2000.00);
		vendaItens1.setPreco_custo(fornecedorhas1.getPreco_custo());
		estoqueAtual = fornecedorhas1.getEstoque();
		
		try {
			if (estoqueAtual< vendaItens1.getQuantidade()) {
				
				System.out.println("Quantidade insuficiente!" + "Quantidade disponivel: " + fornecedorhas1.getEstoque());
				
				
			}else {
				daoItens.saveOrUpdate(vendaItens1);
				fornecedorhas1.setEstoque(estoqueAtual - vendaItens1.getQuantidade());
				daoFornecedorhas.saveOrUpdate(fornecedorhas1);
				estoqueAtual = 0;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		vendaItens2.setQuantidade(6);
		vendaItens2.setVenda_id(venda1);
		vendaItens2.setProduto_id(produto2);
		vendaItens2.setPreco_unit(2050.00);
		vendaItens2.setPreco_custo(fornecedorhas2.getPreco_custo());
		estoqueAtual = fornecedorhas2.getEstoque();
		
		try {
			if (estoqueAtual< vendaItens2.getQuantidade()) {
				
				System.out.println("Quantidade insuficiente!" + "Quantidade disponivel: " + fornecedorhas2.getEstoque());
				
			}else {
				daoItens2.saveOrUpdate(vendaItens2);
				fornecedorhas2.setEstoque(estoqueAtual - vendaItens2.getQuantidade());
				daoFornecedorhas2.saveOrUpdate(fornecedorhas2);
				estoqueAtual = 0;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Produto1: " + produto1);
		System.out.println("Produto1: " + produto2);
		System.out.println("Fornecedor1: " + fornecedor1);
		System.out.println("Fornecedor2: " + fornecedor2);
		System.out.println("Fornecedor2: " + fornecedorhas1);
		System.out.println("Fornecedor2: " + fornecedorhas2);
		System.out.println("VendaItens1: " + vendaItens1);
		System.out.println("VendaItens1: " + vendaItens2);
		System.out.println("Venda1: " + venda1);
		
		System.out.println("Acabou !!");
	}
}