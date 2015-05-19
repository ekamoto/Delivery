package view;

import java.awt.Container;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import controller.ClienteController;
import controller.PedidoController;
import controller.ProdutoController;


import main.Delivery;
import model.ClienteModel;
import model.EntregadorModel;
import model.PedidoModel;
import model.ProdutoModel;

public class JanelaNovoPedido extends JFrame implements ActionListener {

	private JComboBox comboCliente, comboEntregador;
	private JLabel labelCliente, labelEntregador, labelProduto;
	private Container container;
	private List<ClienteModel> listaCliente;
	private List<EntregadorModel> listaEntregador;
	private List<ProdutoModel> listProd = new ArrayList<ProdutoModel>();
	private List<ProdutoModel> prodSel = new ArrayList<ProdutoModel>();

	private JTextField tfCodigo;
	private JLabel lbCodigo;
	
	private JTextField tfPagamento;
	private JLabel lbPagamento;

	private JTextField tfValorPedido;
	private JLabel lbValorTotal;

	private JButton btnConfirmar;
	private JButton btnListar;
	private JButton btnAdd;
	private JButton btFechar = new JButton("Fechar");

	private JList listaDeProduto;
	private DefaultListModel listModel = new DefaultListModel();
	private ScrollPane scroll;
	
	private SpringLayout layout = new SpringLayout();
	
	private ClienteController clienteController = new ClienteController();
	private ProdutoController produtoController = new ProdutoController();
	private PedidoController pedidoController = new PedidoController();

	public JanelaNovoPedido() {

		// Lista de Cliente
		labelCliente = new JLabel("Cliente");
		comboCliente = new JComboBox();
		listaCliente = listarClientes();
		for (ClienteModel cliente : listaCliente) {
			comboCliente.addItem(cliente);
		}

		// Lista de Entregador
		labelEntregador = new JLabel("Entregador");
		comboEntregador = new JComboBox();
		listaEntregador = listarEntregador();
		for (EntregadorModel entregador : listaEntregador) {
			comboEntregador.addItem(entregador);
		}

		// Lista de Produtos
		listaDeProduto = new JList(listModel);
		listaDeProduto.setVisibleRowCount(3);
		listaDeProduto
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listaDeProduto.setVisible(true);
		scroll = new ScrollPane();
		scroll.add(listaDeProduto);
		listProd = listarProduto();
		for (ProdutoModel produto : listProd) {
			listModel.addElement(produto);
		}

		tfCodigo = new JTextField(4);
		lbCodigo = new JLabel("Codigo");
		tfPagamento = new JTextField(5);
		lbPagamento = new JLabel("Pagamento");
		tfValorPedido = new JTextField(5);
		tfValorPedido.setEditable(false);
		lbValorTotal = new JLabel("Total");
		btnConfirmar = new JButton("Confirmar");
		btnListar = new JButton("Ver Pedidos");
		btnAdd = new JButton("Adicionar");
		labelProduto = new JLabel("Produto");
	
		container = this.getContentPane();
		container.setLayout(layout);
		
		container.add(lbCodigo);
		layout.putConstraint(SpringLayout.WEST, lbCodigo, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbCodigo, 5, SpringLayout.NORTH, container);
		container.add(tfCodigo);
		layout.putConstraint(SpringLayout.WEST, tfCodigo, 70, SpringLayout.WEST, lbCodigo);
		layout.putConstraint(SpringLayout.NORTH, tfCodigo, 5, SpringLayout.NORTH, container);
		container.add(labelCliente);
		layout.putConstraint(SpringLayout.WEST, labelCliente, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, labelCliente, 30, SpringLayout.NORTH, container);
		container.add(comboCliente);
		layout.putConstraint(SpringLayout.WEST, comboCliente, 70, SpringLayout.WEST, labelCliente);
		layout.putConstraint(SpringLayout.NORTH, comboCliente, 30, SpringLayout.NORTH, container);
		container.add(labelProduto);
		layout.putConstraint(SpringLayout.WEST, labelProduto, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, labelProduto, 60, SpringLayout.NORTH, container);
		container.add(scroll);
		layout.putConstraint(SpringLayout.WEST, scroll, 70, SpringLayout.WEST, labelProduto);
		layout.putConstraint(SpringLayout.NORTH, scroll, 60, SpringLayout.NORTH, container);
		container.add(btnAdd);
		layout.putConstraint(SpringLayout.WEST, btnAdd, 200, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btnAdd, 90, SpringLayout.NORTH, container);
		
		container.add(lbValorTotal);
		layout.putConstraint(SpringLayout.WEST, lbValorTotal, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbValorTotal, 175, SpringLayout.NORTH, container);
		container.add(tfValorPedido);
		layout.putConstraint(SpringLayout.WEST, tfValorPedido, 70, SpringLayout.WEST, lbValorTotal);
		layout.putConstraint(SpringLayout.NORTH, tfValorPedido, 175, SpringLayout.NORTH, container);
		container.add(lbPagamento);
		layout.putConstraint(SpringLayout.WEST, lbPagamento, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbPagamento, 200, SpringLayout.NORTH, container);
		container.add(tfPagamento);
		layout.putConstraint(SpringLayout.WEST, tfPagamento, 70, SpringLayout.WEST, lbPagamento);
		layout.putConstraint(SpringLayout.NORTH, tfPagamento, 200, SpringLayout.NORTH, container);
		container.add(labelEntregador);
		layout.putConstraint(SpringLayout.WEST, labelEntregador, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, labelEntregador, 225, SpringLayout.NORTH, container);
		container.add(comboEntregador);
		layout.putConstraint(SpringLayout.WEST, comboEntregador, 70, SpringLayout.WEST, labelEntregador);
		layout.putConstraint(SpringLayout.NORTH, comboEntregador, 225, SpringLayout.NORTH, container);
		container.add(btnListar);
		layout.putConstraint(SpringLayout.WEST, btnListar, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btnListar, 260, SpringLayout.NORTH, container);
		container.add(btnConfirmar);
		layout.putConstraint(SpringLayout.WEST, btnConfirmar, 150, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btnConfirmar, 260, SpringLayout.NORTH, container);
		container.add(btFechar);
		layout.putConstraint(SpringLayout.WEST, btFechar, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btFechar, 320, SpringLayout.NORTH, container);
	
		btnConfirmar.addActionListener(this);
		btnListar.addActionListener(this);
		btnAdd.addActionListener(this);
		btFechar.addActionListener(this);
		/**** LAYOUT ****/

		this.pack();
		this.setResizable(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setTitle("Novo Pedido");
		this.setSize(320,400);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {

			prodSel.add((ProdutoModel) listaDeProduto.getSelectedValue());
			
			tfValorPedido.setText(valorTotal());
		} 
		else if (e.getSource() == btnConfirmar) {
			
			
			PedidoModel pedido = new PedidoModel();
			ClienteModel selecionaCliente = (ClienteModel) comboCliente.getSelectedItem();
			pedido.setId(Integer.parseInt(tfCodigo.getText()));
			EntregadorModel selecionaEntregador = (EntregadorModel) comboEntregador
					.getSelectedItem();

			pedido.setCliente(selecionaCliente);
			pedido.setValorPedido(Double.parseDouble(valorTotal()));
			pedido.setValorPagamento(Double.parseDouble(tfPagamento.getText()));
			pedido.setValorTroco(Double.parseDouble(pedido.valorTroco()));
			pedido.setEntregador(selecionaEntregador);
			
			
			// ItensPedido
			pedido.setListaProduto(prodSel);
			
			
			pedidoController.cadastrarPedido(pedido);
			
			//Delivery.listaDePedidos.add(pedido);
			
			JOptionPane.showMessageDialog(null,
					"Cadastro Realizado com sucesso");
			dispose();
			JanelaNovoPedido jnp = new JanelaNovoPedido();
		} else if (e.getSource() == btnListar) {
			JanelaListarPedido j = new JanelaListarPedido();
		} else if(e.getSource() == btFechar) {
			dispose();
		}
		
	}

	public List<ClienteModel> listarClientes() {

		return clienteController.getClientes();
	}

	public List<EntregadorModel> listarEntregador() {
		List<EntregadorModel> resultado = new ArrayList<EntregadorModel>();

		for (int i = 0; i < Delivery.listaDeEntregador.size(); i++) {
			EntregadorModel temp = new EntregadorModel();
			temp.setId(Delivery.listaDeEntregador.get(i).getId());
			temp.setCpf(Delivery.listaDeEntregador.get(i).getCpf());
			temp.setNome(Delivery.listaDeEntregador.get(i).getNome());
			temp.setEndereco(Delivery.listaDeEntregador.get(i).getEndereco());
			temp.setCarteiraDeTrabalho(Delivery.listaDeEntregador.get(i)
					.getCarteiraDeTrabalho());
			resultado.add(temp);
		}
		return resultado;
	}

	public List<ProdutoModel> listarProduto() {
		
		return produtoController.getProdutos();
	}

	private String valorTotal() {

		double resultado = 0;
		String result;

		for (int i = 0; i < prodSel.size(); i++) {
			resultado = resultado
					+ prodSel.get(i).getValor();
		}

		result = String.valueOf(resultado);
		return result;
	}
	

}
