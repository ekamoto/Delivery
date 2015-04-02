package controller;

import java.util.List;

import dao.ClienteDao;
import model.ClienteModel;

public class ClienteController {

	private ClienteDao dao = new ClienteDao();

	public ClienteController() {

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
