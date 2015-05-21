package controller;

import java.util.List;

import model.CategoriaModel;
import dao.CategoriaDao;

public class CategoriaController {
	private CategoriaDao dao = new CategoriaDao();
	
	public CategoriaController() {
		
	}
	
	public boolean cadastrarCategoria(CategoriaModel categoria) {
		return dao.cadastrar(categoria);
	}
	
	public List<CategoriaModel> getCategorias() {
		return dao.getCategorias();
	}
}
