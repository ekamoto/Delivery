package janelas;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import main.Delivery;
import classes.Produto;

public class JanelaNovoProduto extends JFrame implements ActionListener {

	private JTextField tfCodigo;
	private JLabel lbCodigo;

	private JTextField tfNome;
	private JLabel lbNome;

	private JTextField tfDescricao;
	private JLabel lbDescricao;

	private JTextField tfQuantidade;
	private JLabel lbQuantidade;

	private JTextField tfValor;
	private JLabel lbValor;

	private Container container;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnFechar;
	private SpringLayout layout = new SpringLayout();

	public JanelaNovoProduto() {

		lbCodigo = new JLabel("Codigo");
		tfCodigo = new JTextField(4);

		lbNome = new JLabel("Nome");
		tfNome = new JTextField(30);

		lbDescricao = new JLabel("Descricao");
		tfDescricao = new JTextField(50);

		lbQuantidade = new JLabel("Quantidade");
		tfQuantidade = new JTextField(3);

		lbValor = new JLabel("Valor");
		tfValor = new JTextField(10);

		btnLimpar = new JButton("Limpar");
		btnCadastrar = new JButton("Cadastrar");
		btnFechar = new JButton("Fechar");

		container = this.getContentPane();
		container.setLayout(layout);
		
		container.add(lbCodigo);
		layout.putConstraint(SpringLayout.WEST, lbCodigo, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbCodigo, 30, SpringLayout.NORTH, container);
		container.add(tfCodigo);
		layout.putConstraint(SpringLayout.WEST, tfCodigo, 80, SpringLayout.WEST, lbCodigo);
		layout.putConstraint(SpringLayout.NORTH, tfCodigo, 30, SpringLayout.NORTH, container);
		
		container.add(lbNome);
		layout.putConstraint(SpringLayout.WEST, lbNome, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbNome, 50, SpringLayout.NORTH, container);
		container.add(tfNome);
		layout.putConstraint(SpringLayout.WEST, tfNome, 80, SpringLayout.WEST, lbNome);
		layout.putConstraint(SpringLayout.NORTH, tfNome, 50, SpringLayout.NORTH, container);
		
		container.add(lbDescricao);
		layout.putConstraint(SpringLayout.WEST, lbDescricao, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbDescricao, 70, SpringLayout.NORTH, container);
		container.add(tfDescricao);
		layout.putConstraint(SpringLayout.WEST, tfDescricao, 80, SpringLayout.WEST, lbDescricao);
		layout.putConstraint(SpringLayout.NORTH, tfDescricao, 70, SpringLayout.NORTH, container);
		
		container.add(lbQuantidade);
		layout.putConstraint(SpringLayout.WEST, lbQuantidade, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbQuantidade, 90, SpringLayout.NORTH, container);
		container.add(tfQuantidade);
		layout.putConstraint(SpringLayout.WEST, tfQuantidade, 80, SpringLayout.WEST, lbQuantidade);
		layout.putConstraint(SpringLayout.NORTH, tfQuantidade, 90, SpringLayout.NORTH, container);
		
		container.add(lbValor);
		layout.putConstraint(SpringLayout.WEST, lbValor, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbValor, 110, SpringLayout.NORTH, container);
		container.add(tfValor);
		layout.putConstraint(SpringLayout.WEST, tfValor, 80, SpringLayout.WEST, lbValor);
		layout.putConstraint(SpringLayout.NORTH, tfValor, 110, SpringLayout.NORTH, container);
		container.add(btnCadastrar);
		layout.putConstraint(SpringLayout.WEST, btnCadastrar, 110, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btnCadastrar, 140, SpringLayout.NORTH, container);
		container.add(btnLimpar);
		layout.putConstraint(SpringLayout.WEST, btnLimpar, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btnLimpar, 140, SpringLayout.NORTH, container);
		container.add(btnFechar);
		layout.putConstraint(SpringLayout.WEST, btnFechar, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btnFechar, 200, SpringLayout.NORTH, container);

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
	
			Produto produto = new Produto();
			produto.setCodigo(tfCodigo.getText());
			produto.setNome(tfNome.getText());
			produto.setDescricao(tfDescricao.getText());
			produto.setQuantidade(tfQuantidade.getText());
			produto.setValor(tfValor.getText());
			Delivery.listaDeProdutos.add(produto);
			JOptionPane.showMessageDialog(this,
					"Cadastro realizado com sucesso");
			limpar();
		} else if (e.getSource() == btnLimpar) {
			limpar();
		} else if (e.getSource() == btnFechar) {
			dispose();
		}
	}

	public void limpar() {
		tfCodigo.setText("");
		tfNome.setText("");
		tfDescricao.setText("");
		tfQuantidade.setText("");
		tfValor.setText("");
	}

}
