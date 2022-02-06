package br.com.agenciaup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.agenciaup.factory.AgenciaFactory;
import br.com.agenciaup.model.Cliente;

public class ClienteDAO {
	public void save(Cliente cliente) {
		String sql = "INSERT INTO cliente(nome,idade)" + " VALUES (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = AgenciaFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			
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
		
	}
}