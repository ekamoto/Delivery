package controller;

import java.util.List;

import model.EntregadorModel;
import dao.EntregadorDao;

public class EntregadorController {

	private EntregadorDao dao = new EntregadorDao();
	
	public EntregadorController() {
		
	}
	
	public boolean cadastrarEntregador(EntregadorModel entregador) {
		return dao.cadastrar(entregador);
	}
	
	public List<EntregadorModel> getEntregador() {
		return dao.getEntregador();
	}
	
	public EntregadorModel getEntregadorId(int idEntregador) {
		return dao.getEntregadorId(idEntregador);
	}
	
	public boolean deletarEntregador(int idEntregador) {
		return dao.deletarEntregador(idEntregador);
	}
}
