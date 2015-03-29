package controller;

import dao.DaoCliente;
import model.Cliente;

public class ControllerCliente {
	
	private DaoCliente dao = new DaoCliente();

	public ControllerCliente() {
		
	}
	
	public boolean cadastrarCliente(Cliente cliente) {
		
		return dao.cadastrar(cliente);
	}
}
