package view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.ClienteController;
import controller.GrupoUsuarioController;


import main.Delivery;
import model.ClienteModel;
import model.GrupoUsuarioModel;
import model.PessoaModel;

public class JanelaNovoCliente extends JFrame implements ActionListener {

	private JTextField tfNome;
	private JLabel lNome;

	private JTextField tfCpf;
	private JLabel lCpf;

	private JTextField tfEndereco;
	private JLabel lEndereco;

	private JButton btLimpar;
	private JButton btCadastrar;
	private JButton btFechar;
	
	private JLabel lGrupoUsuario;
	private JComboBox<GrupoUsuarioModel> comboGrupoUsuario;

	private Container container;
	private SpringLayout layout = new SpringLayout();
	
	private List<GrupoUsuarioModel> listaGrupoUsuario;
	
	private ClienteController controller = new ClienteController();
	
	private GrupoUsuarioController grupoUsuarioController = new GrupoUsuarioController();

	public JanelaNovoCliente() {

		lNome = new JLabel("Nome");
		tfNome = new JTextField(40);

		lCpf = new JLabel("CPF");
		tfCpf = new JTextField(11);

		lEndereco = new JLabel("Endereco");
		tfEndereco = new JTextField(70);

		btLimpar = new JButton("Limpar");
		btCadastrar = new JButton("Cadastrar");
		btFechar = new JButton("Fechar");
		
		// Lista de Grupo de Usuários
		lGrupoUsuario = new JLabel("Grupo");
		comboGrupoUsuario = new JComboBox();
	
		listaGrupoUsuario = grupoUsuarioController.getGrupoUsuarios();
		
		for (GrupoUsuarioModel grupoUsuario : listaGrupoUsuario) {
			
			comboGrupoUsuario.addItem(grupoUsuario);
			
			System.out.println("id:"+grupoUsuario.getId()+" Descrição:"+grupoUsuario.getDescricao());
		}

		// Aparecer na janela
		container = this.getContentPane();
		container.setLayout(layout);

		container.add(lNome);
		layout.putConstraint(SpringLayout.WEST, lNome, 30, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, lNome, 50, SpringLayout.NORTH,
				container);
		container.add(tfNome);
		layout.putConstraint(SpringLayout.WEST, tfNome, 65, SpringLayout.WEST,
				lNome);
		layout.putConstraint(SpringLayout.NORTH, tfNome, 50,
				SpringLayout.NORTH, container);

		container.add(lCpf);
		layout.putConstraint(SpringLayout.WEST, lCpf, 30, SpringLayout.WEST,
				container);
		layout.putConstraint(SpringLayout.NORTH, lCpf, 70, SpringLayout.NORTH,
				container);
		container.add(tfCpf);
		layout.putConstraint(SpringLayout.WEST, tfCpf, 65, SpringLayout.WEST,
				lCpf);
		layout.putConstraint(SpringLayout.NORTH, tfCpf, 70, SpringLayout.NORTH,
				container);

		container.add(lEndereco);
		layout.putConstraint(SpringLayout.WEST, lEndereco, 30,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lEndereco, 90,
				SpringLayout.NORTH, container);
		container.add(tfEndereco);
		layout.putConstraint(SpringLayout.WEST, tfEndereco, 65,
				SpringLayout.WEST, lEndereco);
		layout.putConstraint(SpringLayout.NORTH, tfEndereco, 90,
				SpringLayout.NORTH, container);

		container.add(btLimpar);
		layout.putConstraint(SpringLayout.WEST, btLimpar, 130,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btLimpar, 150,
				SpringLayout.NORTH, container);
		container.add(btCadastrar);
		layout.putConstraint(SpringLayout.WEST, btCadastrar, 30,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btCadastrar, 150,
				SpringLayout.NORTH, container);
		container.add(btFechar);
		layout.putConstraint(SpringLayout.WEST, btFechar, 210,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btFechar, 150,
				SpringLayout.NORTH, container);
		
		container.add(lGrupoUsuario);
		layout.putConstraint(SpringLayout.WEST, lGrupoUsuario, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lGrupoUsuario, 115, SpringLayout.NORTH, container);
		
		container.add(comboGrupoUsuario);
		layout.putConstraint(SpringLayout.WEST, comboGrupoUsuario, 65, SpringLayout.WEST, lGrupoUsuario);
		layout.putConstraint(SpringLayout.NORTH, comboGrupoUsuario, 115, SpringLayout.NORTH, container);

		btLimpar.addActionListener(this);
		btCadastrar.addActionListener(this);
		btFechar.addActionListener(this);

		this.pack();
		this.setResizable(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setTitle("Cadastro de Novo Cliente");
		this.setSize(875, 300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btCadastrar) {
			
			ClienteModel novo = new ClienteModel();
			novo.setNome(tfNome.getText());
			novo.setCpf(tfCpf.getText());
			novo.setEndereco(tfEndereco.getText());
			
			GrupoUsuarioModel selecionaCliente = (GrupoUsuarioModel) comboGrupoUsuario.getSelectedItem();
			
			novo.setIdGrupoUsuario(selecionaCliente.getId());
			
			controller.cadastrarCliente(novo);
			
			JOptionPane.showMessageDialog(this,
					"Cadastro realizado com sucesso");
			limpar();
		} else if (e.getSource() == btLimpar) {
			limpar();
		} else if (e.getSource() == btFechar) {
			dispose();
		}
	}

	public void limpar() {

		tfNome.setText("");
		tfCpf.setText("");
		tfEndereco.setText("");
	}
	
}
