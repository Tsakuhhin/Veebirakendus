package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class AndmeteLisamine extends HttpServlet {

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
		
			String day = request.getParameter("days");
			if (day.length() == 1) 
				day = "0" + day;
			String month = request.getParameter("months");
			if (month.length() == 1) 
				month = "0" + month;
			String aeg = (request.getParameter("years") + day + month +
					request.getParameter("tund") + ":" + request.getParameter("minut") + "'");
			String sisend = "insert into sundmused (nimi, tüüp, kohad, algus, asula, aadress, looja) "
					+ "values ('" + request.getParameter("nimi") + "','" + request.getParameter("tuup") + 
					"'," + request.getParameter("kohad") +"," + "to_timestamp('" + aeg + ",'YYYYDDMMHH24:MI'),'" +
					request.getParameter("asula") + "','" + request.getParameter("aadress") + "','" + "feiskarkonto3405" + "')";
			
			st.executeUpdate(sisend);
			
//			String väljund = "select * from sundmused";
//			write.println(sisend);
//			write.println("päev: " + request.getParameter("days"));
//			write.println("kuu: " + request.getParameter("months"));
//			write.println("aasta: " + request.getParameter("years"));
//			write.println("tund: " + request.getParameter("tund"));
//			write.println("minut: " + request.getParameter("minut"));
//			
//			write.println("\nSündmus '" + request.getParameter("nimi")+ "' lisatud.\n Kõik sündmused:");
//			ResultSet rs = st.executeQuery(väljund);
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int columnsNumber = rsmd.getColumnCount();
//			
//			while (rs.next()) {
//				for (int i = 1; i <= columnsNumber; i++) {
//					write.print(rs.getString(i) + " "); 
//				}
//				write.println();
//			}

		} catch (SQLException e) {
			write.println(e.toString());
		} catch (ClassNotFoundException e) {
			write.println("ClassNotFoundException");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
