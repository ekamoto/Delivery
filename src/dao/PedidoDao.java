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
import model.PedidoModel;
import model.ProdutoModel;

public class PedidoDao extends Conexao {
	
	
	private ClienteDao clienteDao = new ClienteDao();
	
	public PedidoDao() {

	}
	
	public boolean cadastrar(PedidoModel pedido) {

		abreConexao();

		try {

			PreparedStatement pst = null;

			String sql = "insert into pedidos (idCliente, idEntregador, valorPedido, valorPagamento, valorTroco, ativo) values(?, ?, ?, ?, ?, ?)";

			System.out.println("idCliente:"+pedido.getCliente().getId());
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(pedido.getCliente().getId()));
			pst.setInt(2, Integer.parseInt(pedido.getEntregador().getId()));
			pst.setDouble(3, pedido.getValorPedido());
			pst.setDouble(4, pedido.getValorPagamento());
			pst.setDouble(5, pedido.getValorTroco());
			pst.setBoolean(6, true);

			pst.execute();
			pst.close();

			con.commit();
			System.out.println("Pedido inserido com sucesso!");
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

		} catch (SQLException e1) {

			try {

				con.rollback();
				System.out.println("Rollback na inserção de pedido");
			} catch (SQLException e) {

				e.printStackTrace();
				System.out
						.println("Falha so executar rollback na inserção de pedido");
			}
			e1.printStackTrace();
			return false;
		}

		fechaConexao();

		return true;
	}

	public List<PedidoModel> getPedidos() {

		List<PedidoModel> resultado = new ArrayList<PedidoModel>();

		abreConexao();

		try {

			PreparedStatement pst = null;

			String sql = "select * from pedidos";

			pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				
				PedidoModel temp = new PedidoModel();
				temp.setId(rs.getInt("id"));
				
				ClienteModel cliente = clienteDao.getClienteID(rs.getInt("idCliente"));
				temp.setCliente(cliente);
				
				EntregadorModel temp1 = new EntregadorModel();
				
				for (int i = 0; i < Delivery.listaDeEntregador.size(); i++) {
					
					System.out.println("Id Entregador: "+Delivery.listaDeEntregador.get(i).getId()+"-"+rs.getString("idEntregador"));
					if(Integer.parseInt(Delivery.listaDeEntregador.get(i).getId().trim()) == Integer.parseInt(rs.getString("idEntregador").trim())) {

						temp1.setId(Delivery.listaDeEntregador.get(i).getId());
						temp1.setCpf(Delivery.listaDeEntregador.get(i).getCpf());
						temp1.setNome(Delivery.listaDeEntregador.get(i).getNome());
						temp1.setEndereco(Delivery.listaDeEntregador.get(i).getEndereco());
						temp1.setCarteiraDeTrabalho(Delivery.listaDeEntregador.get(i)
								.getCarteiraDeTrabalho());	
					}
				}
				
				temp.setEntregador(temp1);
				
				temp.setValorPagamento(rs.getDouble("valorPagamento"));
				temp.setValorPedido(rs.getDouble("valorPedido"));
				temp.setValorTroco(rs.getDouble("valorTroco"));
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
