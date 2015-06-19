package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FormaPagamentoModel;
import model.GrupoUsuarioModel;
import conexao.Conexao;

public class FormaPagamentoDao extends Conexao{

	public FormaPagamentoDao() {
		
	}
	
	public List<FormaPagamentoModel> getFormaPagamentos() {
		
		List<FormaPagamentoModel> resultado = new ArrayList<FormaPagamentoModel>();
		abreConexao();
		
		try {
			PreparedStatement pst = null;

			String sql = "select * from formaPagamento";

			pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				FormaPagamentoModel temp = new FormaPagamentoModel();
				temp.setId(rs.getString("id"));
				temp.setTipo(rs.getString("tipo"));
				
				//System.out.println("id:"+rs.getInt("id")+" Descrição:"+rs.getString("descricao"));
				resultado.add(temp);
			}

			pst.close();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		fechaConexao();
		
		return resultado;
	}
	
	public FormaPagamentoModel getFormaPagamentoId(int idFormaPagamento) {
		
		FormaPagamentoModel formaPagamento = new FormaPagamentoModel();
		
		abreConexao();
		
		try {

			PreparedStatement pst = null;

			String sql = "select * from formaPagamento where id = ? ";

			pst = con.prepareStatement(sql);
			pst.setInt(1, idFormaPagamento);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				formaPagamento.setId(rs.getString("id"));
				formaPagamento.setTipo(rs.getString("tipo"));
				
			}

			pst.close();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		fechaConexao();

		return formaPagamento;
		
	}
}
