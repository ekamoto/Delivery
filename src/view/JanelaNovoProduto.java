package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import main.Delivery;
import model.CategoriaModel;
import model.EntregadorModel;
import model.ProdutoModel;
import controller.CategoriaController;
import controller.ProdutoController;

public class JanelaNovoProduto extends JFrame implements ActionListener {

	private JTextField tfNome;
	private JLabel lbNome;

	private JTextField tfDescricao;
	private JLabel lbDescricao;

	private JTextField tfQuantidade;
	private JLabel lbQuantidade;

	private JTextField tfValor;
	private JLabel lbValor;

	private JTextField tfFabricante;
	private JLabel lbFabricante;
	
	private JComboBox comboCategoria;
	private JLabel labelCategoria;
	
	private Container container;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnFechar;
	private SpringLayout layout = new SpringLayout();
	private List<CategoriaModel> listaCategoria;
	private ProdutoController produtoController;
	private CategoriaController categoriaController = new CategoriaController();
	
	public JanelaNovoProduto() {

		produtoController = new ProdutoController();

		lbNome = new JLabel("Nome");
		tfNome = new JTextField(30);

		lbDescricao = new JLabel("Descricao");
		tfDescricao = new JTextField(50);

		lbQuantidade = new JLabel("Quantidade");
		tfQuantidade = new JTextField(3);

		lbValor = new JLabel("Valor");
		tfValor = new JTextField(10);
		
		lbFabricante = new JLabel("Fabricante");
		tfFabricante = new JTextField(50);
		
		labelCategoria = new JLabel("Categoria");
		comboCategoria = new JComboBox();
		listaCategoria = listarCategorias();
		for (CategoriaModel categoria: listaCategoria){
			comboCategoria.addItem(categoria);
		}

		btnLimpar = new JButton("Limpar");
		btnCadastrar = new JButton("Cadastrar");
		btnFechar = new JButton("Fechar");

		container = this.getContentPane();
		container.setLayout(layout);
		
		container.add(lbNome);
		layout.putConstraint(SpringLayout.WEST, lbNome, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbNome, 50, SpringLayout.NORTH, container);
		container.add(tfNome);
		layout.putConstraint(SpringLayout.WEST, tfNome, 80, SpringLayout.WEST, lbNome);
		layout.putConstraint(SpringLayout.NORTH, tfNome, 50, SpringLayout.NORTH, container);
		
		container.add(lbDescricao);
		layout.putConstraint(SpringLayout.WEST, lbDescricao, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbDescricao, 80, SpringLayout.NORTH, container);
		container.add(tfDescricao);
		layout.putConstraint(SpringLayout.WEST, tfDescricao, 80, SpringLayout.WEST, lbDescricao);
		layout.putConstraint(SpringLayout.NORTH, tfDescricao, 80, SpringLayout.NORTH, container);
		
		container.add(lbQuantidade);
		layout.putConstraint(SpringLayout.WEST, lbQuantidade, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbQuantidade, 110, SpringLayout.NORTH, container);
		container.add(tfQuantidade);
		layout.putConstraint(SpringLayout.WEST, tfQuantidade, 80, SpringLayout.WEST, lbQuantidade);
		layout.putConstraint(SpringLayout.NORTH, tfQuantidade, 110, SpringLayout.NORTH, container);
		
		container.add(lbFabricante);
		layout.putConstraint(SpringLayout.WEST, lbFabricante, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbFabricante, 140, SpringLayout.NORTH, container);
		container.add(tfFabricante);
		layout.putConstraint(SpringLayout.WEST, tfFabricante, 80, SpringLayout.WEST, lbQuantidade);
		layout.putConstraint(SpringLayout.NORTH, tfFabricante, 140, SpringLayout.NORTH, container);
		
		container.add(labelCategoria);
		layout.putConstraint(SpringLayout.WEST, labelCategoria, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, labelCategoria, 170, SpringLayout.NORTH, container);
		container.add(comboCategoria);
		layout.putConstraint(SpringLayout.WEST, comboCategoria, 80, SpringLayout.WEST, lbQuantidade);
		layout.putConstraint(SpringLayout.NORTH, comboCategoria, 170, SpringLayout.NORTH, container);
		
		container.add(lbValor);
		layout.putConstraint(SpringLayout.WEST, lbValor, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbValor, 200, SpringLayout.NORTH, container);
		container.add(tfValor);
		layout.putConstraint(SpringLayout.WEST, tfValor, 80, SpringLayout.WEST, lbValor);
		layout.putConstraint(SpringLayout.NORTH, tfValor, 200, SpringLayout.NORTH, container);
		container.add(btnCadastrar);
		layout.putConstraint(SpringLayout.WEST, btnCadastrar, 110, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btnCadastrar, 230, SpringLayout.NORTH, container);
		container.add(btnLimpar);
		layout.putConstraint(SpringLayout.WEST, btnLimpar, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btnLimpar, 230, SpringLayout.NORTH, container);
		container.add(btnFechar);
		layout.putConstraint(SpringLayout.WEST, btnFechar, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btnFechar, 260, SpringLayout.NORTH, container);

		btnCadastrar.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnFechar.addActionListener(this);
		
		this.pack();
		this.setResizable(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setTitle("Cadastro de Novo Produto");
		this.setSize(875,300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCadastrar) {
	
			ProdutoModel produto = new ProdutoModel();
			produto.setNome(tfNome.getText());
			produto.setDescricao(tfDescricao.getText());
			
			int quantidade = Integer.parseInt(tfQuantidade.getText());
			produto.setQuantidade(quantidade);
			
			
			produto.setValor(Double.parseDouble(tfValor.getText()));
			produto.setFabricante(tfFabricante.getText());
			CategoriaModel selecionaCategoria = (CategoriaModel) comboCategoria.getSelectedItem();
			produto.setCategoria(selecionaCategoria);
			
			produtoController.cadastrarProduto(produto);
			
			//Delivery.listaDeProdutos.add(produto);
			
			limpar();
		} else if (e.getSource() == btnLimpar) {
			limpar();
		} else if (e.getSource() == btnFechar) {
			dispose();
		}
	}

	public void limpar() {
		
		tfNome.setText("");
		tfDescricao.setText("");
		tfQuantidade.setText("");
		tfValor.setText("");
		tfFabricante.setText("");
	}
	
	public List<CategoriaModel> listarCategorias() {
		return categoriaController.getCategorias();
	}

}
