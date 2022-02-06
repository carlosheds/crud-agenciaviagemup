package br.com.agenciaup.factory;
import java.sql.Connection;
import java.sql.DriverManager;

public class AgenciaFactory {
		public static Connection createConnectionSQLServer() throws Exception {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// Faz com que a classe seja carregada pela JVM

			// Cria conexão com BD SEM a senha
			Connection connection = DriverManager
					.getConnection("jdbc:sqlserver://localhost;databaseName=CrudAgenciaViagemUp;integratedSecurity=true;");

			// Cria conexão com BD COM a senha
			// Connection connection =
			// DriverManager.getConnection("jdbc:sqlserver://DESKTOP-BNA36V5;","usuário","senha");

			return connection;
		}

		public static void main(String[] args) throws Exception {
			// Recupera uma conexão com o banco de dados
			Connection con = createConnectionSQLServer();
			
			//Testar se a conexão é nula
			if(con != null) {
				System.out.println("Conexão obtida com sucesso! " + con);
				con.close();
			}
		}
	}
