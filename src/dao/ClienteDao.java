package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.Delivery;
import model.ClienteModel;

import conexao.Conexao;

public class ClienteDao extends Conexao {

	public ClienteDao() {

	}

	public boolean cadastrar(ClienteModel cliente) {

		abreConexao();

		try {

			PreparedStatement pst = null;

			String sql = "insert into pessoas (nome, cpf, endereco)"
					+ "values(?, ?, ?)";

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
				System.out
						.println("Falha so executar rollback na inserção de cliente");
			}
			e1.printStackTrace();
			return false;
		}

		fechaConexao();

		return true;
	}

	public List<ClienteModel> getClientes() {

		List<ClienteModel> resultado = new ArrayList<ClienteModel>();

		abreConexao();

		try {

			PreparedStatement pst = null;

			String sql = "select * from pessoas";

			pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String id = rs.getString("id");
				String email = rs.getString("nome");
				System.out.println(id + " :: " + email);

				ClienteModel temp = new ClienteModel();
				temp.setId(rs.getString("id"));
				temp.setNome(rs.getString("nome"));
				temp.setCpf(rs.getString("cpf"));
				temp.setEndereco(rs.getString("endereco"));
				resultado.add(temp);
			}

			pst.close();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		fechaConexao();

		return resultado;
	}

	public ClienteModel getClienteID(int idCliente) {

		ClienteModel cliente = new ClienteModel();

		abreConexao();

		try {

			PreparedStatement pst = null;

			String sql = "select * from pessoas where id = ? ";

			pst = con.prepareStatement(sql);
			pst.setInt(1, idCliente);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				cliente.setId(rs.getString("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));
			}

			pst.close();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		fechaConexao();

		return cliente;
	}

	public boolean deletarCliente(int idCliente) {

		abreConexao();

		try {

			PreparedStatement pst = null;

			String sql = "delete from pessoas where id=? ";

			pst = con.prepareStatement(sql);
			pst.setInt(1, idCliente);

			pst.execute();
			pst.close();

			con.commit();
			System.out.println("Cliente deletado com sucesso!");

		} catch (SQLException e1) {

			try {

				con.rollback();
				System.out.println("Rollback delete de cliente");
			} catch (SQLException e) {

				e.printStackTrace();
				System.out
						.println("Falha so executar rollback deletar de cliente");
			}
			e1.printStackTrace();
			return false;
		}

		fechaConexao();

		return true;
	}
}