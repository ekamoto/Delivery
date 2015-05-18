package controller;

import java.util.List;

import model.ClienteModel;
import model.ProdutoModel;
import dao.ClienteDao;
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

	public ClienteModel getClienteID(int idCliente) {

		return new ClienteModel();
	}

	public boolean deletarCliente(int idCliente) {

		return dao.deletarCliente(idCliente);
	}
}
