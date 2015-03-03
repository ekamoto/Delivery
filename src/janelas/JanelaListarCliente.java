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

public class JanelaListarCliente extends JFrame {
	
	private JPanel painelFundo;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private DefaultTableModel modelo = new DefaultTableModel();
	
	public JanelaListarCliente () {
		super("Lista de Clientes");
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
		modelo.addColumn("Id");
		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("Endereco");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(4);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(11);
		pesquisar(modelo);
	}
	
	public void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		
		for(Cliente c: listarClientes()) {
			modelo.addRow(new Object[] {c.getId(), c.getNome(), c.getCpf(), c.getEndereco()});
		}
	}
	
	public List<Cliente> listarClientes() {
		List<Cliente> resultado = new ArrayList<Cliente>();
		
		for (int i = 0; i < Delivery.listaDeCliente.size(); i++) {
			Cliente temp = new Cliente();
			temp.setId(Delivery.listaDeCliente.get(i).getId());
			temp.setNome(Delivery.listaDeCliente.get(i).getNome());
			temp.setCpf(Delivery.listaDeCliente.get(i).getCpf());
			temp.setEndereco(Delivery.listaDeCliente.get(i).getEndereco());
			resultado.add(temp);
		}
		return resultado;
	}

}