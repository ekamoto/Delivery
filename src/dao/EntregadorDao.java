package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ClienteModel;
import model.EntregadorModel;
import model.GrupoUsuarioModel;
import conexao.Conexao;

public class EntregadorDao extends Conexao {
	
	public EntregadorDao() {

	}

	public boolean cadastrar(EntregadorModel entregador) {
		
		abreConexao();
		
		try {
			PreparedStatement pst = null;
			
			String sql = "insert into pessoas(nome, cpf, endereco, celular, telefone, idGrupoUsuarios)"
					+ "values(?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, entregador.getNome());
			pst.setString(2, entregador.getCpf());
			pst.setString(3, entregador.getEndereco());
			pst.setString(4, entregador.getCelular());
			pst.setString(5, entregador.getTelefone());
			pst.setInt(6, entregador.getIdGrupoUsuario());
			
			pst.execute();
			pst.close();
			
			con.commit();
		} catch(SQLException e1) {
			
			try{
				con.rollback();
				System.out.println("Rollback na inserção de entregador");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out
				.println("Falha so executar rollback na inserção de entregador");
			}
			e1.printStackTrace();
			return false;
		}
		fechaConexao();
		return true;
	}
	
	public List<EntregadorModel> getEntregador() {
		
		List<EntregadorModel> resultado = new ArrayList<EntregadorModel>();
		abreConexao();
		
		try {
			PreparedStatement pst = null;
			String sql = "select pessoas.id as idPessoa, pessoas.nome, pessoas.cpf, pessoas.endereco, "
					+ "pessoas.celular, pessoas.telefone, pessoas.idGrupoUsuarios," +
					" grupoUsuarios.id as idGrupoUsuarios, grupoUsuarios.descricao "+
					" from pessoas  " +
					"inner join grupoUsuarios on (pessoas.idGrupoUsuarios = grupoUsuarios.id) "
					+ "and idGrupoUsuarios = 2";
			
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("idPessoa");
				String email = rs.getString("nome");
				
				GrupoUsuarioModel grupoUsuarioModel = new GrupoUsuarioModel();
				EntregadorModel temp = new EntregadorModel();
				temp.setId(rs.getString("idPessoa"));
				temp.setNome(rs.getString("nome"));
				temp.setCpf(rs.getString("cpf"));
				temp.setEndereco(rs.getString("endereco"));
				temp.setCelular(rs.getString("celular"));
				temp.setTelefone(rs.getString("telefone"));
				temp.setIdGrupoUsuario(rs.getInt("idGrupoUsuarios"));
				
				grupoUsuarioModel.setDescricao(rs.getString("descricao"));
				grupoUsuarioModel.setId(rs.getInt("idGrupoUsuarios"));
				temp.setGrupoUsuarioModel(grupoUsuarioModel);
				
				resultado.add(temp);
			}
			pst.close();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		fechaConexao();

		return resultado;
	}
	
	public EntregadorModel getEntregadorId(int idEntregador) {
		
		EntregadorModel entregador = new EntregadorModel();
		abreConexao();
		
		try{
			PreparedStatement pst = null;
			
			String sql = "select * from pessoas where id = ? and idGrupoUsuarios = 2";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, idEntregador);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				entregador.setId(rs.getString("id"));
				entregador.setNome(rs.getString("nome"));
				entregador.setCpf(rs.getString("cpf"));
				entregador.setEndereco(rs.getString("endereco"));
			}
			pst.close();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		fechaConexao();

		return entregador;
	}
	
	public boolean deletarEntregador(int idEntregador) {
		
		abreConexao();
		
		try {

			PreparedStatement pst = null;

			String sql = "delete from pessoas where id=? ";

			pst = con.prepareStatement(sql);
			pst.setInt(1, idEntregador);

			pst.execute();
			pst.close();

			con.commit();

		} catch (SQLException e1) {

			try {

				con.rollback();
				System.out.println("Rollback delete de entregador");
			} catch (SQLException e) {

				e.printStackTrace();
				System.out
						.println("Falha so executar rollback deletar entregador");
			}
			e1.printStackTrace();
			return false;
		}

		fechaConexao();
		
		return true;
	}
}
