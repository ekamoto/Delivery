package controller;

import java.util.List;

import model.GrupoUsuarioModel;
import dao.GrupoUsuarioDao;

public class GrupoUsuarioController {
	
	private GrupoUsuarioDao dao = new GrupoUsuarioDao();

	public GrupoUsuarioController() {

	}
	
	/*
	public boolean cadastrarCliente(ClienteModel cliente) {

		return dao.cadastrar(cliente);
	}
	*/

	public List<GrupoUsuarioModel> getGrupoUsuarios() {

		return dao.getGrupoUsuarios();
	}

	/*
	public ClienteModel getClienteID(int idCliente) {

		return dao.getClienteID(idCliente);
	}

	public boolean deletarCliente(int idCliente) {

		return dao.deletarCliente(idCliente);
	}
	*/
}
