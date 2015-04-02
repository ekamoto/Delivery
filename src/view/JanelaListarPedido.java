package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import main.Delivery;
import model.EntregadorModel;
import model.PedidoModel;
import model.ProdutoModel;

public class JanelaListarPedido extends JFrame implements ActionListener{
	private JPanel painelFundo;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItemExcluir;

	public JanelaListarPedido() {
		super("Lista de Pedidos");
		criaJTable();
		criaJanela();
	}

	public void criaJanela() {
		painelFundo = new JPanel();
		barraRolagem = new JScrollPane(tabela);
		menuBar = new JMenuBar();
		menu = new JMenu("Editar");
		menuItemExcluir = new JMenuItem("Excluir");
		menuBar.add(menu);
		menu.add(menuItemExcluir);
		
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.NORTH, menuBar);
		painelFundo.add(BorderLayout.CENTER, barraRolagem);
		getContentPane().add(painelFundo);
		setSize(700, 320);
		setVisible(true);
		menuItemExcluir.addActionListener(this);
	}

	public void criaJTable() {
		tabela = new JTable(modelo);
		modelo.addColumn("Codigo");
		modelo.addColumn("Cliente");
		modelo.addColumn("Valor do Pedido");
		modelo.addColumn("Valor do Pagamento");
		modelo.addColumn("Troco");
		modelo.addColumn("Entregador");
		modelo.addColumn("Itens");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(5);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
		pesquisar(modelo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuItemExcluir) {
			remove();
			JOptionPane.showMessageDialog(null, "Pedido apagado com sucesso!");
			dispose();
		}
		
	}
	
	public void remove() {
		String remover = JOptionPane
				.showInputDialog("Digite o Codigo do Pedido que deseja excluir:");
		for (int i = 0; i < Delivery.listaDePedidos.size(); i++) {
			if (Delivery.listaDePedidos.get(i).getCodigo().equals(remover)) {
				remover += Delivery.listaDePedidos.remove(i);
			}
		}
	
	}
	
	public void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		List<PedidoModel> listaPedido = new ArrayList<PedidoModel>();

		for (PedidoModel p : listarPedidos()) {
			modelo.addRow(new Object[] {p.getCodigo(), p.getCliente(), p.getValorPedido(),
					p.getValorPagamento(), p.getValorTroco(), p.getEntregador(), p.getListaProduto()});
		}
	}

	public List<PedidoModel> listarPedidos() {
		List<PedidoModel> resultado = new ArrayList<PedidoModel>();

		for (int i = 0; i < Delivery.listaDePedidos.size(); i++) {
			PedidoModel temp = new PedidoModel();
			temp.setCodigo(Delivery.listaDePedidos.get(i).getCodigo());
			temp.setCliente(Delivery.listaDePedidos.get(i).getCliente());
			temp.setValorPedido(Delivery.listaDePedidos.get(i).getValorPedido());
			temp.setValorPagamento(Delivery.listaDePedidos.get(i).getValorPagamento());
			temp.setValorTroco(Delivery.listaDePedidos.get(i).getValorTroco());
			temp.setEntregador(Delivery.listaDePedidos.get(i).getEntregador());
			temp.setListaProduto(Delivery.listaDePedidos.get(i).getListaProduto());
			resultado.add(temp);
		}
		return resultado;

	}

}
