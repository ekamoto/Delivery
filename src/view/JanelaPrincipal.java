package view;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.NoSuchPaddingException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import crypt.FileCrypt;

import main.Delivery;
import model.ClienteModel;
import model.EntregadorModel;




public class JanelaPrincipal extends JFrame implements ActionListener{
	
	// Barra
	private JMenuBar barraMenus;
	
	// Atributos do menu
	private JMenu menuPedido;
	private JMenu menuCliente;
	private JMenu menuEntregador;
	private JMenu menuProduto;
	private JMenu menuAtendente;
	private JMenu menuAjuda;
	
	// Itens dos atributos
	private JMenuItem itemNovoPedido;
	private JMenuItem itemNovoCliente;
	private JMenuItem itemNovoProduto;
	private JMenuItem itemNovoEntregador;
	private JMenuItem itemNovoAtendente;
	private JMenuItem itemSobre;
	
	private JMenuItem itemBuscarCliente;
	private JMenuItem itemBuscarProduto;
	private JMenuItem itemBuscarEntregador;
	private JMenuItem itemBuscarAtendente;
	private JMenuItem itemListarCliente;
	private JMenuItem itemListarProduto;
	private JMenuItem itemListarEntregador;
	private JMenuItem itemListarPedido;
	private JMenuItem itemListarAtendente;
	private JMenuItem itemDesativarProduto;
	private JMenuItem itemAtivarProduto;
	private JMenuItem itemDesativarCliente;
	private JMenuItem itemAtivarCliente;
	private JMenuItem itemAtivarEntregador;
	private JMenuItem itemDesativarEntregador;
	private JMenuItem itemAtivarAtendente;
	private JMenuItem itemDesativarAtendente;
	
	// Construtor
	public JanelaPrincipal() {
		
		/* Rotina para gerar arquivo de configuração de banco
		FileCrypt cripto = new FileCrypt("Delivery");  
  	  
        try {
        	// Descomenta e cria o arquivo config2 onde vc coloca
        	//   //servidor:porta/
        	//   usuario
        	//   senha
        	//   banco
			//cripto.criptografa(new FileInputStream("src/conf/config2"), new FileOutputStream("src/conf/config"));
			cripto.descriptografa(new FileInputStream("src/conf/config"), new FileOutputStream("src/conf/config3"));
		} catch (InvalidKeyException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		*/
        
		EntregadorModel entregador = new EntregadorModel();
		entregador.setId("1");
		entregador.setNome("Entregador1");
		entregador.setEndereco("asdfasdf");
		entregador.setCpf("asdfasffsad");
		Delivery.listaDeEntregador.add(entregador);
		
		EntregadorModel entregador2 = new EntregadorModel();
		entregador2.setId("1");
		entregador2.setNome("Entregador2");
		entregador2.setEndereco("asdfasdf");
		entregador2.setCpf("asdfasffsad");
		Delivery.listaDeEntregador.add(entregador2);
		
		barraMenus = new JMenuBar();
		menuPedido = new JMenu("Pedido");
		menuProduto = new JMenu("Produto");
		menuCliente = new JMenu("Cliente");
		menuEntregador = new JMenu("Entregador");
		menuAtendente = new JMenu("Atendente");
		menuAjuda = new JMenu("Ajuda");
		
		itemNovoPedido = new JMenuItem("Novo");
		itemNovoCliente = new JMenuItem("Novo");
		itemNovoProduto = new JMenuItem("Novo");
		itemNovoEntregador = new JMenuItem("Novo");
		itemNovoAtendente = new JMenuItem("Novo");
		itemSobre = new JMenuItem("Sobre");
		
		itemBuscarCliente = new JMenuItem("Buscar");
		itemBuscarProduto = new JMenuItem("Buscar");
		itemBuscarEntregador = new JMenuItem("Buscar");
		itemBuscarAtendente = new JMenuItem("Buscar");
		itemListarCliente = new JMenuItem("Listar");
		itemListarProduto = new JMenuItem("Listar");
		itemListarEntregador = new JMenuItem("Listar");
		itemListarPedido = new JMenuItem("Listar");
		itemListarAtendente = new JMenuItem("Listar");
		itemDesativarProduto = new JMenuItem("Desativar");
		itemAtivarProduto = new JMenuItem("Ativar");
		itemDesativarCliente = new JMenuItem("Desativar");
		itemAtivarCliente = new JMenuItem("Ativar");
		itemAtivarEntregador = new JMenuItem("Ativar");
		itemDesativarEntregador = new JMenuItem("Desativar");
		itemAtivarAtendente = new JMenuItem("Ativar");
		itemDesativarAtendente = new JMenuItem("Desativar");
		
		barraMenus.add(menuPedido);
		barraMenus.add(menuProduto);
		barraMenus.add(menuCliente);
		barraMenus.add(menuEntregador);
		barraMenus.add(menuAtendente);
		barraMenus.add(menuAjuda);
		
		menuPedido.add(itemNovoPedido);
		menuProduto.add(itemNovoProduto);
		menuEntregador.add(itemNovoEntregador);
		menuCliente.add(itemNovoCliente);
		menuAtendente.add(itemNovoAtendente);
		menuAjuda.add(itemSobre);
		
		menuCliente.add(itemBuscarCliente);
		menuProduto.add(itemBuscarProduto);
		menuCliente.add(itemListarCliente);
		menuCliente.add(itemAtivarCliente);
		menuCliente.add(itemDesativarCliente);
		menuProduto.add(itemListarProduto);
		menuEntregador.add(itemBuscarEntregador);
		menuEntregador.add(itemListarEntregador);
		menuEntregador.add(itemAtivarEntregador);
		menuEntregador.add(itemDesativarEntregador);
		menuPedido.add(itemListarPedido);
		menuAtendente.add(itemBuscarAtendente);
		menuAtendente.add(itemListarAtendente);
		menuAtendente.add(itemAtivarAtendente);
		menuAtendente.add(itemDesativarAtendente);
		menuProduto.add(itemDesativarProduto);
		menuProduto.add(itemAtivarProduto);
		
		itemNovoCliente.addActionListener(this);
		itemNovoPedido.addActionListener(this);
		itemNovoProduto.addActionListener(this);
		itemNovoEntregador.addActionListener(this);
		itemNovoAtendente.addActionListener(this);
		itemSobre.addActionListener(this);
		
		itemBuscarCliente.addActionListener(this);
		itemBuscarProduto.addActionListener(this);
		itemBuscarEntregador.addActionListener(this);
		itemBuscarAtendente.addActionListener(this);
		itemListarCliente.addActionListener(this);
		itemListarProduto.addActionListener(this);
		itemListarEntregador.addActionListener(this);
		itemListarPedido.addActionListener(this);
		itemListarAtendente.addActionListener(this);
		itemDesativarProduto.addActionListener(this);
		itemAtivarProduto.addActionListener(this);
		itemDesativarCliente.addActionListener(this);
		itemAtivarCliente.addActionListener(this);
		itemDesativarEntregador.addActionListener(this);
		itemAtivarEntregador.addActionListener(this);
		itemDesativarAtendente.addActionListener(this);
		itemAtivarAtendente.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Finalizar a tela
		this.setLayout(new FlowLayout());
		this.setJMenuBar(barraMenus);
		this.setResizable(true); 
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setVisible(true);
		this.setTitle("Drink Xpress");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== itemNovoCliente) {
			
			JanelaNovoCliente janelaNovoCliente = new JanelaNovoCliente();
		} else if(e.getSource() == itemNovoEntregador) {
			
			JanelaNovoEntregador janelaNovoEntregador = new JanelaNovoEntregador();
		} else if(e.getSource() == itemNovoProduto) {
			
			JanelaNovoProduto janelaNovoProduto = new JanelaNovoProduto();
		} else if(e.getSource() == itemNovoAtendente) {
			JanelaNovoAtendente janelaNovoAtendente = new JanelaNovoAtendente();
		} else if(e.getSource() == itemNovoPedido) {
			
			JanelaNovoPedido janelaNovoPedido = new JanelaNovoPedido();
		} else if(e.getSource() == itemBuscarCliente) {
			
			JanelaBuscarCliente janelaBuscarCliente = new JanelaBuscarCliente();
		} else if(e.getSource() == itemBuscarProduto) {
			
			JanelaBuscarProduto janelaBuscarProduto = new JanelaBuscarProduto();
		} else if(e.getSource() == itemBuscarEntregador) {
			
			JanelaBuscarEntregador janelaBuscarEntregador = new JanelaBuscarEntregador();
		} else if(e.getSource() == itemListarCliente) {
			
			JanelaListarCliente janelaListarCliente = new JanelaListarCliente();
		} else if(e.getSource() == itemListarProduto) {
			
			JanelaListarProduto janelaListarProduto = new JanelaListarProduto();
		} else if(e.getSource() == itemListarEntregador) {
			
			JanelaListarEntregador janelaListarEntregador = new JanelaListarEntregador();
		} else if(e.getSource() == itemListarPedido) {
			
			JanelaListarPedido janelaListarPedido = new JanelaListarPedido();
		}
		else if(e.getSource() == itemSobre) {
			
			JOptionPane.showMessageDialog(null, "Trabalho de APSOO");
		} else if(e.getSource() == itemDesativarProduto) {

			JanelaDesativarProduto jdp = new JanelaDesativarProduto();
		} else if(e.getSource() == itemAtivarProduto) {

			JanelaAtivarProduto jap = new JanelaAtivarProduto();
		} else if(e.getSource() == itemListarAtendente) {
			JanelaListarAtendente janelaListarAtendente = new JanelaListarAtendente();
		} else if(e.getSource() == itemBuscarAtendente) {
			JanelaBuscarAtendente janelaBuscarAtendente = new JanelaBuscarAtendente();
		} else if(e.getSource() == itemDesativarCliente) {
			JanelaDesativarCliente janelaDesativarCliente = new JanelaDesativarCliente();
		} else if(e.getSource() == itemAtivarCliente) {
			JanelaAtivarCliente janelaAtivarCliente = new JanelaAtivarCliente();
		} else if(e.getSource() == itemAtivarEntregador) {
			JanelaAtivarEntregador janelaAtivarEntregador = new JanelaAtivarEntregador();
		} else if(e.getSource() == itemDesativarEntregador) {
			JanelaDesativarEntregador janelaDesativarEntregador = new JanelaDesativarEntregador();
		} else if(e.getSource() == itemAtivarAtendente) {
			JanelaAtivarAtendente janelaAtivarAtendente = new JanelaAtivarAtendente();
		} else if(e.getSource() == itemDesativarAtendente) {
			JanelaDesativarAtendente janelaDesativarAtendente = new JanelaDesativarAtendente();
		}
	}
}