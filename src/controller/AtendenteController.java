package controller;

import java.util.List;

import model.AtendenteModel;
import dao.AtendenteDao;

public class AtendenteController {
	
	private AtendenteDao dao = new AtendenteDao();
	
	public AtendenteController() {
		
	}
	
	public boolean cadastrarAtendente(AtendenteModel atendente) {
		return dao.cadastrar(atendente);
	}
	
	public List<AtendenteModel> getAtendentes() {
		return dao.getAtendentes();
	}

	public AtendenteModel getAtendenteId(int idAtendente) {
		return dao.getAtendenteId(idAtendente);
	}
	
	public boolean deletarAtendente(int idAtendente) {
		return dao.deletarAtendente(idAtendente);
	}
}
