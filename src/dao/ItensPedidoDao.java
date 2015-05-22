package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

import main.Delivery;
import model.ClienteModel;
import model.EntregadorModel;
import model.ItensPedidoModel;
import model.PedidoModel;
import model.ProdutoModel;
import enums.EnumStatusPedido;

public class ItensPedidoDao extends Conexao {
	
	public ItensPedidoDao() {

	}
	
	public boolean cadastrar(ItensPedidoModel Itenpedido) {

//		abreConexao();
//
//		try {
//
//			PreparedStatement pst = null;
//
//			String sql = "insert into pedidos (idCliente, idEntregador, valorPedido, valorPagamento, valorTroco, status) values(?, ?, ?, ?, ?, ?)";
//
//			System.out.println("idCliente:"+pedido.getCliente().getId());
//			
//			pst = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
//			pst.setInt(1, Integer.parseInt(pedido.getCliente().getId()));
//			pst.setInt(2, Integer.parseInt(pedido.getEntregador().getId()));
//			pst.setDouble(3, pedido.getValorPedido());
//			pst.setDouble(4, pedido.getValorPagamento());
//			pst.setDouble(5, pedido.getValorTroco());
//			pst.setInt(6, EnumStatusPedido.ADICIONADO.getStatus());
//
//			pst.execute();
//			
//			ResultSet rs = pst.getGeneratedKeys();
//			
//			int idPedidoInserido = 0;
//			
//			while(rs.next()) {
//				
//				idPedidoInserido = rs.getInt("id");
//			}
//			
//			List<ProdutoModel> listaProduto = new ArrayList<ProdutoModel>();
//			List<ProdutoModel> listaProduto2 = new ArrayList<ProdutoModel>();
//			
//			listaProduto =  pedido.getListaProduto();
//			int tamanho = listaProduto.size();
//			int tamanho2 = listaProduto2.size();
//			
//			boolean achou = false;
//			
//			for (int i = 0; i < tamanho; i++) {
//				
//				tamanho2 = listaProduto2.size();
//				achou = false;
//				//System.out.println("Produto:"+listaProduto.get(i).getNome());
//				
//				for (int j = 0; j < tamanho2; j++) {
//					if(listaProduto2.get(j).getNome() == listaProduto.get(i).getNome()) {
//						
//						listaProduto2.get(j).setQuantidade(listaProduto2.get(j).getQuantidade()+1);
//						achou = true;
//					}
//				}
//				if(!achou) {
//					
//					listaProduto.get(i).setQuantidade(1);
//					listaProduto2.add(listaProduto.get(i));
//				}
//			}
//			
//			
//			tamanho2 = listaProduto2.size();
//			for (int i = 0; i < tamanho2; i++) {
//				
//				
//				sql = "insert into itensPedido (idPedido, idProduto, valorUnitario, quantidade) values(?, ?, ?, ?)";
//				
//				pst = con.prepareStatement(sql);
//				pst.setInt(1, idPedidoInserido);
//				pst.setInt(2, listaProduto2.get(i).getId());
//				pst.setDouble(3, listaProduto2.get(i).getValor());
//				pst.setInt(4, listaProduto2.get(i).getQuantidade());
//				
//				pst.execute();
//				
//				System.out.println("Produto:"+listaProduto2.get(i).getNome()+" quantidade:"+listaProduto2.get(i).getQuantidade());
//			}
//			
//			pst.close();
//
//			con.commit();
//			System.out.println("Pedido inserido com sucesso!");
//			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
//
//		} catch (SQLException e1) {
//
//			try {
//
//				con.rollback();
//				System.out.println("Rollback na inserção de pedido");
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//				System.out
//						.println("Falha so executar rollback na inserção de pedido");
//			}
//			e1.printStackTrace();
//			return false;
//		}
//
//		fechaConexao();

		return true;
	}

	public List<ItensPedidoModel> getItensPedido(int idPedido) {

		List<ItensPedidoModel> resultado = new ArrayList<ItensPedidoModel>();

		abreConexao();

		try {

			PreparedStatement pst = null;

			String sql = "select * from itensPedido where idPedido=?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, idPedido);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				
				ItensPedidoModel temp = new ItensPedidoModel();
				
				temp.setIdPedido(rs.getInt("idPedido"));
				temp.setIdProduto(rs.getInt("idProduto"));
				temp.setQuantidade(rs.getInt("quantidade"));
				temp.setValorUnitario(rs.getDouble("valorUnitario"));

				resultado.add(temp);
			}
			

			pst.close();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		fechaConexao();

		return resultado;
	}

//	public ProdutoModel getProdutoID(int idProduto) {
//
//		ProdutoModel produto = new ProdutoModel();
//
//		abreConexao();
//
//		try {
//
//			PreparedStatement pst = null;
//
//			String sql = "select * from produtos where id = ? ";
//
//			pst = con.prepareStatement(sql);
//			pst.setInt(1, idProduto);
//
//			ResultSet rs = pst.executeQuery();
//
//			while (rs.next()) {
//
//				produto.setId(rs.getInt("id"));
//				produto.setNome(rs.getString("nome"));
//				produto.setDescricao(rs.getString("descricao"));
//				produto.setQuantidade(rs.getInt("quantidade"));
//				produto.setValor(rs.getFloat("valor"));
//				produto.setStatus(rs.getInt("status"));
//			}
//
//			pst.close();
//
//		} catch (SQLException e1) {
//
//			e1.printStackTrace();
//		}
//
//		fechaConexao();
//
//		return produto;
//	}
//
//	public boolean deletarCliente(int idCliente) {
//
//		abreConexao();
//
//		try {
//
//			PreparedStatement pst = null;
//
//			String sql = "delete from pessoas where id=? ";
//
//			pst = con.prepareStatement(sql);
//			pst.setInt(1, idCliente);
//
//			pst.execute();
//			pst.close();
//
//			con.commit();
//			System.out.println("Cliente deletado com sucesso!");
//
//		} catch (SQLException e1) {
//
//			try {
//
//				con.rollback();
//				System.out.println("Rollback delete de cliente");
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//				System.out
//						.println("Falha so executar rollback deletar de cliente");
//			}
//			e1.printStackTrace();
//			return false;
//		}
//
//		fechaConexao();
//
//		return true;
//	}
//	
//	public boolean desativarProduto(int idProduto) {
//		
//		ProdutoModel produto = getProdutoID(idProduto);
//		
//		if(!produto.getNome().equals("")) {
//			
//			try {
//				
//				abreConexao();
//				
//				PreparedStatement pst = null;
//
//				String sql = "update produtos set ativo=false where id=? ";
//
//				pst = con.prepareStatement(sql);
//				pst.setInt(1, idProduto);
//
//				pst.execute();
//				pst.close();
//
//				con.commit();
//				
//				fechaConexao();
//				return true;
//			}catch (SQLException e1) {
//				
//				return false;
//			}
//			
//		} else {
//			
//			return false;
//		}
//	}
//	
//	public boolean ativarProduto(int idProduto) {
//		
//		ProdutoModel produto = getProdutoID(idProduto);
//		
//		if(!produto.getNome().equals("")) {
//			
//			try {
//				
//				abreConexao();
//				
//				PreparedStatement pst = null;
//
//				String sql = "update produtos set ativo=true where id=? ";
//
//				pst = con.prepareStatement(sql);
//				pst.setInt(1, idProduto);
//
//				pst.execute();
//				pst.close();
//
//				con.commit();
//				
//				fechaConexao();
//				return true;
//			}catch (SQLException e1) {
//				
//				return false;
//			}
//			
//		} else {
//			
//			return false;
//		}
//	}
}
