package br.com.agenciaup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenciaup.factory.AgenciaFactory;
import br.com.agenciaup.model.Cliente;
import br.com.agenciaup.model.Destino;
import br.com.agenciaup.model.Passagem;

public class PassagemDAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private String sqlQuery;
	
	public void save(Passagem passagem) {
		sqlQuery = "INSERT INTO passagem(id_cliente,id_destino)" + " VALUES (?, ?)";
		
		try {
			conn = AgenciaFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sqlQuery);
			
			pstm.setInt(1, passagem.getId_cliente());
			pstm.setInt(2, passagem.getId_destino());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removeById(int id) {
		sqlQuery = "DELETE FROM passagem WHERE id_passagem = ?";
		
		try {
			conn = AgenciaFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sqlQuery);
			
			pstm.setInt(1, id);
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
				System.out.println("Sucesso");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Passagem passagem,int id) {
		sqlQuery = "UPDATE passagem SET id_cliente = ?, id_destino = ? WHERE id_passagem = ?";
		
		try {
			conn = AgenciaFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sqlQuery);
			
			pstm.setInt(1, passagem.getId_cliente());
			pstm.setInt(2, passagem.getId_destino());
			pstm.setInt(3, id);
			pstm.execute();
			
			System.out.println("Sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Passagem> getPassagens() {
		sqlQuery = "SELECT p.id_passagem, c.id_cliente, c.nome , d.id_destino, d.cidade, d.estado, d.pais FROM passagem AS p "
				+ "INNER JOIN cliente AS c ON p.id_cliente = c.id_cliente "
				+ "INNER JOIN destino AS d ON p.id_destino = d.id_destino";
		
		List<Passagem> passagens = new ArrayList<Passagem>();
		
		ResultSet rset = null;
		
		try {
			conn = AgenciaFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sqlQuery);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Passagem passagem = new Passagem();
				Cliente cliente = new Cliente(); 
				Destino destino = new Destino();
				passagem.setId_passagem(rset.getInt("id_passagem"));
				passagem.setId_cliente(rset.getInt("id_cliente"));
				passagem.setId_destino(rset.getInt("id_destino"));
				cliente.setId_cliente(rset.getInt("id_cliente"));
				cliente.setNome(rset.getString("nome"));
				destino.setId_destino(rset.getInt("id_destino"));
				destino.setCidade(rset.getString("cidade"));
				destino.setEstado(rset.getString("estado"));
				destino.setPais(rset.getString("pais"));
				passagem.setCliente(cliente);
				passagem.setDestino(destino);
				
				passagens.add(passagem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return passagens;
	}
}
