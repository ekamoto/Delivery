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
		
		lbCodigo = new JLabel("Codigo");
		tfCodigo = new JTextField(4);
		lbNome = new JLabel("Nome");
		tfNome = new JTextField(40);
		lbDescricao = new JLabel("Descricao");
		taDescricao = new JTextField(40);
		lbQuantidade = new JLabel("Quantidade");
		tfQuantidade = new JTextField(4);
		lbValor = new JLabel("Valor Un.");
		tfValor = new JTextField(4);
		
		btFechar = new JButton("Fechar");
		btnBuscar = new JButton("Buscar");
		
		container = this.getContentPane();
		container.setLayout(layout);
		
		container.add(lbCodigo);
		layout.putConstraint(SpringLayout.WEST, lbCodigo, 275, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbCodigo, 30, SpringLayout.NORTH, container);
		container.add(tfCodigo);
		layout.putConstraint(SpringLayout.EAST, tfCodigo, 60, SpringLayout.EAST,
				lbCodigo);
		layout.putConstraint(SpringLayout.NORTH, tfCodigo, 30, SpringLayout.NORTH,
				container);
		
		container.add(btnBuscar);
		layout.putConstraint(SpringLayout.WEST, btnBuscar, 285,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btnBuscar, 60,
				SpringLayout.NORTH, container);
		
		container.add(lbNome);
		layout.putConstraint(SpringLayout.WEST, lbNome, 40, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, lbNome, 100,
				SpringLayout.NORTH, container);
		container.add(tfNome);
		layout.putConstraint(SpringLayout.WEST, tfNome, 75, SpringLayout.WEST,
				lbNome);
		layout.putConstraint(SpringLayout.NORTH, tfNome, 100,
				SpringLayout.NORTH, container);
		
		container.add(lbDescricao);
		layout.putConstraint(SpringLayout.WEST, lbDescricao, 40, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, lbDescricao, 125,
				SpringLayout.NORTH, container);
		container.add(taDescricao);
		layout.putConstraint(SpringLayout.WEST, taDescricao, 75, SpringLayout.WEST,
				lbDescricao);
		layout.putConstraint(SpringLayout.NORTH, taDescricao, 125,
				SpringLayout.NORTH, container);
		
		container.add(lbQuantidade);
		layout.putConstraint(SpringLayout.WEST, lbQuantidade, 40, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, lbQuantidade, 150,
				SpringLayout.NORTH, container);
		container.add(tfQuantidade);
		layout.putConstraint(SpringLayout.WEST, tfQuantidade, 75,
				SpringLayout.WEST, lbQuantidade);
		layout.putConstraint(SpringLayout.NORTH, tfQuantidade, 150,
				SpringLayout.NORTH, container);
		
		container.add(lbValor);
		layout.putConstraint(SpringLayout.WEST, lbValor, 40, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, lbValor, 175,
				SpringLayout.NORTH, container);
		container.add(tfValor);
		layout.putConstraint(SpringLayout.WEST, tfValor, 75,
				SpringLayout.WEST, lbValor);
		layout.putConstraint(SpringLayout.NORTH, tfValor, 175,
				SpringLayout.NORTH, container);
		
		container.add(btFechar);
		layout.putConstraint(SpringLayout.WEST, btFechar, 75,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btFechar, 220,
				SpringLayout.NORTH, container);
		/*tfCodigo = new JTextField(4);
		tfNome = new JTextField(30);
		layout.putConstraint(SpringLayout.WEST, tfNome, 105, SpringLayout.WEST, getContentPane());
		tfNome.setEditable(false);
		taDescricao = new JTextField(50);
		layout.putConstraint(SpringLayout.WEST, taDescricao, 105, SpringLayout.WEST, getContentPane());
		taDescricao.setEditable(false);
		tfQuantidade = new JTextField(3);
		layout.putConstraint(SpringLayout.EAST, tfCodigo, -6, SpringLayout.EAST, tfQuantidade);
		layout.putConstraint(SpringLayout.WEST, tfQuantidade, 105, SpringLayout.WEST, getContentPane());
		tfQuantidade.setEditable(false);
		tfValor = new JTextField(10);
		layout.putConstraint(SpringLayout.WEST, tfValor, 105, SpringLayout.WEST, getContentPane());
		tfValor.setEditable(false);
		lbCodigo = new JLabel("Codigo");
		layout.putConstraint(SpringLayout.SOUTH, tfCodigo, 5, SpringLayout.SOUTH, lbCodigo);
		layout.putConstraint(SpringLayout.NORTH, lbCodigo, 25, SpringLayout.NORTH, getContentPane());
		layout.putConstraint(SpringLayout.WEST, tfCodigo, 0, SpringLayout.EAST, lbCodigo);
		lbNome = new JLabel("Nome");
		layout.putConstraint(SpringLayout.WEST, lbCodigo, 0, SpringLayout.WEST, lbNome);
		layout.putConstraint(SpringLayout.SOUTH, lbCodigo, -53, SpringLayout.NORTH, lbNome);
		layout.putConstraint(SpringLayout.EAST, lbCodigo, 0, SpringLayout.EAST, lbNome);
		layout.putConstraint(SpringLayout.NORTH, lbNome, 2, SpringLayout.NORTH, tfNome);
		layout.putConstraint(SpringLayout.WEST, lbNome, 21, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.EAST, lbNome, -6, SpringLayout.WEST, tfNome);
		lbDescricao = new JLabel("Descricao");
		layout.putConstraint(SpringLayout.NORTH, lbDescricao, 2, SpringLayout.NORTH, taDescricao);
		layout.putConstraint(SpringLayout.WEST, lbDescricao, 0, SpringLayout.WEST, lbNome);
		lbQuantidade = new JLabel("Quantidade");
		layout.putConstraint(SpringLayout.NORTH, lbQuantidade, 2, SpringLayout.NORTH, tfQuantidade);
		layout.putConstraint(SpringLayout.EAST, lbQuantidade, -6, SpringLayout.EAST, lbNome);
		lbValor = new JLabel("Valor");
		layout.putConstraint(SpringLayout.NORTH, lbValor, 2,
				SpringLayout.NORTH, tfValor);
		layout.putConstraint(SpringLayout.WEST, lbValor, 0, SpringLayout.WEST, lbNome);
		btnBuscar = new JButton("Buscar");
		layout.putConstraint(SpringLayout.NORTH, btnBuscar, 20, SpringLayout.NORTH, lbCodigo);
		layout.putConstraint(SpringLayout.EAST, btnBuscar, 200, SpringLayout.EAST, getContentPane());
		btFechar = new JButton("Fechar");
		layout.putConstraint(SpringLayout.NORTH, btFechar, 67, SpringLayout.SOUTH, taDescricao);
		layout.putConstraint(SpringLayout.WEST, btFechar, 388, SpringLayout.WEST, getContentPane());

		container = this.getContentPane();
		container.setLayout(layout);
		container.add(lbCodigo);
		container.add(tfCodigo);
		layout.putConstraint(SpringLayout.NORTH, tfCodigo, 30,
				SpringLayout.NORTH, container);
		container.add(btnBuscar);

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
		container.add(btFechar);*/

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
		
		if(!id.equals("")) {
			
			produto = produtoController.getProdutoID(Integer.parseInt(id));
			
			tfNome.setText(produto.getNome());
			taDescricao.setText(produto.getDescricao());
			tfQuantidade.setText(Integer.toString(produto.getQuantidade()));
			tfValor.setText(Double.toString(produto.getValor()));
			
			if (produto.getNome()==null) {
				
				JOptionPane.showMessageDialog(null, "Produto nao cadastrado");
				tfCodigo.setText("");
				tfNome.setText("");
				taDescricao.setText("");
				tfQuantidade.setText("");
				tfValor.setText("");
			}	
		} else {
			
			JOptionPane.showMessageDialog(null, "Campo código do produto vazio!");
		}

		return produto;
	}

}
