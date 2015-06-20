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

import controller.EntregadorController;

public class JanelaDesativarEntregador extends JFrame implements ActionListener{
	
	private JTextField tfCodigo;
	private JLabel lCodigo;
	
	private JButton btLimpar;
	private JButton btDesativar;
	private JButton btFechar;
	
	private Container container;
	private SpringLayout layout = new SpringLayout();
	private EntregadorController entregadorController = new EntregadorController();
	
	public JanelaDesativarEntregador() {
		lCodigo = new JLabel("Código");
		tfCodigo = new JTextField(40);
		layout.putConstraint(SpringLayout.WEST, tfCodigo, 15, SpringLayout.EAST, lCodigo);

		btLimpar = new JButton("Limpar");
		btDesativar = new JButton("Desativar");
		btFechar = new JButton("Fechar");

		// Aparecer na janela
		container = this.getContentPane();
		container.setLayout(layout);

		container.add(lCodigo);
		layout.putConstraint(SpringLayout.WEST, lCodigo, 30, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, lCodigo, 50, SpringLayout.NORTH,
				container);
		container.add(tfCodigo);
		layout.putConstraint(SpringLayout.NORTH, tfCodigo, 50,
				SpringLayout.NORTH, container);


		container.add(btLimpar);
		layout.putConstraint(SpringLayout.WEST, btLimpar, 30,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btLimpar, 115,
				SpringLayout.NORTH, container);
		container.add(btDesativar);
		layout.putConstraint(SpringLayout.WEST, btDesativar, 110,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btDesativar, 115,
				SpringLayout.NORTH, container);
		container.add(btFechar);
		layout.putConstraint(SpringLayout.WEST, btFechar, 30,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btFechar, 175,
				SpringLayout.NORTH, container);

		btLimpar.addActionListener(this);
		btDesativar.addActionListener(this);
		btFechar.addActionListener(this);

//		this.pack();
		this.setResizable(true);
//		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setTitle("Desativar Entregador");
		this.setSize(875, 300);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btDesativar) {
			if(entregadorController.desativarEntregador(Integer.parseInt(tfCodigo.getText()))) {
				JOptionPane.showMessageDialog(this, "Entregador desativado com sucesso");
			} else {
				JOptionPane.showMessageDialog(this, "Falha ao desativar entregador");
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
