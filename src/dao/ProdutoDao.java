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

			String sql = "insert into produtos (nome, descricao, quantidade, valor, ativo) values(?, ?, ?, ?, ?)";

			pst = con.prepareStatement(sql);
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getDescricao());
			pst.setInt(3, produto.getQuantidade());
			pst.setDouble(4, produto.getValor());
			pst.setBoolean(5, true);

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

			String sql = "select * from produtos";

			pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				System.out.println("Entrou aqui");
				ProdutoModel temp = new ProdutoModel();
				temp.setId(Integer.parseInt(rs.getString("id")));
				temp.setNome(rs.getString("nome"));
				temp.setDescricao(rs.getString("descricao"));
				temp.setQuantidade(rs.getInt("quantidade"));
				temp.setValor(rs.getDouble("valor"));
				temp.setAtivo(rs.getBoolean("ativo"));

				resultado.add(temp);
			}

			pst.close();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		fechaConexao();

		return resultado;
	}

	public ProdutoModel getProdutoID(int idProduto) {

		ProdutoModel produto = new ProdutoModel();

		abreConexao();

		try {

			PreparedStatement pst = null;

			String sql = "select * from produtos where id = ? ";

			pst = con.prepareStatement(sql);
			pst.setInt(1, idProduto);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValor(rs.getFloat("valor"));
				produto.setAtivo(rs.getBoolean("ativo"));
			}

			pst.close();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		fechaConexao();

		return produto;
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
	
	public boolean desativarProduto(int idProduto) {
		
		ProdutoModel produto = getProdutoID(idProduto);
		
		if(!produto.getNome().equals("")) {
			
			try {
				
				abreConexao();
				
				PreparedStatement pst = null;

				String sql = "update produtos set ativo=false where id=? ";

				pst = con.prepareStatement(sql);
				pst.setInt(1, idProduto);

				pst.execute();
				pst.close();

				con.commit();
				
				fechaConexao();
				return true;
			}catch (SQLException e1) {
				
				return false;
			}
			
		} else {
			
			return false;
		}
	}
	
	public boolean ativarProduto(int idProduto) {
		
		ProdutoModel produto = getProdutoID(idProduto);
		
		if(!produto.getNome().equals("")) {
			
			try {
				
				abreConexao();
				
				PreparedStatement pst = null;

				String sql = "update produtos set ativo=true where id=? ";

				pst = con.prepareStatement(sql);
				pst.setInt(1, idProduto);

				pst.execute();
				pst.close();

				con.commit();
				
				fechaConexao();
				return true;
			}catch (SQLException e1) {
				
				return false;
			}
			
		} else {
			
			return false;
		}
	}
}
