package main;
import view.JanelaLogin;
import view.JanelaPrincipal;

import java.util.ArrayList;
import java.util.List;

import model.CategoriaModel;
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
	static public List<CategoriaModel> listaDeCategorias;
	
	public static void main(String[] args) {
		
		listaDeCliente = new ArrayList<ClienteModel>();
		listaDeEntregador = new ArrayList<EntregadorModel>();
		listaDeProdutos = new ArrayList<ProdutoModel>();
		listaDePedidos = new ArrayList<PedidoModel>();
		listaProdSelec = new ArrayList<ProdutoModel>();
		listaDeCategorias = new ArrayList<CategoriaModel>();
		
		// JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
		JanelaLogin.start();

	}
}