package janelas;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.xml.ws.handler.MessageContext.Scope;

import main.Delivery;
import classes.Cliente;
import classes.Entregador;
import classes.Pedido;
import classes.Produto;

public class JanelaNovoPedido extends JFrame implements ActionListener {

	private JComboBox comboCliente, comboEntregador;
	private JLabel labelCliente, labelEntregador, labelProduto;
	private Container container;
	private List<Cliente> listaCliente;
	private List<Entregador> listaEntregador;
	private List<Produto> listProd = new ArrayList<Produto>();
	private List<Produto> prodSel = new ArrayList<Produto>();

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

	public JanelaNovoPedido() {

		// Lista de Cliente
		labelCliente = new JLabel("Cliente");
		comboCliente = new JComboBox();
		listaCliente = listarClientes();
		for (Cliente cliente : listaCliente) {
			comboCliente.addItem(cliente);
		}

		// Lista de Entregador
		labelEntregador = new JLabel("Entregador");
		comboEntregador = new JComboBox();
		listaEntregador = listarEntregador();
		for (Entregador entregador : listaEntregador) {
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
		for (Produto produto : listProd) {
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

			prodSel.add((Produto) listaDeProduto.getSelectedValue());
			
			tfValorPedido.setText(valorTotal());
		} 
		else if (e.getSource() == btnConfirmar) {
			Pedido pedido = new Pedido();
			Cliente selecionaCliente = (Cliente) comboCliente.getSelectedItem();
			pedido.setCodigo(tfCodigo.getText());
			Entregador selecionaEntregador = (Entregador) comboEntregador
					.getSelectedItem();

			pedido.setCliente(selecionaCliente);
			pedido.setListaProduto(prodSel);
			pedido.setValorPedido(valorTotal());
			pedido.setValorPagamento(tfPagamento.getText());
			pedido.setValorTroco(pedido.valorTroco());
			pedido.setEntregador(selecionaEntregador);
			Delivery.listaDePedidos.add(pedido);
			
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

	public List<Cliente> listarClientes() {
		List<Cliente> resultado = new ArrayList<Cliente>();

		for (int i = 0; i < Delivery.listaDeCliente.size(); i++) {
			Cliente temp = new Cliente();
			temp.setId(Delivery.listaDeCliente.get(i).getId());
			temp.setCpf(Delivery.listaDeCliente.get(i).getCpf());
			temp.setNome(Delivery.listaDeCliente.get(i).getNome());
			temp.setEndereco(Delivery.listaDeCliente.get(i).getEndereco());
			resultado.add(temp);
		}
		return resultado;
	}

	public List<Entregador> listarEntregador() {
		List<Entregador> resultado = new ArrayList<Entregador>();

		for (int i = 0; i < Delivery.listaDeEntregador.size(); i++) {
			Entregador temp = new Entregador();
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

	public List<Produto> listarProduto() {
		List<Produto> resultado = new ArrayList<Produto>();

		for (int i = 0; i < Delivery.listaDeProdutos.size(); i++) {
			Produto temp = new Produto();
			temp.setCodigo(Delivery.listaDeProdutos.get(i).getCodigo());
			temp.setNome(Delivery.listaDeProdutos.get(i).getNome());
			temp.setDescricao(Delivery.listaDeProdutos.get(i).getDescricao());
			temp.setQuantidade(Delivery.listaDeProdutos.get(i).getQuantidade());
			temp.setValor(Delivery.listaDeProdutos.get(i).getValor());
			resultado.add(temp);
		}
		return resultado;
	}

	private String valorTotal() {

		double resultado = 0;
		String result;

		for (int i = 0; i < prodSel.size(); i++) {
			resultado = resultado
					+ Double.parseDouble(prodSel.get(i).getValor());
		}

		result = String.valueOf(resultado);
		return result;
	}
	

}
