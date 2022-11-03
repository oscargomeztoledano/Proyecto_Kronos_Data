package persistencia;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

public class GestorBD {
	protected static GestorBD mInstancia = null;
	// Conexion con la base de datos
	protected static Connection mBD;
	// Identificador ODBC de la base de datos
	private static String url = "titulospropiosuclm2022.cq9ufzvy2if8.eu-west-3.rds.amazonaws.com";
	// Driven para conectar con bases de datos MySQL
	private static String driver2="org.postgresql.Driver";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String user = "admin";
	private static String password = "admin1234";
	private static Connection getRemoteConnection() {
		Connection con =null;
	      try {
	      Class.forName(driver);
	      String dbName = "titulospropiosuclm2022";
	      String userName = "admin";
	      String password = "admin1234";
	      String hostname = "titulospropiosuclm2022.cq9ufzvy2if8.eu-west-3.rds.amazonaws.com";
	      String port = "3306";
	      String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
	      
	       con = DriverManager.getConnection(jdbcUrl);
	      
	      return con;
	    }
	    catch (ClassNotFoundException e) { e.printStackTrace();}
	    catch (SQLException e) {e.printStackTrace(); }
		return con;
	    }
	    
	  
	public static void conectarBD() throws ClassNotFoundException, SQLException {
		try {
			Class.forName(driver);
	mBD=getRemoteConnection();
			mBD.setAutoCommit(true);
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void desconectarBD() throws SQLException {
		try {
			mBD.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static Vector<Object> ExecuteQuery(String SQL) throws ClassNotFoundException { // Sacar datos de BD
		try {
		
			conectarBD();
			Statement st = mBD.createStatement();
			ResultSet result = st.executeQuery(SQL);
			Vector<Object> v = obtenerResulset(result);
			st.close();
			desconectarBD();
			return v;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	public static Vector<Object> oneExecuteQuery(String SQL) throws Exception {
		try {
			

			conectarBD();
			Statement st = mBD.createStatement();
			ResultSet result = st.executeQuery(SQL);
			Vector<Object> v = OneResulset(result);
			st.close();
			desconectarBD();
			return v;
		} catch (SQLException e) {
			return null;
		}
	}

	public static void ExecuteUpdate(String SQL) throws ClassNotFoundException { // Updates a BD
		try {

			conectarBD();
			Statement st = mBD.createStatement();
			st.executeUpdate(SQL);
			st.close();
			desconectarBD();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	public static Vector<Object> obtenerResulset(ResultSet result) throws SQLException {
		Vector<Object> vectoradevolver = new Vector<Object>();
		while (result.next()) {
			Vector<Object> v = new Vector<Object>();
			int i = 1;
			while (true) {
				try {
					v.add(result.getObject(i));
					i++;
				} catch (SQLException ex) {
					break;
				}
			}
			vectoradevolver.add(v);
		}
		return vectoradevolver;
	}

	public static Vector<Object> OneResulset(ResultSet result) throws SQLException {
		Vector<Object> v = new Vector<Object>();

		while (result.next()) {
			for(int i=1;i<20;i++) {
				try {
					v.add(result.getObject(i));
				
				} catch (SQLException ex) {
					continue;
				}
			}
		}
		
		return v;
	}
}