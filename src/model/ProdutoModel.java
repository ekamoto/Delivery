package model;

public class ProdutoModel {

	private int id;
	private String nome;
	private String descricao;
	private String fabricante;
	private CategoriaModel categoria;
	private int quantidade;
	private double valor;
	private int status;
	
	public ProdutoModel() {
		super();
	}

	public int getStatus() {
		return status;
	}
	
	public String getStatusDescricao() {
		
		String descricaoStatus = "";
		
		switch (getStatus()) {
		case 1:
			descricaoStatus = "ATIVO";
			break;
		case 2:
			descricaoStatus = "DESATIVADO";
			break;
		default:
			break;
		}
		
		return descricaoStatus;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String toString() {
		return this.nome;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}
}
