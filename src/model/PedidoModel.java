package model;

import java.util.ArrayList;
import java.util.List;

public class PedidoModel {

	private int id;
	private ClienteModel cliente;
	private AtendenteModel atendente;
	private List<ProdutoModel> listaProduto = new ArrayList<ProdutoModel>();
	private double valorPedido;
	private double valorPagamento;
	private double valorTroco;
	private EntregadorModel entregador;
	private FormaPagamentoModel formaPagamento;
	private int status;
	
	public PedidoModel() {
		super();
	}

	public int getStatus() {
		return status;
	}
	
	public String getStatusDescricao() {
		
		String descricaoStatus = "";
		
		switch (getStatus()) {
		case 1:
			descricaoStatus = "ADICIONADO";
			break;
		case 2:
			descricaoStatus = "EM_ANDAMENTO";
			break;
		case 3:
			descricaoStatus = "FINALIZADO";
			break;
		case 4:
			descricaoStatus = "CANCELADO";
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

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public AtendenteModel getAtendente() {
		return atendente;
	}

	public void setAtendente(AtendenteModel atendente) {
		this.atendente = atendente;
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

	public FormaPagamentoModel getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoModel formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	
}
