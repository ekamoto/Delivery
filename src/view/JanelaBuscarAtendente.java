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

import model.AtendenteModel;
import controller.AtendenteController;

public class JanelaBuscarAtendente extends JFrame implements ActionListener{
	private JLabel iLabel;
	private JTextField tfId;
	private JLabel nLabel;
	private JTextField tfNome;
	private JLabel cLabel;
	private JTextField tfCpf;
	private JLabel eLabel;
	private JTextField tfEndereco;
	private JLabel celLabel;
	private JTextField tfCel;
	private JLabel tLabel;
	private JTextField tfTel;
	private JButton btBuscar;
	private JButton btFechar;
	private JButton btExcluir;
	private Container container;
	private AtendenteController controller = new AtendenteController();
	private SpringLayout layout = new SpringLayout();

	public JanelaBuscarAtendente() {

		iLabel = new JLabel("Id");
		tfId = new JTextField(4);
		nLabel = new JLabel("Nome");
		tfNome = new JTextField(40);
		tfNome.setEditable(false);
		cLabel = new JLabel("CPF");
		tfCpf = new JTextField(11);
		tfCpf.setEditable(false);
		eLabel = new JLabel("Endereco");
		tfEndereco = new JTextField(52);
		tfEndereco.setEditable(false);
		celLabel = new JLabel("Celular");
		tfCel = new JTextField(11);
		tfCel.setEditable(false);
		tLabel = new JLabel("Telefone");
		tfTel = new JTextField(11);
		tfTel.setEditable(false);

		btBuscar = new JButton("Buscar");
		btFechar = new JButton("Fechar");
		btExcluir = new JButton("Desativar");

		container = this.getContentPane();
		container.setLayout(layout);
		container.add(iLabel);
		layout.putConstraint(SpringLayout.WEST, iLabel, 275, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, iLabel, 30,
				SpringLayout.NORTH, container);
		container.add(tfId);
		layout.putConstraint(SpringLayout.EAST, tfId, 70, SpringLayout.EAST,
				iLabel);
		layout.putConstraint(SpringLayout.NORTH, tfId, 30, SpringLayout.NORTH,
				container);
		container.add(btBuscar);
		layout.putConstraint(SpringLayout.WEST, btBuscar, 285,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btBuscar, 60,
				SpringLayout.NORTH, container);
		container.add(nLabel);
		layout.putConstraint(SpringLayout.WEST, nLabel, 40, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, nLabel, 100,
				SpringLayout.NORTH, container);
		container.add(tfNome);
		layout.putConstraint(SpringLayout.WEST, tfNome, 65, SpringLayout.WEST,
				nLabel);
		layout.putConstraint(SpringLayout.NORTH, tfNome, 100,
				SpringLayout.NORTH, container);
		container.add(cLabel);
		layout.putConstraint(SpringLayout.WEST, cLabel, 40, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, cLabel, 125,
				SpringLayout.NORTH, container);
		container.add(tfCpf);
		layout.putConstraint(SpringLayout.WEST, tfCpf, 65, SpringLayout.WEST,
				cLabel);
		layout.putConstraint(SpringLayout.NORTH, tfCpf, 125,
				SpringLayout.NORTH, container);
		container.add(eLabel);
		layout.putConstraint(SpringLayout.WEST, eLabel, 40, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, eLabel, 150,
				SpringLayout.NORTH, container);
		container.add(tfEndereco);
		layout.putConstraint(SpringLayout.WEST, tfEndereco, 65,
				SpringLayout.WEST, eLabel);
		layout.putConstraint(SpringLayout.NORTH, tfEndereco, 150,
				SpringLayout.NORTH, container);
		container.add(celLabel);
		layout.putConstraint(SpringLayout.WEST, celLabel, 40, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, celLabel, 175,
				SpringLayout.NORTH, container);
		container.add(tfCel);
		layout.putConstraint(SpringLayout.WEST, tfCel, 65,
				SpringLayout.WEST, celLabel);
		layout.putConstraint(SpringLayout.NORTH, tfCel, 175,
				SpringLayout.NORTH, container);
		container.add(tLabel);
		layout.putConstraint(SpringLayout.WEST, tLabel, 40, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, tLabel, 200,
				SpringLayout.NORTH, container);
		container.add(tfTel);
		layout.putConstraint(SpringLayout.WEST, tfTel, 65,
				SpringLayout.WEST, tLabel);
		layout.putConstraint(SpringLayout.NORTH, tfTel, 200,
				SpringLayout.NORTH, container);
		
		container.add(btExcluir);
		layout.putConstraint(SpringLayout.WEST, btExcluir, 220,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btExcluir, 240,
				SpringLayout.NORTH, container);
		container.add(btFechar);
		layout.putConstraint(SpringLayout.WEST, btFechar, 350,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btFechar, 240,
				SpringLayout.NORTH, container);

		btBuscar.addActionListener(this);
		btFechar.addActionListener(this);
		btExcluir.addActionListener(this);
		
		this.setResizable(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setTitle("Buscar Atendente");
		this.setSize(700, 300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btBuscar) {
			buscaPorId(tfId.getText());
		} else if (e.getSource() == btExcluir) {
			JanelaDesativarAtendente jda = new JanelaDesativarAtendente();
			limpar();
		} else if (e.getSource() == btFechar) {
			dispose();
		}
	}

	/*public void remover() {

		String remover = JOptionPane
				.showInputDialog("Digite o ID do Atendente que deseja excluir:");

		if (controller.deletarAtendente(Integer.parseInt(remover))) {

			JOptionPane.showMessageDialog(null, "Atendente apagado com sucesso!");
		} else {

			JOptionPane.showMessageDialog(null, "Falha ao deletar Atendente!");
		}
	}*/

	public void buscaPorId(String id) {

		AtendenteModel atendente = controller.getAtendenteId(Integer.parseInt(id));

		if (atendente.getId() != null) {

			tfNome.setText(atendente.getNome());
			tfCpf.setText(atendente.getCpf());
			tfEndereco.setText(atendente.getEndereco());
			tfCel.setText(atendente.getCelular());
			tfTel.setText(atendente.getTelefone());
		} else {

			System.out.println("Deu errado");
			JOptionPane.showMessageDialog(null, "Atendente nao cadastrado");
			tfId.setText("");
			tfNome.setText("");
			tfCpf.setText("");
			tfEndereco.setText("");
			tfCel.setText("");
			tfTel.setText("");
		}
	}
	
	/*public void remove() {
		String remover = JOptionPane
				.showInputDialog("Digite o ID do Entregador que deseja excluir:");
		for (int i = 0; i < Delivery.listaDeEntregador.size(); i++) {
			if (Delivery.listaDeEntregador.get(i).getId().equals(remover)) {
				remover += Delivery.listaDeEntregador.remove(i);
			}
		}
	}

	public void buscaPorId(String id) {
		boolean encontrou = false;

		for (int i = 0; !encontrou && i < Delivery.listaDeEntregador.size(); i++) {
			if (Delivery.listaDeEntregador.get(i).getId().equals(id)) {
				encontrou = true;
				tfNome.setText(Delivery.listaDeEntregador.get(i).getNome());
				tfCpf.setText(Delivery.listaDeEntregador.get(i).getCpf());
				tfEndereco.setText(Delivery.listaDeEntregador.get(i)
						.getEndereco());
			}
		}
		if (!encontrou) {
			JOptionPane.showMessageDialog(null, "Entregador nao cadastrado");
			tfId.setText("");
			tfNome.setText("");
			tfCpf.setText("");
			tfEndereco.setText("");
			tfCarteira.setText("");
		}
	}*/
	
	public void limpar() {
		tfNome.setText("");
		tfCpf.setText("");
		tfEndereco.setText("");
		tfCel.setText("");
		tfTel.setText("");
	}
}
