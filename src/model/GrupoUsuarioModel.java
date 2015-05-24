package model;

public class GrupoUsuarioModel {

	private int id;
	private String descricao;
	
	public GrupoUsuarioModel() {
		
		super();
	}
	
	public int getId() {
		
		return id;
	}
	
	public void setId(int id) {
		
		this.id = id;
	}
	
	public String getDescricao() {
		
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		
		this.descricao = descricao;
	}
	
	public String toString() {
		
		return this.descricao;
	}
}