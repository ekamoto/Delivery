package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.ProdutoController;
import model.ProdutoModel;

public class JanelaListarProduto extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel painelFundo;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private DefaultTableModel modelo = new DefaultTableModel();
	private ProdutoController produtoController = new ProdutoController();
	
	public JanelaListarProduto () {
		
		super("Lista de Produtos");
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
		modelo.addColumn("Nome");
		modelo.addColumn("Descricao");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Valor Total");
		modelo.addColumn("Fabricante");
		modelo.addColumn("Status");
		
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		pesquisar(modelo);
	}
	
	public void pesquisar(DefaultTableModel modelo) {
		
		modelo.setNumRows(0);
		
		for(ProdutoModel p: listarProdutos()) {

			modelo.addRow(new Object[] {p.getId(), p.getNome(), p.getDescricao(), p.getQuantidade(), p.getValor(),p.getFabricante(),p.getStatusDescricao()});
		}
	}
	
	public List<ProdutoModel> listarProdutos() {
		
		return produtoController.getProdutos();
	}
}
