package model;

public class ProdutoModel {

	private int id;
	private String nome;
	private String descricao;
	private int quantidade;
	private double valor;
	private boolean ativo;
	
	public ProdutoModel() {
		super();
	}
	
	public boolean isAtivo() {
		
		return ativo;
	}

	public boolean getAtivo() {
		
		return this.ativo;
	}
	
	public void setAtivo(boolean ativo) {
		
		this.ativo = ativo;
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
	
	public String toString() {
		return this.nome;
	}
}
