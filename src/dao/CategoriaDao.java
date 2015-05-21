package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CategoriaModel;
import conexao.Conexao;

public class CategoriaDao extends Conexao{

	public CategoriaDao() {
		
	}
	
	public boolean cadastrar(CategoriaModel categoria) {
		abreConexao();
		
		try {

			PreparedStatement pst = null;

			String sql = "insert into categoria (nome, descricao)"
					+ "values(?, ?)";

			pst = con.prepareStatement(sql);
			pst.setString(1, categoria.getNome());
			pst.setString(2, categoria.getDescricao());

			pst.execute();
			pst.close();

			con.commit();
			System.out.println("Categoria inserid1 com sucesso!");

		} catch (SQLException e1) {

			try {

				con.rollback();
				System.out.println("Rollback na inserção de categoria");
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
	
	public List<CategoriaModel> getCategorias() {
		List<CategoriaModel> resultado = new ArrayList<CategoriaModel>();

		abreConexao();

		try {

			PreparedStatement pst = null;

			String sql = "select * from categoria";

			pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("idcategoria");
				String nome = rs.getString("nome");
				System.out.println(id + " :: " + nome);

				CategoriaModel temp = new CategoriaModel();
				temp.setId(rs.getInt("idcategoria"));
				temp.setNome(rs.getString("nome"));
				temp.setDescricao(rs.getString("descricao"));
				resultado.add(temp);
			}

			pst.close();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		fechaConexao();

		return resultado;

	}
	
}
