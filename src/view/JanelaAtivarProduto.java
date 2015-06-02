package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.ProdutoController;

public class JanelaAtivarProduto extends JFrame implements ActionListener {

	private JTextField tfCodigo;
	private JLabel lCodigo;

	private JButton btLimpar;
	private JButton btAtivar;
	private JButton btFechar;

	private Container container;
	private SpringLayout layout = new SpringLayout();
	private ProdutoController produtoController = new ProdutoController();
	Image bImage;

	public void JFrameWithBackground(String path) {

		this.bImage = this.createImage(path);

		this.initComponents();

	}

	public void initComponents() {

		super.setContentPane(new NewContentPane(this.bImage));
		super.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	private Image createImage(String path) {

		return Toolkit.getDefaultToolkit().createImage(path);

	}

	public JanelaAtivarProduto() {

		
		// Adicionando imagem de fundo
		JFrameWithBackground("src/imgs/eu.jpg");
		
		lCodigo = new JLabel("Código");
		tfCodigo = new JTextField(40);
		layout.putConstraint(SpringLayout.WEST, tfCodigo, 15,
				SpringLayout.EAST, lCodigo);

		btLimpar = new JButton("Limpar");
		btAtivar = new JButton("Ativar");
		btFechar = new JButton("Fechar");

		// Aparecer na janela
		container = this.getContentPane();
		container.setLayout(layout);

		container.add(lCodigo);
		layout.putConstraint(SpringLayout.WEST, lCodigo, 30, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, lCodigo, 50,
				SpringLayout.NORTH, container);
		container.add(tfCodigo);
		layout.putConstraint(SpringLayout.NORTH, tfCodigo, 50,
				SpringLayout.NORTH, container);

		container.add(btLimpar);
		layout.putConstraint(SpringLayout.WEST, btLimpar, 30,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btLimpar, 115,
				SpringLayout.NORTH, container);
		container.add(btAtivar);
		layout.putConstraint(SpringLayout.WEST, btAtivar, 110,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btAtivar, 115,
				SpringLayout.NORTH, container);
		container.add(btFechar);
		layout.putConstraint(SpringLayout.WEST, btFechar, 30,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btFechar, 175,
				SpringLayout.NORTH, container);

		btLimpar.addActionListener(this);
		btAtivar.addActionListener(this);
		btFechar.addActionListener(this);

		// Setando cor de fundo
		this.getContentPane().setBackground(new Color(245, 255, 250));

		this.setResizable(true);
		this.setVisible(true);
		this.setTitle("Ativar Produto");
		this.setSize(875, 300);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btAtivar) {

			if (produtoController.ativarProduto(Integer.parseInt(tfCodigo
					.getText()))) {

				JOptionPane.showMessageDialog(this,
						"Produto ativado com sucesso");
			} else {

				JOptionPane.showMessageDialog(this, "Falha ao ativar produto");
			}

			limpar();
		} else if (e.getSource() == btLimpar) {

			limpar();
		} else if (e.getSource() == btFechar) {

			dispose();
		}
	}

	public void limpar() {

		tfCodigo.setText("");
	}

}
