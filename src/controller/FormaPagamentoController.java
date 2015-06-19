package controller;

import java.util.List;

import model.FormaPagamentoModel;
import dao.FormaPagamentoDao;

public class FormaPagamentoController {
	
	private FormaPagamentoDao dao = new FormaPagamentoDao();
	
	public FormaPagamentoController() {
		
	}
	
	public List<FormaPagamentoModel> getFormaPagamentos() {
		return dao.getFormaPagamentos();
	}
	
	public FormaPagamentoModel getFormaPagamentoId(int idFormaPagamento) {
		return dao.getFormaPagamentoId(idFormaPagamento);
	}
}
