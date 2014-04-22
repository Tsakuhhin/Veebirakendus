package ee.mangupidu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class MinuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection con;
	String dbDriver = "org.postgresql.Driver";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter write = response.getWriter();
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
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
			String aeg = (request.getParameter("years") + request.getParameter("days") + request.getParameter("months") +
					request.getParameter("tund") + ":" + request.getParameter("minut") + "'");
			String sisend = "insert into sundmused (nimi, tüüp, kohad, algus, asula, aadress, looja) "
					+ "values ('" + request.getParameter("nimi") + "','" + request.getParameter("tuup") + 
					"'," + request.getParameter("kohad") +"," + "to_timestamp('" + aeg + ",'YYYYDDMMHH24:MI'),'" +
					request.getParameter("asula") + "','" + request.getParameter("aadress") + "','" + "feiskarkonto3405" + "')";
			String väljund = "select * from sundmused";
			write.println(sisend);
			st.executeUpdate(sisend);
			ResultSet rs = st.executeQuery(väljund);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			
			write.println("\nSündmus '" + request.getParameter("nimi")+ "' lisatud.\n Kõik sündmused:");
			
			while (rs.next()) {
				// Print one row
				for (int i = 1; i <= columnsNumber; i++) {
					write.print(rs.getString(i) + " "); // Print one
																// element of a
																// row
				}
				write.println();// Move to the next line to print the next
										// row.
			}

		} catch (SQLException e) {
			write.println(e.toString());
		} catch (ClassNotFoundException e) {
			write.println("ClassNotFoundException");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter write = response.getWriter();
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
			String query = "SELECT * FROM SUNDMUSED";
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();

			while (rs.next()) {
				// Print one row
				for (int i = 1; i <= columnsNumber; i++) {
					write.print(rs.getString(i) + " "); // Print one
																// element of a
																// row
				}
				write.println();// Move to the next line to print the next
										// row.
			}

		} catch (SQLException e) {
			write.println(e.toString());
		} catch (ClassNotFoundException e) {
			write.println("ClassNotFoundException");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
