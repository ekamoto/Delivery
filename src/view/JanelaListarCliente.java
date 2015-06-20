package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;

import main.Delivery;
import model.ClienteModel;
import model.ProdutoModel;

public class JanelaListarCliente extends JFrame {

	private JPanel painelFundo;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private DefaultTableModel modelo = new DefaultTableModel();
	private ClienteController controller = new ClienteController();

	public JanelaListarCliente() {
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
		modelo.addColumn("Celular");
		modelo.addColumn("Telefone");
		modelo.addColumn("Grupo");
		modelo.addColumn("Status");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(4);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(11);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(11);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(11);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(11);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(11);
		
		pesquisar(modelo);
	}

	public void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);

		List<ClienteModel> clientes = new ArrayList<ClienteModel>();
		clientes = controller.getClientes();

		for (ClienteModel c : clientes) {

			modelo.addRow(new Object[] { c.getId(), c.getNome(), c.getCpf(),
					c.getEndereco(), c.getCelular(), c.getTelefone(),
					c.getGrupoUsuarioModel().getDescricao(), c.getStatusDescricao() });
		}
	}
}