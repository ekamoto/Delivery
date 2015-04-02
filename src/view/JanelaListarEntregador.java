package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import main.Delivery;
import model.ClienteModel;
import model.EntregadorModel;

public class JanelaListarEntregador  extends JFrame{
	
	private JPanel painelFundo;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private DefaultTableModel modelo = new DefaultTableModel();
	
	public JanelaListarEntregador () {
		super("Lista de Entregadores");
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
		modelo.addColumn("N� Carteira");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(4);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(11);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(11);
		pesquisar(modelo);
	}
	
	public void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		
		for(EntregadorModel e: listarEntregador()) {
			modelo.addRow(new Object[] {e.getId() ,e.getNome(), e.getCpf(), e.getEndereco(), e.getCarteiraDeTrabalho()});
		}
	}
	
	public List<EntregadorModel> listarEntregador() {
		List<EntregadorModel> resultado = new ArrayList<EntregadorModel>();
		
		for (int i = 0; i < Delivery.listaDeEntregador.size(); i++) {
			EntregadorModel temp = new EntregadorModel();
			temp.setId(Delivery.listaDeEntregador.get(i).getId());
			temp.setNome(Delivery.listaDeEntregador.get(i).getNome());
			temp.setCpf(Delivery.listaDeEntregador.get(i).getCpf());
			temp.setEndereco(Delivery.listaDeEntregador.get(i).getEndereco());
			temp.setCarteiraDeTrabalho(Delivery.listaDeEntregador.get(i).getCarteiraDeTrabalho());
			resultado.add(temp);
		}
		return resultado;
	}

}
