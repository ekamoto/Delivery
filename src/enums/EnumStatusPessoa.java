package enums;

public enum EnumStatusPessoa {

	ATIVO(1),
	INATIVO(2);
	
	private Integer status;
	
	private EnumStatusPessoa(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
}
