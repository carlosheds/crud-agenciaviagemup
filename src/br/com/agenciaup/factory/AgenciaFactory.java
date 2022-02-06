package br.com.agenciaup.factory;
import java.sql.Connection;
import java.sql.DriverManager;

public class AgenciaFactory {
		public static Connection createConnectionSQLServer() throws Exception {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// Faz com que a classe seja carregada pela JVM

			// Cria conex�o com BD SEM a senha
			Connection connection = DriverManager
					.getConnection("jdbc:sqlserver://localhost;databaseName=CrudAgenciaViagemUp;integratedSecurity=true;");

			// Cria conex�o com BD COM a senha
			// Connection connection =
			// DriverManager.getConnection("jdbc:sqlserver://DESKTOP-BNA36V5;","usu�rio","senha");

			return connection;
		}

		public static void main(String[] args) throws Exception {
			// Recupera uma conex�o com o banco de dados
			Connection con = createConnectionSQLServer();
			
			//Testar se a conex�o � nula
			if(con != null) {
				System.out.println("Conex�o obtida com sucesso! " + con);
				con.close();
			}
		}
	}
