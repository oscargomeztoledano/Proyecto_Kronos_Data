package persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

public class GestorBDTest {
	protected static Connection mBD;

@Test

public void testgetRemoteConnection(){
	Connection con;
	String user="KronoUCLM";
	String pass="Krono_data";
	String connectionUrl = "jdbc:sqlserver://krono-data.database.windows.net:1433;"+"databaseName=Krono_Data;"  
			 + "encrypt=true;"
			+ "trustServerCertificate=false;" + "loginTimeout=30;";

	
	try {
		if((con = DriverManager.getConnection(connectionUrl,user,pass)).equals(null)) {
			Assert.assertNull(con);

		}else {
			Assert.assertNotNull(con);

		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		con=null;
	}
}
@Test
public void testconectarBD() throws ClassNotFoundException, SQLException {
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


	mBD = GestorBD.getRemoteConnection();
	Assert.assertNotNull(mBD);
	mBD.setAutoCommit(true);
	
}
@Test
public void testexecuteQuery() throws ClassNotFoundException, SQLException {
	String sql="Select * From Usuarios";
	mBD= GestorBD.getRemoteConnection();
	Statement st = mBD.createStatement();
	ResultSet result = st.executeQuery(sql);
	Vector<Object> v = GestorBD.obtenerResulset(result);
	Assert.assertNotNull(v);
	st.close();
	GestorBD.desconectarBD();
}
public void testobtenerResulset() throws SQLException {
	String sql="Select * From Usuarios";
	Vector<Object> vectoradevolver = new Vector<>();
	Statement st = mBD.createStatement();
	ResultSet result = st.executeQuery(sql);
	while (result.next()) {
		Vector<Object> v = new Vector<>();
		int i = 1;
		while (true) {
			try {
				v.add(result.getObject(i));
				Assert.assertNotNull(v);

				i++;
			} catch (SQLException ex) {
				break;
			}
		}
		vectoradevolver.add(v);
	}
	Assert.assertNotNull(vectoradevolver);
	
	
}

}
