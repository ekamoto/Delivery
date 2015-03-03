package main;
import janelas.JanelaPrincipal;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Cliente;
import classes.Entregador;
import classes.Pedido;
import classes.Pessoa;
import classes.Produto;


public class Delivery {
	
	//static private JanelaPrincipal janelaPrincipal;
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
