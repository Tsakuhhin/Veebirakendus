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

public class ArvutimLugemine  extends HttpServlet {

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
			
			String väljund = "select nimi,tüüp,kohad,algus,asula,aadress,looja from sundmused where tüüp = 'Arvutimäng'";
		
			ResultSet rs = st.executeQuery(väljund);
			ResultSetMetaData rsmd = rs.getMetaData();
					
			//Stringid tulpade väärtuste jaoks, et muus järjekorras datasse pressida koos htmliga
			
			String nimi = "";
			String tuup = "";
			String kohad = "";
			String algus = "";
			String asula = "";
			String aadress = "";
			String looja = "";
			
			
			while (rs.next()) {
				/*
				for (int i = 1; i <= columnsNumber; i++) {
					data += rs.getString(i) + " "; 
				}
				data += "<br>";*/
				nimi = rs.getString(1);
				tuup = rs.getString(2);
				kohad = rs.getString(3);
				algus = rs.getString(4);
				asula = rs.getString(5);
				aadress = rs.getString(6);
				looja = rs.getString(7);
				/*
				data += nimi + " "+ tuup + " "+ "<br>"+ kohad + " "+ algus 
						+ " "+ asula + " "+ aadress + " "+ looja + "<br>";*/
				
				data += "<p>";
				if (tuup.equals("Lauamäng")){
					data += "<img class=\"event_type\" src=\"icons/cards.png\" alt=\"type_logo\"/>";
				}
				else {
					data += "<img class=\"event_type\" src=\"icons/pc.png\" alt=\"type_logo\"/>";
				}
				data += tuup + ": " + nimi + " - " + looja + "<br>";
				data += "Aadress: "+ aadress +", "+ asula + "; algus: " + algus +"<br>";
				data += "Lisainfo: " +"<br>";
				data += "Kohtade arv: "+ kohad +"<br>";
				data += "</p>";
				
				
				nimi = tuup = kohad = algus = asula = aadress = looja = "";
				
			}
			writer.write(data);
			con.close();
			
		} catch (SQLException e) {
			writer.println(e.toString());
		} catch (ClassNotFoundException e) {
			writer.println("ClassNotFoundException");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	protected void finalize() throws Throwable  
	{  
	    try { con.close(); } 
	    catch (SQLException e) { 
	        e.printStackTrace();
	    }
	    super.finalize();  
	}
	
}
