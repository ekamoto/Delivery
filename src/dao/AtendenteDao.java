package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AtendenteModel;
import model.GrupoUsuarioModel;
import conexao.Conexao;
import enums.EnumStatusPessoa;

public class AtendenteDao extends Conexao{
	
	public AtendenteDao() {
		
	}

	public boolean cadastrar(AtendenteModel atendente) {

		abreConexao();

		try {

			PreparedStatement pst = null;

			String sql = "insert into pessoas (nome, cpf, endereco, celular, telefone, idGrupoUsuarios, status)"
					+ "values(?, ?, ?, ?, ?, ?, ?)";

			pst = con.prepareStatement(sql);
			pst.setString(1, atendente.getNome());
			pst.setString(2, atendente.getCpf());
			pst.setString(3, atendente.getEndereco());
			pst.setString(4, atendente.getCelular());
			pst.setString(5, atendente.getTelefone());
			pst.setInt(6, atendente.getIdGrupoUsuario());
			pst.setInt(7, EnumStatusPessoa.ATIVO.getStatus());

			pst.execute();
			pst.close();

			con.commit();
			System.out.println("Atendente inserido com sucesso!");

		} catch (SQLException e1) {

			try {

				con.rollback();
				System.out.println("Rollback na inserção de atendente");
			} catch (SQLException e) {

				e.printStackTrace();
				System.out
						.println("Falha so executar rollback na inserção de atendente");
			}
			e1.printStackTrace();
			return false;
		}

		fechaConexao();

		return true;
	}
	
	public List<AtendenteModel> getAtendentes() {
		
		List<AtendenteModel> resultado = new ArrayList<AtendenteModel>();
		abreConexao();
		
		try {

			PreparedStatement pst = null;

			String sql = "select pessoas.id as idPessoa, pessoas.nome, pessoas.cpf, pessoas.endereco, "
					+ "pessoas.celular, pessoas.telefone, pessoas.idGrupoUsuarios, pessoas.status, " +
					" grupoUsuarios.id as idGrupoUsuarios, grupoUsuarios.descricao "+
					" from pessoas  " +
					"inner join grupoUsuarios on (pessoas.idGrupoUsuarios = grupoUsuarios.id) "
					+ "and idGrupoUsuarios = 3";

			pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String id = rs.getString("idPessoa");
				String email = rs.getString("nome");
				System.out.println(id + " :: " + email);
				
				GrupoUsuarioModel grupoUsuarioModel = new GrupoUsuarioModel();

				AtendenteModel temp = new AtendenteModel();
				temp.setId(rs.getString("idPessoa"));
				temp.setNome(rs.getString("nome"));
				temp.setCpf(rs.getString("cpf"));
				temp.setEndereco(rs.getString("endereco"));
				temp.setCelular(rs.getString("celular"));
				temp.setTelefone(rs.getString("telefone"));
				temp.setIdGrupoUsuario(rs.getInt("idGrupoUsuarios"));
				temp.setStatus(rs.getInt("status"));
				
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
	
	public AtendenteModel getAtendenteId(int idAtendente) {
		AtendenteModel atendente = new AtendenteModel();
		abreConexao();
		
		try {
			PreparedStatement pst = null;
			String sql = "select * from pessoas where id = ? and idGrupoUsuarios = 3";
			pst = con.prepareStatement(sql);
			pst.setInt(1, idAtendente);
			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				atendente.setId(rs.getString("id"));
				atendente.setNome(rs.getString("nome"));
				atendente.setCpf(rs.getString("cpf"));
				atendente.setEndereco(rs.getString("endereco"));
				atendente.setCelular(rs.getString("celular"));
				atendente.setTelefone(rs.getString("telefone"));
				atendente.setStatus(rs.getInt("status"));
			}

			pst.close();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		fechaConexao();

		return atendente;
	}
	
	public boolean deletarAtendente(int idAtendente) {

		abreConexao();

		try {

			PreparedStatement pst = null;

			String sql = "delete from pessoas where id=? ";

			pst = con.prepareStatement(sql);
			pst.setInt(1, idAtendente);

			pst.execute();
			pst.close();

			con.commit();
			System.out.println("Atendente deletado com sucesso!");

		} catch (SQLException e1) {

			try {

				con.rollback();
				System.out.println("Rollback delete de Atendente");
			} catch (SQLException e) {

				e.printStackTrace();
				System.out
						.println("Falha so executar rollback deletar de atendente");
			}
			e1.printStackTrace();
			return false;
		}

		fechaConexao();

		return true;
	}
	
	public boolean desativarAtendente(int idAtendente) {
		
		AtendenteModel atendente = getAtendenteId(idAtendente);
		
		if(atendente != null && !atendente.getNome().equals("")) {
			try {
				abreConexao();
				PreparedStatement pst = null;
				String sql = "update pessoas set status=? where id=? ";
				
				pst = con.prepareStatement(sql);
				
				pst.setInt(1, EnumStatusPessoa.INATIVO.getStatus());
				pst.setInt(2, idAtendente);
				
				pst.execute();
				pst.close();
				
				con.commit();
				fechaConexao();
				return true;
			} catch (SQLException e1) {
				return false;
			}
		}else {
			return false;
		}
	} 
	
	public boolean ativarProduto (int idAtendente) {
		
		AtendenteModel atendente = getAtendenteId(idAtendente);
		
		if(!atendente.getNome().equals("")) {
			try {
				abreConexao();
				
				PreparedStatement pst = null;

				String sql = "update pessoas set status=? where id=? ";

				pst = con.prepareStatement(sql);
				pst.setInt(1, EnumStatusPessoa.ATIVO.getStatus());
				pst.setInt(2, idAtendente);

				pst.execute();
				pst.close();

				con.commit();
				
				fechaConexao();
				return true;
				} catch (SQLException e1) {
				return false;
				}
		}else {
			return false;
		}
	}
}
