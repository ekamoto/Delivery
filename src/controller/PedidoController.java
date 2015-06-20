package controller;

import java.util.List;

import model.PedidoModel;
import model.ProdutoModel;
import dao.PedidoDao;

public class PedidoController {
	
	private PedidoDao dao = new PedidoDao();

	public PedidoController() {

	}

	public boolean cadastrarPedido(PedidoModel pedido) {

		return dao.cadastrar(pedido);
	}

	public List<PedidoModel> getPedidos() {

		return dao.getPedidos();
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
	
	public boolean cancelarPedido(int idPedido) {
		return dao.cancelarPedido(idPedido);
	}
	
	public boolean finalizarPedido(int idPedido) {
		return dao.finalizarPedido(idPedido);
	}
}
