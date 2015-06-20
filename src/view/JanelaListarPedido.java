package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.PedidoController;
import controller.ItensPedidoController;
import controller.ProdutoController;
import dao.ItensPedidoDao;


import main.Delivery;
import model.ClienteModel;
import model.EntregadorModel;
import model.ItensPedidoModel;
import model.PedidoModel;
import model.ProdutoModel;

public class JanelaListarPedido extends JFrame implements ActionListener{
	private JPanel painelFundo;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JMenuBar menuBar;
	private JMenu menu, submenu;
	private JMenuItem menuItemCancelar, menuItemFinalizar, listarPedidoFinalizado, 
	listarPedidoAtivo, listarPedidoCancelado;
	private PedidoController pedidoController = new PedidoController();

	public JanelaListarPedido() {
		
		super("Lista de Pedidos");
		criaJTable();
		criaJanela();
	}

	public void criaJanela() {
		
		painelFundo = new JPanel();
		barraRolagem = new JScrollPane(tabela);
		menuBar = new JMenuBar();
		menu = new JMenu("Opções");
		submenu = new JMenu("Ver Pedidos");
		menuItemCancelar = new JMenuItem("Cancelar");
		menuItemFinalizar = new JMenuItem("Finalizar Pedido");
		listarPedidoFinalizado = new JMenuItem("Listar Pedidos Finalizados");
		listarPedidoCancelado = new JMenuItem("Listar Pedidos Cancelado");
		listarPedidoAtivo = new JMenuItem("Listar Pedidos Ativos");
		menuBar.add(menu);
		menu.add(menuItemCancelar);
		menu.add(menuItemFinalizar);
		menu.addSeparator();
		menu.add(submenu);
		submenu.add(listarPedidoAtivo);
		submenu.add(listarPedidoFinalizado);
		submenu.add(listarPedidoCancelado);
		
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.NORTH, menuBar);
		painelFundo.add(BorderLayout.CENTER, barraRolagem);
		getContentPane().add(painelFundo);
		setSize(700, 320);
		setVisible(true);
		menuItemCancelar.addActionListener(this);
		menuItemFinalizar.addActionListener(this);
		listarPedidoFinalizado.addActionListener(this);
		listarPedidoCancelado.addActionListener(this);
		listarPedidoAtivo.addActionListener(this);
	}

	public void criaJTable() {
		
		tabela = new JTable(modelo);
		modelo.addColumn("Codigo");
		modelo.addColumn("Cliente");
		modelo.addColumn("Atendente");
		modelo.addColumn("Valor do Pedido");
		modelo.addColumn("Valor do Pagamento");
		modelo.addColumn("Troco");
		modelo.addColumn("Entregador");
		modelo.addColumn("Forma de Pagamento");
		modelo.addColumn("Itens");
		modelo.addColumn("Status");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(5);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
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
		
		if(e.getSource() == menuItemCancelar) {
			
			String idPedido = JOptionPane.showInputDialog("Digite o Codigo do Pedido que deseja Cancelar:");
			
			boolean res = pedidoController.cancelarPedido(Integer.parseInt(idPedido));
			
			if(res) {
				
				JOptionPane.showMessageDialog(null, "Pedido desativado com sucesso!");	
			} else {
				
				JOptionPane.showMessageDialog(null, "Falha ao desativar pedido!");
			}
			
			dispose();
		} else if(e.getSource() == menuItemFinalizar) {
			String idPedido = JOptionPane.showInputDialog("Digite o Codigo do Pedido que deseja Finalizar:");
			boolean res = pedidoController.finalizarPedido(Integer.parseInt(idPedido));
			
			if(res) {
				JOptionPane.showMessageDialog(null, "Pedido finalizado com sucesso!");
			} else  {
				JOptionPane.showMessageDialog(null, "Falha ao finalizar pedido!");
			}
			dispose();
		} else if(e.getSource() == listarPedidoFinalizado) {
			JanelaListarPedidoFinalizado jlpf = new JanelaListarPedidoFinalizado();
		} else if(e.getSource() == listarPedidoCancelado) {
			JanelaListarPedidoCancelado jlpc = new JanelaListarPedidoCancelado();
		} else if(e.getSource() == listarPedidoAtivo) {
			JanelaListarPedidoAberto jlpa = new JanelaListarPedidoAberto();
		}
		
	}
	
	public void remove() {
		
//		String remover = JOptionPane
//				.showInputDialog("Digite o Codigo do Pedido que deseja excluir:");
//		for (int i = 0; i < Delivery.listaDePedidos.size(); i++) {
//			if (Delivery.listaDePedidos.get(i).getCodigo().equals(remover)) {
//				remover += Delivery.listaDePedidos.remove(i);
//			}
//		}
	
	}
	
	public String getProdutos(PedidoModel pedidoModel) {
		
		ItensPedidoDao pedidoDao = new ItensPedidoDao();
		List<ItensPedidoModel> itensPedido = new ArrayList<ItensPedidoModel>();
		
		itensPedido = pedidoDao.getItensPedido(pedidoModel.getId());
		
		ProdutoController produtoController = new ProdutoController();
		
		int idProduto;
		
		String produtos = "";
		
		for(int i = 0 ; i < itensPedido.size() ; i++) {
			
			idProduto = itensPedido.get(i).getIdProduto();
			ProdutoModel produtoModel = produtoController.getProdutoID(idProduto);
			
			produtos += itensPedido.get(i).getQuantidade() + "-" + produtoModel.getNome() + " ";
			
		}
		
		return produtos;
		
	}
	
	public void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);

		for (PedidoModel p : listarPedidos()) {
			
			modelo.addRow(new Object[] {p.getId(), p.getCliente().getNome(), p.getAtendente().getNome(), p.getValorPedido(), 
					p.getValorPagamento(), p.getValorTroco(), p.getEntregador().getNome(), 
					p.getFormaPagamento().getTipo(), 
					getProdutos(p), p.getStatusDescricao()});
		}
	}

	public List<PedidoModel> listarPedidos() {

		return pedidoController.getPedidos();

	}
}