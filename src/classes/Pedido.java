package classes;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private String codigo;
	private Cliente cliente;
	private List<Produto> listaProduto = new ArrayList<Produto>();
	private String valorPedido;
	private String valorPagamento;
	private String valorTroco;
	private Entregador entregador;
	
	public Pedido() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public String getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(String valorPedido) {
		this.valorPedido = valorPedido;
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}
	
	public String getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(String valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public String getValorTroco() {
		return valorTroco;
	}

	public void setValorTroco(String valorTroco) {
		this.valorTroco = valorTroco;
	}
	
	public String valorTroco() {
		
		String result;
		double resultado = 0.0, temp, temp2;
		
		temp = Double.parseDouble(getValorPedido());
		temp2 = Double.parseDouble(getValorPagamento());
		
		try {
			if(temp2 > temp) {
				resultado = temp2 - temp;
			}
			
		}catch (Exception e) {
			e.getStackTrace();
		}
		
		result = String.valueOf(resultado);
		return result;
	}
	
	
}
