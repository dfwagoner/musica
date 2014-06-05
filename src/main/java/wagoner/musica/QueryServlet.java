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

public class QueryServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) // was
																					// saveFormData
			throws IOException, ServletException {

		if (request.getParameter("retrieve") != null) {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String artist = request.getParameter("artist");
			out.println("Search value for artist is " + "\"" + artist + "\""); 
		}

	}
}
