package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * 
 * Classe para gerenciar conexão com o banco de dados
 * Postgres
 * 
 * @author Leandro Shindi Ekamoto
 * 
 */
public class Conexao {

	private String bd = "delivery";
	private String url = "jdbc:postgresql://localhost:5432/";
	private String usuario = "postgres";
	private String senha = "analisesistemas";
	private String driver = "org.postgresql.Driver";
	public Connection con;

	public Conexao() {

	}

	public Connection abreConexao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException cnfe) {
			
			JOptionPane.showMessageDialog(null, "Driver não encontrado!!");
			cnfe.printStackTrace();
		}
		try {
			
			con = DriverManager.getConnection(url + bd, usuario, senha);
			System.out.println("Banco conectado com sucesso!");
		} catch (SQLException se) {
			
			System.out.println("Falha ao conectar banco de dados:");
			se.printStackTrace();
		}
		return con;
	}
	
	public void fechaConexao() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
