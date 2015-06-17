package main;
import java.util.ArrayList;
import java.util.List;

import model.AtendenteModel;
import model.CategoriaModel;
import model.ClienteModel;
import model.EntregadorModel;
import model.PedidoModel;
import model.ProdutoModel;
import view.JanelaLogin;


public class Delivery {

	static public List<ClienteModel> listaDeCliente;
	static public List<ProdutoModel> listaDeProdutos;
	static public List<ProdutoModel> listaProdSelec;
	static public List<EntregadorModel> listaDeEntregador;
	static public List<AtendenteModel> listaDeAtendente;
	static public List<PedidoModel> listaDePedidos;
	static public List<CategoriaModel> listaDeCategorias;
	
	public static void main(String[] args) {
		
		listaDeCliente = new ArrayList<ClienteModel>();
		listaDeEntregador = new ArrayList<EntregadorModel>();
		listaDeProdutos = new ArrayList<ProdutoModel>();
		listaDePedidos = new ArrayList<PedidoModel>();
		listaProdSelec = new ArrayList<ProdutoModel>();
		listaDeCategorias = new ArrayList<CategoriaModel>();
		listaDeAtendente = new ArrayList<AtendenteModel>();
		
		// JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
		JanelaLogin.start();

	}
}