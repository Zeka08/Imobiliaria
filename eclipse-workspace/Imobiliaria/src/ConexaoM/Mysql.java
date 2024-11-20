package ConexaoM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
	 private static final String URL = "jdbc:mysql://localhost:3306/gestao_venda";
	    private static final String USER = "root";
	    private static final String PASSWORD = "240579";
	    
	    private static Connection connection = null;
	    
	    public static Connection getConnection() throws SQLException {
	        if (connection == null || connection.isClosed()) {
	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                connection = DriverManager.getConnection(URL, USER, PASSWORD);
	            } catch (ClassNotFoundException e) {
	                System.out.println("Driver não encontrado: " + e.getMessage());
	            }
	        }
	        return connection;
	    }
	}

