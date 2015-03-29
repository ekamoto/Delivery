package main;
import view.JanelaPrincipal;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Entregador;
import model.Pedido;
import model.Produto;


public class Delivery {

	static public List<Cliente> listaDeCliente;
	static public List<Produto> listaDeProdutos;
	static public List<Produto> listaProdSelec;
	static public List<Entregador> listaDeEntregador;
	static public List<Pedido> listaDePedidos;
	
	public static void main(String[] args) {
		listaDeCliente = new ArrayList<Cliente>();
		listaDeEntregador = new ArrayList<Entregador>();
		listaDeProdutos = new ArrayList<Produto>();
		listaDePedidos = new ArrayList<Pedido>();
		listaProdSelec = new ArrayList<Produto>();
		
		JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
	}

}
