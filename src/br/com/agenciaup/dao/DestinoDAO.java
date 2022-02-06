package br.com.agenciaup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenciaup.factory.AgenciaFactory;
import br.com.agenciaup.model.Destino;

public class DestinoDAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private String sqlQuery;
	
	public void save(Destino destino) {
		sqlQuery = "INSERT INTO destino(cidade, estado, pais)" + " VALUES (?, ?, ?)";
		
		try {
			conn = AgenciaFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sqlQuery);
			
			pstm.setString(1, destino.getCidade());
			pstm.setString(2, destino.getEstado());
			pstm.setString(3, destino.getPais());
			
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
		sqlQuery = "DELETE FROM destino WHERE id_destino = ?";
		
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

	public void update(Destino destino,int id) {
		sqlQuery = "UPDATE destino SET cidade = ?, estado = ?, pais = ? WHERE id_destino = ?";
		
		try {
			conn = AgenciaFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sqlQuery);
			
			pstm.setString(1, destino.getCidade());
			pstm.setString(2, destino.getEstado());
			pstm.setString(3, destino.getPais());
			pstm.setInt(4, id);
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

	public List<Destino> getDestinos() {
		sqlQuery = "Select * FROM destino";
		
		List<Destino> destinos = new ArrayList<Destino>();
		
		ResultSet rset = null;
		
		try {
			conn = AgenciaFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sqlQuery);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Destino destino = new Destino();
				destino.setId_destino(rset.getInt("id_destino"));
				destino.setCidade(rset.getString("cidade"));
				destino.setEstado(rset.getString("estado"));
				destino.setPais(rset.getString("pais"));
				
				destinos.add(destino);
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
		return destinos;
	}
}
