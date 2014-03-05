package wagoner.musica;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MusicaServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
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
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>New Album Object</title>");
        out.println(response);
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Artist is: " + artist + "</h1>");
        out.println("<h1>Album is: " + album + "</h1>");
        out.println("<h1>Label is: " + label + "</h1>");
        out.println("<h1>Catalog # is: " + catno + "</h1>");
        out.println("<h1>UPC # is : " + upcno + "</h1>");
        out.println("<h1>Country is: " + country + "</h1>");
        out.println("<h1>Year is: " + year + "</h1>");
        out.println("<h1>Format is: " + format + "</h1>");
        out.println("<h1>Genre is: " + genre + "</h1>");
        out.println("<h1>Style is: " + style + "</h1>");
        out.println("<h1>Media condition is: " + mediacondition + "</h1>");
        out.println("<h1>Sleeve condition is: " + sleevecondition + "</h1>");
        out.println("<h1>Condition notes are: " + extra + "</h1>");
        out.println("<h1>Notes are: " + notes + "</h1>");
        out.println("</body>");
        out.println("</html>");
        
    }
}

