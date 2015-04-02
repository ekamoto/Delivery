package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ClienteModel;

import conexao.Conexao;

public class ClienteDao extends Conexao {
	
	public ClienteDao() {
		
	}
	
	public boolean cadastrar(ClienteModel cliente) {
		
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
	        pst.close();
	        
	        con.commit();
	        System.out.println("Cliente inserido com sucesso!");
			
		} catch (SQLException e1) {
			
			try {
				
				con.rollback();
				System.out.println("Rollback na inserção de cliente");
			} catch (SQLException e) {

				e.printStackTrace();
				System.out.println("Falha so executar rollback na inserção de cliente");
			}
			e1.printStackTrace();
			return false;
		}
		
		fechaConexao();
		
		return true;
	}
}