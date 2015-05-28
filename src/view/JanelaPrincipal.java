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
	private JMenu menuAjuda;
	
	// Itens dos atributos
	private JMenuItem itemNovoPedido;
	private JMenuItem itemNovoCliente;
	private JMenuItem itemNovoProduto;
	private JMenuItem itemNovoEntregador;
	private JMenuItem itemSobre;
	
	private JMenuItem itemBuscarCliente;
	private JMenuItem itemBuscarProduto;
	private JMenuItem itemBuscarEntregador;
	private JMenuItem itemListarCliente;
	private JMenuItem itemListarProduto;
	private JMenuItem itemListarEntregador;
	private JMenuItem itemListarPedido;
	private JMenuItem itemDesativarProduto;
	private JMenuItem itemAtivarProduto;
	
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
		entregador.setCarteiraDeTrabalho("asdfasdf");
		Delivery.listaDeEntregador.add(entregador);
		
		EntregadorModel entregador2 = new EntregadorModel();
		entregador2.setId("1");
		entregador2.setNome("Entregador2");
		entregador2.setEndereco("asdfasdf");
		entregador2.setCpf("asdfasffsad");
		entregador2.setCarteiraDeTrabalho("asdfasdf");
		Delivery.listaDeEntregador.add(entregador2);
		
		barraMenus = new JMenuBar();
		menuPedido = new JMenu("Pedido");
		menuProduto = new JMenu("Produto");
		menuCliente = new JMenu("Cliente");
		menuEntregador = new JMenu("Entregador");
		menuAjuda = new JMenu("Ajuda");
		
		itemNovoPedido = new JMenuItem("Novo");
		itemNovoCliente = new JMenuItem("Novo");
		itemNovoProduto = new JMenuItem("Novo");
		itemNovoEntregador = new JMenuItem("Novo");
		itemSobre = new JMenuItem("Sobre");
		
		itemBuscarCliente = new JMenuItem("Buscar");
		itemBuscarProduto = new JMenuItem("Buscar");
		itemBuscarEntregador = new JMenuItem("Buscar");
		itemListarCliente = new JMenuItem("Listar");
		itemListarProduto = new JMenuItem("Listar");
		itemListarEntregador = new JMenuItem("Listar");
		itemListarPedido = new JMenuItem("Listar");
		itemDesativarProduto = new JMenuItem("Desativar");
		itemAtivarProduto = new JMenuItem("Ativar");
		
		barraMenus.add(menuPedido);
		barraMenus.add(menuCliente);
		barraMenus.add(menuProduto);
		barraMenus.add(menuEntregador);
		barraMenus.add(menuAjuda);
		
		menuPedido.add(itemNovoPedido);
		menuProduto.add(itemNovoProduto);
		menuEntregador.add(itemNovoEntregador);
		menuCliente.add(itemNovoCliente);
		menuAjuda.add(itemSobre);
		
		menuCliente.add(itemBuscarCliente);
		menuProduto.add(itemBuscarProduto);
		menuEntregador.add(itemBuscarEntregador);
		menuCliente.add(itemListarCliente);
		menuProduto.add(itemListarProduto);
		menuEntregador.add(itemListarEntregador);
		menuPedido.add(itemListarPedido);
		menuProduto.add(itemDesativarProduto);
		menuProduto.add(itemAtivarProduto);
		
		itemNovoCliente.addActionListener(this);
		itemNovoPedido.addActionListener(this);
		itemNovoProduto.addActionListener(this);
		itemNovoEntregador.addActionListener(this);
		itemSobre.addActionListener(this);
		
		itemBuscarCliente.addActionListener(this);
		itemBuscarProduto.addActionListener(this);
		itemBuscarEntregador.addActionListener(this);
		itemListarCliente.addActionListener(this);
		itemListarProduto.addActionListener(this);
		itemListarEntregador.addActionListener(this);
		itemListarPedido.addActionListener(this);
		itemDesativarProduto.addActionListener(this);
		itemAtivarProduto.addActionListener(this);
		
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
		}
	}
}