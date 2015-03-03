package janelas;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
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
import classes.Cliente;
import classes.Produto;

public class JanelaBuscarProduto extends JFrame implements ActionListener {

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
	private JButton btExcluir;

	private Container container;
	private SpringLayout layout = new SpringLayout();

	public JanelaBuscarProduto() {

		tfCodigo = new JTextField(4);
		tfNome = new JTextField(30);
		tfNome.setEditable(false);
		taDescricao = new JTextField(50);
		taDescricao.setEditable(false);
		tfQuantidade = new JTextField(3);
		tfQuantidade.setEditable(false);
		tfValor = new JTextField(10);
		tfValor.setEditable(false);
		lbCodigo = new JLabel("Codigo");
		lbNome = new JLabel("Nome");
		lbDescricao = new JLabel("Descricao");
		lbQuantidade = new JLabel("Quantidade");
		lbValor = new JLabel("Valor");
		btnBuscar = new JButton("Buscar");
		btFechar = new JButton("Fechar");
		btExcluir = new JButton("Excluir");

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
		layout.putConstraint(SpringLayout.WEST, lbNome, 40, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, lbNome, 100,
				SpringLayout.NORTH, container);
		container.add(tfNome);
		layout.putConstraint(SpringLayout.WEST, tfNome, 65, SpringLayout.WEST,
				lbNome);
		layout.putConstraint(SpringLayout.NORTH, tfNome, 100,
				SpringLayout.NORTH, container);

		container.add(lbDescricao);
		layout.putConstraint(SpringLayout.WEST, lbDescricao, 40,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbDescricao, 125,
				SpringLayout.NORTH, container);
		container.add(taDescricao);
		layout.putConstraint(SpringLayout.WEST, taDescricao, 65,
				SpringLayout.WEST, lbDescricao);
		layout.putConstraint(SpringLayout.NORTH, taDescricao, 125,
				SpringLayout.NORTH, container);

		container.add(lbQuantidade);
		layout.putConstraint(SpringLayout.WEST, lbQuantidade, 40,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lbQuantidade, 150,
				SpringLayout.NORTH, container);
		container.add(tfQuantidade);
		layout.putConstraint(SpringLayout.WEST, tfQuantidade, 65,
				SpringLayout.WEST, lbQuantidade);
		layout.putConstraint(SpringLayout.NORTH, tfQuantidade, 150,
				SpringLayout.NORTH, container);

		container.add(lbValor);
		layout.putConstraint(SpringLayout.WEST, lbValor, 40, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, lbValor, 175,
				SpringLayout.NORTH, container);
		container.add(tfValor);
		layout.putConstraint(SpringLayout.WEST, tfValor, 65, SpringLayout.WEST,
				lbValor);
		layout.putConstraint(SpringLayout.NORTH, tfValor, 175,
				SpringLayout.NORTH, container);

		container.add(btExcluir);
		layout.putConstraint(SpringLayout.WEST, btExcluir, 220,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btExcluir, 225,
				SpringLayout.NORTH, container);
		container.add(btFechar);
		layout.putConstraint(SpringLayout.WEST, btFechar, 350,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btFechar, 225,
				SpringLayout.NORTH, container);

		btnBuscar.addActionListener(this);
		btFechar.addActionListener(this);
		btExcluir.addActionListener(this);

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
		} else if (e.getSource() == btExcluir) {
			remove();
			JOptionPane.showMessageDialog(null, "Produto apagado com sucesso!");
			dispose();
			JanelaBuscarProduto jbp = new JanelaBuscarProduto();
		}
	}

	public void remove() {
		String remover = JOptionPane
				.showInputDialog("Digite o Codigo do Produto que deseja excluir:");
		for (int i = 0; i < Delivery.listaDeProdutos.size(); i++) {
			if (Delivery.listaDeProdutos.get(i).getCodigo().equals(remover)) {
				remover += Delivery.listaDeProdutos.remove(i);
			}
		}
	}

	public Produto buscaPorId(String id) {
		boolean encontrou = false;

		Produto produto = new Produto();

		for (int i = 0; !encontrou && i < Delivery.listaDeProdutos.size(); i++) {
			if (Delivery.listaDeProdutos.get(i).getCodigo().equals(id)) {
				encontrou = true;
				tfNome.setText(Delivery.listaDeProdutos.get(i).getNome());
				taDescricao.setText(Delivery.listaDeProdutos.get(i)
						.getDescricao());
				tfQuantidade.setText(Delivery.listaDeProdutos.get(i)
						.getQuantidade());
				tfValor.setText(Delivery.listaDeProdutos.get(i).getValor());

			}
		}
		if (!encontrou) {
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
