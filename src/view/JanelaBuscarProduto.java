package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.ProdutoController;


import model.ProdutoModel;

public class JanelaBuscarProduto extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField taDescricao;
	private JTextField tfQuantidade;
	private JTextField tfValor;

	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbDescricao;
	private JLabel lbQuantidade;
	private JLabel lbValor;

	private JButton btnBuscar;
	private JButton btFechar;

	private Container container;
	private SpringLayout layout = new SpringLayout();
	private ProdutoController produtoController = new ProdutoController();

	public JanelaBuscarProduto() {

		tfCodigo = new JTextField(4);
		tfNome = new JTextField(30);
		tfNome.setEditable(false);
		taDescricao = new JTextField(50);
		layout.putConstraint(SpringLayout.WEST, taDescricao, 105, SpringLayout.WEST, getContentPane());
		taDescricao.setEditable(false);
		tfQuantidade = new JTextField(3);
		tfQuantidade.setEditable(false);
		tfValor = new JTextField(10);
		tfValor.setEditable(false);
		lbCodigo = new JLabel("Codigo");
		lbNome = new JLabel("Nome");
		layout.putConstraint(SpringLayout.WEST, tfNome, 15, SpringLayout.EAST, lbNome);
		layout.putConstraint(SpringLayout.NORTH, lbNome, 2, SpringLayout.NORTH, tfNome);
		lbDescricao = new JLabel("Descricao");
		layout.putConstraint(SpringLayout.NORTH, lbDescricao, 4, SpringLayout.SOUTH, lbNome);
		layout.putConstraint(SpringLayout.EAST, lbNome, 0, SpringLayout.EAST, lbDescricao);
		layout.putConstraint(SpringLayout.EAST, lbDescricao, -15, SpringLayout.WEST, taDescricao);
		lbQuantidade = new JLabel("Quantidade");
		layout.putConstraint(SpringLayout.NORTH, lbQuantidade, 10, SpringLayout.SOUTH, lbDescricao);
		layout.putConstraint(SpringLayout.WEST, tfQuantidade, 12, SpringLayout.EAST, lbQuantidade);
		layout.putConstraint(SpringLayout.WEST, lbQuantidade, 10, SpringLayout.WEST, getContentPane());
		lbValor = new JLabel("Valor");
		layout.putConstraint(SpringLayout.WEST, tfValor, 15, SpringLayout.EAST, lbValor);
		layout.putConstraint(SpringLayout.NORTH, lbValor, 2,
				SpringLayout.NORTH, tfValor);
		layout.putConstraint(SpringLayout.EAST, lbValor, 0, SpringLayout.EAST, lbNome);
		btnBuscar = new JButton("Buscar");
		btFechar = new JButton("Fechar");
		layout.putConstraint(SpringLayout.NORTH, btFechar, 67, SpringLayout.SOUTH, taDescricao);
		layout.putConstraint(SpringLayout.WEST, btFechar, 388, SpringLayout.WEST, getContentPane());

		container = this.getContentPane();
		container.setLayout(layout);
		container.add(lbCodigo);
		layout.putConstraint(SpringLayout.WEST, lbCodigo, 275,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbCodigo, 30,
				SpringLayout.NORTH, container);
		container.add(tfCodigo);
		layout.putConstraint(SpringLayout.EAST, tfCodigo, 70,
				SpringLayout.EAST, lbCodigo);
		layout.putConstraint(SpringLayout.NORTH, tfCodigo, 30,
				SpringLayout.NORTH, container);
		container.add(btnBuscar);
		layout.putConstraint(SpringLayout.WEST, btnBuscar, 285,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btnBuscar, 60,
				SpringLayout.NORTH, container);

		container.add(lbNome);
		container.add(tfNome);
		layout.putConstraint(SpringLayout.NORTH, tfNome, 100,
				SpringLayout.NORTH, container);

		container.add(lbDescricao);
		container.add(taDescricao);
		layout.putConstraint(SpringLayout.NORTH, taDescricao, 125,
				SpringLayout.NORTH, container);

		container.add(lbQuantidade);
		container.add(tfQuantidade);
		layout.putConstraint(SpringLayout.NORTH, tfQuantidade, 150,
				SpringLayout.NORTH, container);

		container.add(lbValor);
		container.add(tfValor);
		layout.putConstraint(SpringLayout.NORTH, tfValor, 175,
				SpringLayout.NORTH, container);
		container.add(btFechar);

		btnBuscar.addActionListener(this);
		btFechar.addActionListener(this);

		this.setResizable(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setTitle("Buscar Produto");
		this.setSize(700, 300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			buscaPorId(tfCodigo.getText());
		} else if (e.getSource() == btFechar) {
			dispose();
		}
	}

	public ProdutoModel buscaPorId(String id) {

		ProdutoModel produto = new ProdutoModel();

		produto = produtoController.getProdutoID(Integer.parseInt(id));
		
		tfNome.setText(produto.getNome());
		taDescricao.setText(produto.getDescricao());
		tfQuantidade.setText(Integer.toString(produto.getQuantidade()));
		tfValor.setText(Double.toString(produto.getValor()));
		
		if (produto.getNome().equals("")) {
			JOptionPane.showMessageDialog(null, "Produto nao cadastrado");
			tfCodigo.setText("");
			tfNome.setText("");
			taDescricao.setText("");
			tfQuantidade.setText("");
			tfValor.setText("");
		}
		
		return produto;
	}

}
