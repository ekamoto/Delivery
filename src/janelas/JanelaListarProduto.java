package janelas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.Delivery;
import classes.Cliente;
import classes.Produto;

public class JanelaListarProduto extends JFrame{

	private JPanel painelFundo;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private DefaultTableModel modelo = new DefaultTableModel();
	
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
		
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		pesquisar(modelo);
	}
	
	public void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		List<Produto> listaProduto = new ArrayList<Produto>();
		
		for(Produto p: listarProdutos()) {
			modelo.addRow(new Object[] {p.getCodigo(), p.getNome(), p.getDescricao(), p.getQuantidade(), p.getValor()});
		}
	}
	
	public List<Produto> listarProdutos() {
		List<Produto> resultado = new ArrayList();

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
}
