package controller;

import dao.ClienteDao;
import model.ClienteModel;

public class ClienteController {
	
	private ClienteDao dao = new ClienteDao();

	public ClienteController() {
		
	}
	
	public boolean cadastrarCliente(ClienteModel cliente) {
		
		return dao.cadastrar(cliente);
	}
}
