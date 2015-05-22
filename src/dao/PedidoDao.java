package dao;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;
import controller.ProdutoController;
import enums.EnumStatusPedido;

import main.Delivery;
import model.ClienteModel;
import model.EntregadorModel;
import model.ItensPedidoModel;
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

			String sql = "insert into pedidos (idCliente, idEntregador, valorPedido, valorPagamento, valorTroco, status) values(?, ?, ?, ?, ?, ?)";

			System.out.println("idCliente:"+pedido.getCliente().getId());
			
			pst = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, Integer.parseInt(pedido.getCliente().getId()));
			pst.setInt(2, Integer.parseInt(pedido.getEntregador().getId()));
			pst.setDouble(3, pedido.getValorPedido());
			pst.setDouble(4, pedido.getValorPagamento());
			pst.setDouble(5, pedido.getValorTroco());
			pst.setInt(6, EnumStatusPedido.ADICIONADO.getStatus());

			pst.execute();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			int idPedidoInserido = 0;
			
			while(rs.next()) {
				
				idPedidoInserido = rs.getInt("id");
			}
			
			List<ProdutoModel> listaProduto = new ArrayList<ProdutoModel>();
			List<ProdutoModel> listaProduto2 = new ArrayList<ProdutoModel>();
			
			listaProduto =  pedido.getListaProduto();
			int tamanho = listaProduto.size();
			int tamanho2 = listaProduto2.size();
			
			boolean achou = false;
			
			for (int i = 0; i < tamanho; i++) {
				
				tamanho2 = listaProduto2.size();
				achou = false;
				//System.out.println("Produto:"+listaProduto.get(i).getNome());
				
				for (int j = 0; j < tamanho2; j++) {
					if(listaProduto2.get(j).getNome() == listaProduto.get(i).getNome()) {
						
						listaProduto2.get(j).setQuantidade(listaProduto2.get(j).getQuantidade()+1);
						achou = true;
					}
				}
				if(!achou) {
					
					listaProduto.get(i).setQuantidade(1);
					listaProduto2.add(listaProduto.get(i));
				}
			}
			
			
			tamanho2 = listaProduto2.size();
			for (int i = 0; i < tamanho2; i++) {
				
				
				sql = "insert into itensPedido (idPedido, idProduto, valorUnitario, quantidade) values(?, ?, ?, ?)";
				
				pst = con.prepareStatement(sql);
				pst.setInt(1, idPedidoInserido);
				pst.setInt(2, listaProduto2.get(i).getId());
				pst.setDouble(3, listaProduto2.get(i).getValor());
				pst.setInt(4, listaProduto2.get(i).getQuantidade());
				
				pst.execute();
				
				System.out.println("Produto:"+listaProduto2.get(i).getNome()+" quantidade:"+listaProduto2.get(i).getQuantidade());
			}
			
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
				
				ItensPedidoDao pedidoDao = new ItensPedidoDao();
				List<ItensPedidoModel> itensPedido = new ArrayList<ItensPedidoModel>();
				List<ProdutoModel> produtosPedido = new ArrayList<ProdutoModel>();
				
				itensPedido = pedidoDao.getItensPedido(temp.getId());

				int qtdItensPedido = itensPedido.size();
				
				ProdutoController produtoController = new ProdutoController();
				
				
				for (int i = 0; i < qtdItensPedido; i++) {
					
					ProdutoModel produtoModel = new ProdutoModel();
					produtoModel = produtoController.getProdutoID(itensPedido.get(i).getIdProduto());
					
					produtosPedido.add(produtoModel);
					
				}
				
				temp.setEntregador(temp1);
				
				temp.setValorPagamento(rs.getDouble("valorPagamento"));
				temp.setValorPedido(rs.getDouble("valorPedido"));
				temp.setValorTroco(rs.getDouble("valorTroco"));
				temp.setStatus(rs.getInt("status"));
				temp.setListaProduto(produtosPedido);

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
				produto.setStatus(rs.getInt("status"));
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
