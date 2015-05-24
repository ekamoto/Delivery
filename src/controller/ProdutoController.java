package controller;

import java.util.List;

import model.ProdutoModel;
import dao.ProdutoDao;

public class ProdutoController {
	
	private ProdutoDao dao = new ProdutoDao();

	public ProdutoController() {

	}

	public boolean cadastrarProduto(ProdutoModel produto) {

		return dao.cadastrar(produto);
	}

	public List<ProdutoModel> getProdutos() {

		return dao.getProdutos();
	}

	public ProdutoModel getProdutoID(int idProduto) {

		return dao.getProdutoID(idProduto);
	}

	public boolean deletarCliente(int idCliente) {

		return dao.deletarCliente(idCliente);
	}
	
	public boolean desativarProduto(int idProduto) {
		
		return dao.desativarProduto(idProduto);
	}
	
	public boolean ativarProduto(int idProduto) {
		
		return dao.ativarProduto(idProduto);
	}
	
	public boolean baixaEstoque(int idProduto, int quantidade) {
		
		return dao.baixaEstoque(idProduto, quantidade);
	}
}
