package wagoner.musica;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MusicaServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response) // was
																					// saveFormData
			throws IOException, ServletException {

		if (request.getParameter("save") != null) {

			String artist = request.getParameter("artist");
			String album = request.getParameter("album");
			String label = request.getParameter("label");
			String catno = request.getParameter("catno");
			String upcno = request.getParameter("upcno");
			String country = request.getParameter("country");
			String year = request.getParameter("year");
			String format = request.getParameter("format");
			String genre = request.getParameter("genre");
			String style = request.getParameter("style");
			String mediacondition = request.getParameter("mediacondition");
			String sleevecondition = request.getParameter("sleevecondition");
			String extra = request.getParameter("extra");
			String notes = request.getParameter("notes");

			// JDBC driver name and database URL
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			final String DB_URL = "jdbc:mysql://localhost/musica";

			// Database credentials
			final String USER = "root";
			final String PASS = "ncsurulz";

			// Set response content type
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String title = "Database Result";
			String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
					+ "transitional//en\">\n";
			out.println(docType + "<html>\n" + "<head><title>" + title
					+ "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
					+ "<h1 align=\"center\">" + title + "</h1>\n");
			out.println("<h1 align=\"center\">" + request.getParameter("save") + "</h1>\n");
			Connection conn = null;
			Statement stmt = null;

			try {
				// Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				// Open a connection
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				// Execute SQL query
				stmt = conn.createStatement();
				String sql;
				sql = "SELECT artist_id, artist_name FROM artist;";
				ResultSet rs = stmt.executeQuery(sql);

				// Extract data from result set
				while (rs.next()) {
					// Retrieve by column name
					int id = rs.getInt("artist_id");
					String artistName = rs.getString("artist_name");

					// Display values
					out.println("ID: " + id + "<br>");
					out.println(", Artist Name: " + artistName + "<br>");
				}
				out.println("</body></html>");

				// Clean-up environment
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				}// nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}// end finally try
			} // end try

		} else if (request.getParameter("query") != null) {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String artist = request.getParameter("artist");
			String album = request.getParameter("album");
			String label = request.getParameter("label");
			String catno = request.getParameter("catno");
			String upcno = request.getParameter("upcno");
			String country = request.getParameter("country");
			String year = request.getParameter("year");
			String format = request.getParameter("format");
			String genre = request.getParameter("genre");
			String style = request.getParameter("style");
			String mediacondition = request.getParameter("mediacondition");
			String sleevecondition = request.getParameter("sleevecondition");
			String extra = request.getParameter("extra");
			String notes = request.getParameter("notes");

			out.println("<h1 align=\"center\">" + request.getParameter("save") + "</h1>\n");
			out.println("<h1 align=\"center\">" + request.getParameter("query") + "</h1>\n");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>New Album Object</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<table style=\"width:1000px\" border=\"1\">");
			out.println("<tr>");
			out.println("<th>Artist - Title (Label, Catalog#)</th>");
			out.println("<th>Format</th>");
			out.println("<th>Year</th>");
			out.println("<th>Genre</th>");
			out.println("<th>Media Condition</th>");
			out.println("<th>Sleeve Condition</th>");
			out.println("<th>Extra</th>");
			out.println("<th>Notes</th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>" + artist + " - " + album + " (" + label + " - "
					+ catno + ")" + "</td>");
			out.println("<td>" + format + "</td>");
			out.println("<td>" + year + "</td>");
			out.println("<td>" + genre + "</td>");
			out.println("<td>" + mediacondition + "</td>");
			out.println("<td>" + sleevecondition + "</td>");
			out.println("<td>" + extra + "</td>");
			out.println("<td>" + notes + "</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</body>");

		}
	}

}
