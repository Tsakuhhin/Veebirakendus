package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AndmeteLugemine  extends HttpServlet {

	private Connection con;
	String dbDriver = "org.postgresql.Driver";
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String data = "";
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();

		String dbDriver = "org.postgresql.Driver";
		try {
			URI dbUri = new URI(System.getenv("DATABASE_URL"));
			String username = dbUri.getUserInfo().split(":")[0];
			String password = dbUri.getUserInfo().split(":")[1];
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':'
					+ dbUri.getPort() + dbUri.getPath();
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbUrl, username, password);
			Statement st = con.createStatement();
			
			String väljund = "select nimi,tüüp,kohad,algus,asula,aadress from sundmused";
		
			ResultSet rs = st.executeQuery(väljund);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					data += rs.getString(i) + " "; 
				}
				data += "\n";
			}
			
			writer.write(data);
			
		} catch (SQLException e) {
			writer.println(e.toString());
		} catch (ClassNotFoundException e) {
			writer.println("ClassNotFoundException");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
}
