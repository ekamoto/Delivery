package enums;

public enum EnumStatusProduto {
	
	ATIVO(1),
	DESATIVADO(2);
	
	private Integer status;
	
	private EnumStatusProduto(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
}
