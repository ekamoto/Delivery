package model;

public class PessoaModel {

	private String id;
	private String nome;
	private String cpf;
	private String endereco;
	private int idGrupoUsuario;
	private GrupoUsuarioModel grupoUsuarioModel;
	
	public PessoaModel() {
		super();
	}
	
	public GrupoUsuarioModel getGrupoUsuarioModel() {
		return grupoUsuarioModel;
	}

	public void setGrupoUsuarioModel(GrupoUsuarioModel grupoUsuarioModel) {
		this.grupoUsuarioModel = grupoUsuarioModel;
	}

	public int getIdGrupoUsuario() {
		return idGrupoUsuario;
	}

	public void setIdGrupoUsuario(int idGrupoUsuario) {
		this.idGrupoUsuario = idGrupoUsuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String toString() {
		return this.nome;
	}
	
}
