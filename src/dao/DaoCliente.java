package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;

import conexao.Conexao;

public class DaoCliente extends Conexao {
	
	public DaoCliente() {
		
	}
	
	public boolean cadastrar(Cliente cliente) {
		
		abreConexao();
		
		try {
			
			PreparedStatement pst = null;
			
			String sql = "insert into pessoas (nome, cpf, endereco)" +
					"values(?, ?, ?)";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, cliente.getNome());
	        pst.setString(2, cliente.getCpf());
	        pst.setString(3, cliente.getEndereco());
	          
	        pst.execute();
			
		} catch (SQLException e1) {
		
			e1.printStackTrace();
			return false;
		}
		
		fechaConexao();
		
		return true;
	}
}