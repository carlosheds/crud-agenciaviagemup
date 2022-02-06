package br.com.agenciaup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.agenciaup.factory.AgenciaFactory;
import br.com.agenciaup.model.Cliente;

public class ClienteDAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private String sqlQuery;
	
	public void save(Cliente cliente) {
		sqlQuery = "INSERT INTO cliente(nome,idade)" + " VALUES (?, ?)";
		
		try {
			conn = AgenciaFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sqlQuery);
			
			pstm.setString(1, cliente.getNome());
			pstm.setInt(2, cliente.getIdade());
			
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
		sqlQuery = "DELETE FROM cliente WHERE id_cliente = ?";
		
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
}