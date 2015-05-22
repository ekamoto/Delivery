package controller;

import java.util.List;

import model.ItensPedidoModel;
import model.ProdutoModel;
import dao.ItensPedidoDao;
import dao.ProdutoDao;

public class ItensPedidoController {
	
	private ItensPedidoDao dao = new ItensPedidoDao();

	public ItensPedidoController() {

	}

	public boolean cadastrarProduto(ItensPedidoModel itemPedido) {

		return dao.cadastrar(itemPedido);
	}

	public List<ItensPedidoModel> getItensPedido(int idPedido) {

		return dao.getItensPedido(idPedido);
	}

//	public ProdutoModel getProdutoID(int idProduto) {
//
//		return dao.getProdutoID(idProduto);
//	}
//
//	public boolean deletarCliente(int idCliente) {
//
//		return dao.deletarCliente(idCliente);
//	}
//	
//	public boolean desativarProduto(int idProduto) {
//		
//		return dao.desativarProduto(idProduto);
//	}
//	
//	public boolean ativarProduto(int idProduto) {
//		
//		return dao.ativarProduto(idProduto);
//	}
}
