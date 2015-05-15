package controller;

import java.util.List;

import model.ClienteModel;
import dao.ClienteDao;
import dao.ProdutoDao;

public class ProdutoController {
	
	private ProdutoDao dao = new ProdutoDao();

	public ProdutoController() {

	}

	public boolean cadastrarCliente(ClienteModel cliente) {

		return dao.cadastrar(cliente);
	}

	public List<ClienteModel> getClientes() {

		return dao.getClientes();
	}

	public ClienteModel getClienteID(int idCliente) {

		return dao.getClienteID(idCliente);
	}

	public boolean deletarCliente(int idCliente) {

		return dao.deletarCliente(idCliente);
	}
}
