package model;

public class FormaPagamentoModel {

	private String id;
	private String tipo;
	
	public FormaPagamentoModel() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		
		return this.tipo;
	}
	
}
