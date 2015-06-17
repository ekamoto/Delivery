package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.AtendenteModel;
import model.EntregadorModel;
import controller.AtendenteController;
import controller.EntregadorController;

public class JanelaListarAtendente extends JFrame {
	
	private JPanel painelFundo;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private DefaultTableModel modelo = new DefaultTableModel();
	private AtendenteController controller = new AtendenteController();
	
	public JanelaListarAtendente () {
		super("Lista de Atendentes");
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
		tabela.getColumnModel().getColumn(0).setPreferredWidth(4);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(11);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(11);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(11);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(11);
		
		pesquisar(modelo);
	}
	
	public void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		
		List<AtendenteModel> atendentes = new ArrayList<AtendenteModel>();
		atendentes = controller.getAtendentes();
		
		for(AtendenteModel a: atendentes) {
			modelo.addRow(new Object[] { a.getId(), a.getNome(), a.getCpf(),
					a.getEndereco(), a.getCelular(), a.getTelefone(),
					a.getGrupoUsuarioModel().getDescricao() });
		}
	}

}
