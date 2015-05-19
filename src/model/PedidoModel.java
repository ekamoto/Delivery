package model;

import java.util.ArrayList;
import java.util.List;

public class PedidoModel {

	private int id;
	private ClienteModel cliente;
	private List<ProdutoModel> listaProduto = new ArrayList<ProdutoModel>();
	private double valorPedido;
	private double valorPagamento;
	private double valorTroco;
	private EntregadorModel entregador;
	private boolean ativo;
	
	public PedidoModel() {
		super();
	}

	
	public boolean isAtivo() {
		return ativo;
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

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public List<ProdutoModel> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<ProdutoModel> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public double getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(double valorPedido) {
		this.valorPedido = valorPedido;
	}

	public EntregadorModel getEntregador() {
		return entregador;
	}

	public void setEntregador(EntregadorModel entregador) {
		this.entregador = entregador;
	}
	
	public double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public double getValorTroco() {
		return valorTroco;
	}

	public void setValorTroco(double valorTroco) {
		this.valorTroco = valorTroco;
	}
	
	public String valorTroco() {
		
		String result;
		double resultado = 0.0, temp, temp2;
		
		temp = getValorPedido();
		temp2 = getValorPagamento();
		
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
