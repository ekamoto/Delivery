package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

import model.ClienteModel;
import model.ProdutoModel;

public class ProdutoDao extends Conexao {
	
	
	public ProdutoDao() {

	}
	
	public boolean cadastrar(ProdutoModel produto) {

		abreConexao();

		try {

			PreparedStatement pst = null;

			String sql = "insert into produtos (nome, descricao, quantidade, valor) values(?, ?, ?, ?)";

			pst = con.prepareStatement(sql);
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getDescricao());
			pst.setInt(3, produto.getQuantidade());
			pst.setDouble(4, produto.getValor());

			pst.execute();
			pst.close();

			con.commit();
			System.out.println("Produto inserido com sucesso!");
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

		} catch (SQLException e1) {

			try {

				con.rollback();
				System.out.println("Rollback na inserção de produto");
			} catch (SQLException e) {

				e.printStackTrace();
				System.out
						.println("Falha so executar rollback na inserção de produto");
			}
			e1.printStackTrace();
			return false;
		}

		fechaConexao();

		return true;
	}

	public List<ProdutoModel> getProdutos() {

		List<ProdutoModel> resultado = new ArrayList<ProdutoModel>();

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

//				ClienteModel temp = new ClienteModel();
//				temp.setId(rs.getString("id"));
//				temp.setNome(rs.getString("nome"));
//				temp.setCpf(rs.getString("cpf"));
//				temp.setEndereco(rs.getString("endereco"));
//				resultado.add(temp);
			}

			pst.close();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		fechaConexao();

		return resultado;
	}

	public ProdutoModel getClienteID(int idCliente) {

		ProdutoModel cliente = new ProdutoModel();

		abreConexao();

		try {

			PreparedStatement pst = null;

			String sql = "select * from pessoas where id = ? ";

			pst = con.prepareStatement(sql);
			pst.setInt(1, idCliente);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

//				cliente.setId(rs.getString("id"));
//				cliente.setNome(rs.getString("nome"));
//				cliente.setCpf(rs.getString("cpf"));
//				cliente.setEndereco(rs.getString("endereco"));
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
