package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ItensPedidoModel;
import model.PedidoModel;
import model.ProdutoModel;
import controller.PedidoController;
import controller.ProdutoController;
import dao.ItensPedidoDao;
import enums.EnumStatusPedido;

public class JanelaListarPedidoAberto extends JFrame{

	private JPanel painelFundo;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private DefaultTableModel modelo = new DefaultTableModel();
	private PedidoController pedidoController = new PedidoController();
	
	public JanelaListarPedidoAberto() {
		
		super("Lista de Pedidos");
		criaJTable();
		criaJanela();
	}
	
	public void criaJanela() {
		
		painelFundo = new JPanel();
		barraRolagem = new JScrollPane(tabela);
		
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);
		getContentPane().add(painelFundo);
		setSize(700, 320);
		setVisible(true);
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
			if(p.getStatus() == EnumStatusPedido.ADICIONADO.getStatus()) {
				modelo.addRow(new Object[] {p.getId(), p.getCliente().getNome(), p.getAtendente().getNome(), p.getValorPedido(), 
					p.getValorPagamento(), p.getValorTroco(), p.getEntregador().getNome(), 
					p.getFormaPagamento().getTipo(), 
					getProdutos(p), p.getStatusDescricao()});
		
			}
		}
	}

	public List<PedidoModel> listarPedidos() {

		return pedidoController.getPedidos();

	}
}
