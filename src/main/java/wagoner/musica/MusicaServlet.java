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
			String rating = request.getParameter("dave_rating");
			String compilation = request.getParameter("compilation_fl");
			String owner = request.getParameter("owner");

			// JDBC driver name and database URL
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			final String DB_URL = "jdbc:mysql://localhost/musica";

			// Database credentials
			final String USER = "root";
			final String PASS = "ncsurulz";

			// Set response content type
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String title = "Save New Record";
			String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
					+ "transitional//en\">\n";
			out.println(docType + "<html>\n" + "<head><title>" + title
					+ "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
					+ "<h1 align=\"center\">" + title + "</h1>\n");
			Connection conn = null;
			Statement stmt = null;
			Statement stmt2 = null;

			try {
				// Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				// Open a connection
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				// Execute SQL query
				stmt = conn.createStatement();
				String sql;
				String sql2;
				String sql3;
				String sql4;

				sql = "SELECT artist_name FROM artist where artist_name like '%"
						+ artist + "%';";
				ResultSet doesartistexist = stmt.executeQuery(sql);

				sql2 = "INSERT INTOg `musica`.`artist` "
						+ "(`artist_id`,`artist_name`)"
						+ " VALUES (artist_id, \"" + artist + "\");";
				sql3 = "INSERT INTOg `musica`.`album` "
						+ "(`album_id`, `artist_name`, `artist_id`, `album_name`, "
						+ "`release_date`, `label`, `genre`, `style`, `rating_dave`, "
						+ "`notes`, `compilation_fl`) VALUES ("
						+ "album_id, \""
						+ artist
						+ "\", "
						+ "(select max(artist_id) from artist where artist_name = \""
						+ artist + "\"), \"" + album + "\", \"" + year
						+ "\", \"" + label + "\", \"" + genre + "\", \""
						+ style + "\", \"" + rating + "\", \"" + notes
						+ "\", \"" + compilation + "\");";
				sql4 = "INSERT INTOg `musica`.`album_object` "
						+ "(`album_object_id`, `album_id`, `album_name`, `artist_id`, "
						+ "`artist_name`, `record_label`, `catalog_num`, "
						+ "`upc_num`, `country`, `format`, `format_diameter`, `format_notes`, "
						+ "`media_condition`, `sleeve_condition`, `condition_ext`, `media_image`, "
						+ "`media_image2`, `media_image3`, `on_discogs`, `discogs_dt`, `owner_id`, "
						+ "`extra_1`, `extra_2`) VALUES ("
						+ "album_object_id, "
						+ "(select max(album.album_id) from album where album_name = \""
						+ album
						+ "\"), "
						+ "\""
						+ album
						+ "\", (select artist_id from artist where artist_name = \""
						+ artist
						+ "\"), \""
						+ artist
						+ "\", \""
						+ label
						+ "\", \""
						+ catno
						+ "\", null, \""
						+ country
						+ "\", \""
						+ format
						+ "\", null, null, \""
						+ mediacondition
						+ "\", \""
						+ sleevecondition
						+ "\", \""
						+ extra
						+ "\", null, null, null, null, null, \""
						+ owner
						+ "\", null, null);";

				if (doesartistexist.first()) {

					try {
						out.println("<hr>Artist already exists!</hr>");
						out.println("<hr>" + sql3 + "</hr>");
						out.println("<hr>" + sql4 + "</hr>");

						stmt2 = conn.createStatement();
						stmt2.executeUpdate(sql3);
						stmt2.executeUpdate(sql4);
					}

					catch (SQLException e) {
						out.println("<hr>" + e + "</hr>");
					}

				} else {
					stmt2 = conn.createStatement();

					out.println("<hr>" + sql2 + "</hr>");
					out.println("<hr>" + sql3 + "</hr>");
					out.println("<hr>" + sql4 + "</hr>");

					try {

						stmt2.executeUpdate(sql2);
						stmt2.executeUpdate(sql3);
						stmt2.executeUpdate(sql4);
					}

					catch (SQLException e) {
						out.println("<hr>" + e + "</hr>");
					}

				}

				// Clean-up environment
				doesartistexist.close();
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
			if (artist.startsWith("The ")) {
					artist = artist.substring(4);
			}
			
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
			String rating = request.getParameter("dave_rating");
			String compilation = request.getParameter("compilation_fl");
			String owner = request.getParameter("owner");
			
			// JDBC driver name and database URL
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			final String DB_URL = "jdbc:mysql://localhost/musica";

			// Database credentials
			final String USER = "root";
			final String PASS = "ncsurulz";

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
				String artistq;

				sql = "SELECT album_object.artist_name, album_object.album_name, "
						+ "album_object.format, "
						+ "album_object.record_label, album_object.catalog_num, "
						+ "album.release_date, album.genre, album_object.media_condition, "
						+ "album_object.sleeve_condition, album_object.condition_ext, "
						+ "album.notes FROM album_object, album where "
						+ "album_object.album_id = album.album_id"
						+ " and album_object.artist_name like '%"
						+ artist
						+ "%'"
						+ " and album.genre like '%"
						+ genre
						+ "%'"
						+ " and album.release_date like '%"
						+ year
						+ "%'"
						+ " and album.label like '%"
						+ label
						+ "%'"
						+ " and album_object.format like '%"
						+ format
						+ "%'"
						+ " and album_object.media_condition like '%" 
						+ mediacondition
						+ "%'"
						+ " and album_object.sleeve_condition like '%"
						+ sleevecondition
						+ "%'"
						+ " and album.rating_dave like '%"
						+ rating
						+ "%';";
						/*+ " and album.compilation_fl = '"
						+ compilation
						+ "'"
						+ " and album_object.owner_id = '"
						+ owner
						+ "';";
						*/
				//out.println("<h10>" + sql + "</h10>");
				ResultSet album_object_resultset = stmt.executeQuery(sql);

				album_object_resultset.first();
				artistq = album_object_resultset.getString("artist_name");
				// out.println("<h10>Value of artist name is: " + artistq + "</h10>");
				out.println("<hr></hr>");

				StringBuilder builder = new StringBuilder();
				album_object_resultset.beforeFirst();
				int columnCount2 = album_object_resultset.getMetaData()
						.getColumnCount();
				while (album_object_resultset.next()) {
					for (int i = 0; i < columnCount2;) {
						builder.append(album_object_resultset.getString(i + 1));
						if (++i < columnCount2)
							builder.append(",");

					}
					builder.append("\r\n");
				}
				String resultSetAsString = builder.toString();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Query Results</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<form action=\"queryservlet\" method=\"post\">");
				//The action must equal the name of the url-pattern tag in the servlet-mapping tag
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

				album_object_resultset.beforeFirst();
				int columnCount = album_object_resultset.getMetaData()
						.getColumnCount();
				while (album_object_resultset.next()) {
					
					out.println("<tr>");
					out.println("<td style=\"width:500px\"><div contenteditable>"
							+ album_object_resultset.getString("artist_name")
							+ " - "
							+ album_object_resultset.getString("album_name")
							+ " ("
							+ album_object_resultset.getString("record_label")
							+ " - "
							+ album_object_resultset.getString("catalog_num")
							+ ")" + "</div></td>");
					out.println("<td>"
							+ album_object_resultset.getString("format")
							+ "</td>");
					out.println("<td>"
							+ album_object_resultset.getString("release_date")
							+ "</td>");
					out.println("<td>"
							+ album_object_resultset.getString("genre")
							+ "</td>");
					out.println("<td>"
							+ album_object_resultset
									.getString("media_condition") + "</td>");
					out.println("<td>"
							+ album_object_resultset
									.getString("sleeve_condition") + "</td>");
					out.println("<td>"
							+ album_object_resultset.getString("condition_ext")
							+ "</td>");
					out.println("<td>"
							+ album_object_resultset.getString("notes")
							+ "</td>");
					
				}
				
				out.println("</tr>");
				out.println("</table>");
				
				// This passes the value of artist to a new servlet, just for the hell of it.
				// I was also initially attempting to allow the user to choose one row of the results to allow
				// editing or matching with Discogs or something like that.
				out.println("<input type=\"hidden\" name=\"artist\" value=\"" + artist + "\" />");
				out.println("<input type=\"submit\" name=\"retrieve\" value=\"Query\" />");
				out.println("</body>");

				// Clean up environment
				album_object_resultset.close();
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

		}

	}
}
