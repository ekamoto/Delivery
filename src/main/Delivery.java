package main;
import view.JanelaPrincipal;

import java.util.ArrayList;
import java.util.List;

import model.ClienteModel;
import model.EntregadorModel;
import model.PedidoModel;
import model.ProdutoModel;


public class Delivery {

	static public List<ClienteModel> listaDeCliente;
	static public List<ProdutoModel> listaDeProdutos;
	static public List<ProdutoModel> listaProdSelec;
	static public List<EntregadorModel> listaDeEntregador;
	static public List<PedidoModel> listaDePedidos;
	
	public static void main(String[] args) {
		listaDeCliente = new ArrayList<ClienteModel>();
		listaDeEntregador = new ArrayList<EntregadorModel>();
		listaDeProdutos = new ArrayList<ProdutoModel>();
		listaDePedidos = new ArrayList<PedidoModel>();
		listaProdSelec = new ArrayList<ProdutoModel>();
		
		JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
	}

}
