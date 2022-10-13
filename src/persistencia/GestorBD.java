package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class GestorBD {
	protected static GestorBD mInstancia = null;
	// Conexion con la base de datos
	protected static Connection mBD;
	// Identificador ODBC de la base de datos
	private static String url = "jdbc:mysql://localhost:3306/titulospropiosuclm2022?user=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	// Driven para conectar con bases de datos MySQL
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String user = "root";
	private static String password = "victor";
	

	public static void conectarBD() throws  SQLException {
		try {
			Class.forName(driver);
			mBD = DriverManager.getConnection(url, "root", "victor");
			mBD.setAutoCommit(true);
			System.out.println("Conectado");
			
		} catch (Exception e) {
			   System.out.println("Error al registrar el driver de MySQL: " + e);	
          }

	}

	public static void desconectarBD() throws SQLException {
		try {
			mBD.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void select(String sql) {
		// TODO - implement GestorBD.select
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 */
	public int insert(String sql) {
		// TODO - implement GestorBD.insert
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 */
	public int update(String sql) {
		// TODO - implement GestorBD.update
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 */
	public int delete(String sql) {
		// TODO - implement GestorBD.delete
		throw new UnsupportedOperationException();
	}

	public void operation() {
		// TODO - implement GestorBD.operation
		throw new UnsupportedOperationException();
	}

}
