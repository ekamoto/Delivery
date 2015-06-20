package view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;

import main.Delivery;
import model.ClienteModel;

public class JanelaBuscarCliente extends JFrame implements ActionListener {

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
	private SpringLayout layout = new SpringLayout();
	private ClienteController controller = new ClienteController();

	public JanelaBuscarCliente() {

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
		layout.putConstraint(SpringLayout.EAST, tfId, 60, SpringLayout.EAST,
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
		this.setTitle("Buscar Cliente");
		this.setSize(700, 300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btBuscar) {
			buscaPorId(tfId.getText());
		} else if (e.getSource() == btExcluir) {
			JanelaDesativarCliente jdc = new JanelaDesativarCliente();
			limpar();
			//dispose();
			//JanelaBuscarCliente jbc = new JanelaBuscarCliente();
		} else if (e.getSource() == btFechar) {
			dispose();
		}
	}

	public void limpar() {
		tfNome.setText("");
		tfCpf.setText("");
		tfEndereco.setText("");
		tfCel.setText("");
		tfTel.setText("");
	}
	/*public void remover() {

		String remover = JOptionPane
				.showInputDialog("Digite o ID do Cliente que deseja excluir:");

		if (controller.deletarCliente(Integer.parseInt(remover))) {

			JOptionPane.showMessageDialog(null, "Cliente apagado com sucesso!");
		} else {

			JOptionPane.showMessageDialog(null, "Falha ao deletar cliente!");
		}
	}*/

	public void buscaPorId(String id) {

		ClienteModel cliente = controller.getClienteID(Integer.parseInt(id));

		if (cliente.getId() != null) {

			tfNome.setText(cliente.getNome());
			tfCpf.setText(cliente.getCpf());
			tfEndereco.setText(cliente.getEndereco());
			tfCel.setText(cliente.getCelular());
			tfTel.setText(cliente.getTelefone());
		} else {

			System.out.println("Deu errado");
			JOptionPane.showMessageDialog(null, "Cliente nao cadastrado");
			tfId.setText("");
			tfNome.setText("");
			tfCpf.setText("");
			tfEndereco.setText("");
			tfCel.setText("");
			tfTel.setText("");
		}
	}
}