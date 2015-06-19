package view;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import model.EntregadorModel;
import model.GrupoUsuarioModel;
import controller.EntregadorController;
import controller.GrupoUsuarioController;


public class JanelaNovoEntregador extends JFrame implements ActionListener{

	private JTextField tfNome;
	private JLabel lNome;

	private JTextField tfCpf;
	private JLabel lCpf;

	private JTextField tfEndereco;
	private JLabel lEndereco;
	
	private JTextField tfCelular;
	private JLabel lCelular;
	
	private JTextField tfTelefone;
	private JLabel lTelefone;
	
	private JButton btLimpar;
	private JButton btCadastrar;
	private JButton btFechar;
	
	private JLabel lGrupoUsuario;
	private JComboBox<GrupoUsuarioModel> comboGrupoUsuario;

	private Container container;
	private SpringLayout layout = new SpringLayout();
	
	private List<GrupoUsuarioModel> listaGrupoUsuario;
	
	private EntregadorController controller = new EntregadorController();
	
	private GrupoUsuarioController grupoUsuarioController = new GrupoUsuarioController();

	public JanelaNovoEntregador() {

		lNome = new JLabel("Nome");
		tfNome = new JTextField(40);

		lCpf = new JLabel("CPF");
		tfCpf = new JTextField(11);

		lEndereco = new JLabel("Endereco");
		tfEndereco = new JTextField(70);
		
		lCelular = new JLabel("Celular");
		tfCelular = new JTextField(11);
		
		lTelefone = new JLabel("Telefone");
		tfTelefone = new JTextField(11);

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
		layout.putConstraint(SpringLayout.NORTH, lCpf, 80, SpringLayout.NORTH,
				container);
		container.add(tfCpf);
		layout.putConstraint(SpringLayout.WEST, tfCpf, 65, SpringLayout.WEST,
				lCpf);
		layout.putConstraint(SpringLayout.NORTH, tfCpf, 80, SpringLayout.NORTH,
				container);

		container.add(lEndereco);
		layout.putConstraint(SpringLayout.WEST, lEndereco, 30,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lEndereco, 110,
				SpringLayout.NORTH, container);
		container.add(tfEndereco);
		layout.putConstraint(SpringLayout.WEST, tfEndereco, 65,
				SpringLayout.WEST, lEndereco);
		layout.putConstraint(SpringLayout.NORTH, tfEndereco, 110,
				SpringLayout.NORTH, container);

		container.add(lCelular);
		layout.putConstraint(SpringLayout.WEST, lCelular, 30,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lCelular, 140,
				SpringLayout.NORTH, container);
		container.add(tfCelular);
		layout.putConstraint(SpringLayout.WEST, tfCelular, 65,
				SpringLayout.WEST, lCelular);
		layout.putConstraint(SpringLayout.NORTH, tfCelular, 140,
				SpringLayout.NORTH, container);
		
		container.add(lTelefone);
		layout.putConstraint(SpringLayout.WEST, lTelefone, 30,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lTelefone, 170,
				SpringLayout.NORTH, container);
		container.add(tfTelefone);
		layout.putConstraint(SpringLayout.WEST, tfTelefone, 65,
				SpringLayout.WEST, lTelefone);
		layout.putConstraint(SpringLayout.NORTH, tfTelefone, 170,
				SpringLayout.NORTH, container);
		
		container.add(btLimpar);
		layout.putConstraint(SpringLayout.WEST, btLimpar, 130,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btLimpar, 240,
				SpringLayout.NORTH, container);
		container.add(btCadastrar);
		layout.putConstraint(SpringLayout.WEST, btCadastrar, 30,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btCadastrar, 240,
				SpringLayout.NORTH, container);
		container.add(btFechar);
		layout.putConstraint(SpringLayout.WEST, btFechar, 30,
				SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, btFechar, 270,
				SpringLayout.NORTH, container);
		
		container.add(lGrupoUsuario);
		layout.putConstraint(SpringLayout.WEST, lGrupoUsuario, 30, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.NORTH, lGrupoUsuario, 200, SpringLayout.NORTH, container);
		
		container.add(comboGrupoUsuario);
		layout.putConstraint(SpringLayout.WEST, comboGrupoUsuario, 65, SpringLayout.WEST, lGrupoUsuario);
		layout.putConstraint(SpringLayout.NORTH, comboGrupoUsuario, 200, SpringLayout.NORTH, container);

		btLimpar.addActionListener(this);
		btCadastrar.addActionListener(this);
		btFechar.addActionListener(this);

		this.pack();
		this.setResizable(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setTitle("Cadastro de Novo Entregador");
		this.setSize(875, 300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btCadastrar) {
			
			EntregadorModel novo = new EntregadorModel();
			novo.setNome(tfNome.getText());
			novo.setCpf(tfCpf.getText());
			novo.setEndereco(tfEndereco.getText());
			novo.setCelular(tfCelular.getText());
			novo.setTelefone(tfTelefone.getText());
			
			GrupoUsuarioModel selecionaEntregador = (GrupoUsuarioModel) comboGrupoUsuario.getSelectedItem();
			
			novo.setIdGrupoUsuario(selecionaEntregador.getId());
			
			controller.cadastrarEntregador(novo);
			
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
		tfCelular.setText("");
		tfTelefone.setText("");
	}
	
}

