package enums;

public enum EnumStatusPedido {
	
	ADICIONADO(1),
	EM_ANDAMENTO(2),
	FINALIZADO(3),
	CANCELADO(4);
	
	private Integer status;
	
	private EnumStatusPedido(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
}
