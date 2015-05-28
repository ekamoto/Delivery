package conexao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import java.io.File;

import crypt.FileCrypt;

/**
 * 
 * Classe para gerenciar conexão com o banco de dados Postgres
 * 
 * @author Leandro Shindi Ekamoto
 * 
 */
public class Conexao {

	private static String bd = "";
	private static String url = "";
	private static String usuario = "";
	private static String senha = "";
	private static String driver = "org.postgresql.Driver";
	public Connection con;

	public Conexao() {

	}

	public void removerArquivos(String caminho) {

		File f = new File(caminho);
		f.delete();
	}

	public void carregaDadosConfiguracao() {

		if (this.url.equals("")) {

			FileCrypt cripto = new FileCrypt("Delivery");
			try {
				cripto.descriptografa(new FileInputStream("src/conf/config"),
						new FileOutputStream("src/conf/temp"));
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidAlgorithmParameterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			BufferedReader buffRead = null;
			try {
				buffRead = new BufferedReader(new FileReader("src/conf/temp"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String linha = "";
			int j = 0;

			while (true) {

				if (linha != null) {

					linha = linha.replaceAll(" ", "");

					if (j == 1) {

						// Servidor
						this.url = "jdbc:postgresql:" + linha;
					} else if (j == 2) {

						// Usuário
						this.usuario = linha;
					} else if (j == 3) {

						// Senha
						this.senha = linha;
					} else if (j == 4) {

						// banco
						this.bd = linha;
					}

					// System.out.println("-"+linha);
					j++;
				} else
					break;

				try {
					linha = buffRead.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				buffRead.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("url:" + this.url);
			System.out.println("bd:" + this.bd);
			System.out.println("usuario:" + this.usuario);
			System.out.println("senha:" + this.senha);

			removerArquivos("src/conf/temp");

		} else {

			System.out
					.println("Não leu o arquivo outra vez, isso porque já foi salvo na classe");

		}
	}

	public Connection abreConexao() {

		carregaDadosConfiguracao();

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException cnfe) {

			JOptionPane.showMessageDialog(null, "Driver não encontrado!!");
			cnfe.printStackTrace();
		}
		try {

			String url = this.url + this.bd;
			con = DriverManager.getConnection(url, this.usuario, this.senha);
			System.out.println("Banco conectado com sucesso!");
			con.setAutoCommit(false);
		} catch (SQLException se) {

			System.out.println("Falha ao conectar banco de dados:");
			se.printStackTrace();
		}
		return con;
	}

	public void fechaConexao() {
		try {
			con.close();
			System.out.println("Banco de dados fechado com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
