package model;

public class EntregadorModel extends PessoaModel {

	private String carteiraDeTrabalho;
	
	public EntregadorModel() {
		super();
	}

	// Getters and Setters
	public String getCarteiraDeTrabalho() {
		return carteiraDeTrabalho;
	}

	public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
		this.carteiraDeTrabalho = carteiraDeTrabalho;
	}

}
