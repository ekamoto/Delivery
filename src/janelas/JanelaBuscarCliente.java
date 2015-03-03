package janelas;

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

import main.Delivery;
import classes.Cliente;

public class JanelaBuscarCliente extends JFrame implements ActionListener {

	private JLabel iLabel;
	private JTextField tfId;
	private JLabel nLabel;
	private JTextField tfNome;
	private JLabel cLabel;
	private JTextField tfCpf;
	private JLabel eLabel;
	private JTextField tfEndereco;
	private JButton btBuscar;
	private JButton btFechar;
	private JButton btExcluir;
	private Container container;
	private SpringLayout layout = new SpringLayout();
	
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
		
		btBuscar = new JButton("Buscar");
		btFechar = new JButton("Fechar");
		btExcluir = new JButton("Excluir");
		container = this.getContentPane();
		container.setLayout(layout);
		
		container.add(iLabel);
		layout.putConstraint(SpringLayout.WEST, iLabel, 275, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, iLabel, 30, SpringLayout.NORTH, container);
		container.add(tfId);
		layout.putConstraint(SpringLayout.EAST, tfId, 60, SpringLayout.EAST, iLabel);
		layout.putConstraint(SpringLayout.NORTH, tfId, 30, SpringLayout.NORTH, container);
		container.add(btBuscar);
		layout.putConstraint(SpringLayout.WEST, btBuscar, 285, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btBuscar, 60, SpringLayout.NORTH, container);
		container.add(nLabel);
		layout.putConstraint(SpringLayout.WEST, nLabel, 40, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, nLabel, 100, SpringLayout.NORTH, container);
		container.add(tfNome);
		layout.putConstraint(SpringLayout.WEST, tfNome, 65, SpringLayout.WEST, nLabel);
		layout.putConstraint(SpringLayout.NORTH, tfNome, 100, SpringLayout.NORTH, container);
		container.add(cLabel);
		layout.putConstraint(SpringLayout.WEST, cLabel, 40, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, cLabel, 125, SpringLayout.NORTH, container);
		container.add(tfCpf);
		layout.putConstraint(SpringLayout.WEST, tfCpf, 65, SpringLayout.WEST, cLabel);
		layout.putConstraint(SpringLayout.NORTH, tfCpf, 125, SpringLayout.NORTH, container);
		container.add(eLabel);
		layout.putConstraint(SpringLayout.WEST, eLabel, 40, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, eLabel, 150, SpringLayout.NORTH, container);
		container.add(tfEndereco);
		layout.putConstraint(SpringLayout.WEST, tfEndereco, 65, SpringLayout.WEST, eLabel);
		layout.putConstraint(SpringLayout.NORTH, tfEndereco, 150, SpringLayout.NORTH, container);
		container.add(btExcluir);
		layout.putConstraint(SpringLayout.WEST, btExcluir, 220, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btExcluir, 200, SpringLayout.NORTH, container);
		container.add(btFechar);
		layout.putConstraint(SpringLayout.WEST, btFechar, 350, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btFechar, 200, SpringLayout.NORTH, container);
		btBuscar.addActionListener(this);
		btFechar.addActionListener(this);
		btExcluir.addActionListener(this);
		
		this.setResizable(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setVisible(true);
		this.setTitle("Buscar Cliente");
		this.setSize(700,300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btBuscar) {
			buscaPorId(tfId.getText());
		} else if (e.getSource() == btExcluir) {
			remover();
			JOptionPane.showMessageDialog(null, "Cliente apagado com sucesso!");
			dispose();
			JanelaBuscarCliente jbc = new JanelaBuscarCliente();
		}
		else if (e.getSource() == btFechar) {
			dispose();
		}
	}

	public void remover() {
		String remover = JOptionPane.showInputDialog("Digite o ID do Cliente que deseja excluir:");
		for(int i = 0; i < Delivery.listaDeCliente.size(); i++) {
			if(Delivery.listaDeCliente.get(i).getId().equals(remover)) {
				remover += Delivery.listaDeCliente.remove(i);
			}
		}
	}
	
	public void buscaPorId(String id) {
		boolean encontrou = false;
		
		for(int i = 0; !encontrou && i < Delivery.listaDeCliente.size(); i++) {
			if(Delivery.listaDeCliente.get(i).getId().equals(id)) {
				encontrou = true;
				tfNome.setText(Delivery.listaDeCliente.get(i).getNome());
				tfCpf.setText(Delivery.listaDeCliente.get(i).getCpf());
				tfEndereco.setText(Delivery.listaDeCliente.get(i).getEndereco());
			}
		}
		if(!encontrou) {
			JOptionPane.showMessageDialog(null, "Cliente nao cadastrado");
			tfId.setText("");
			tfNome.setText("");
			tfCpf.setText("");
			tfEndereco.setText("");
		}
	}
		
}
