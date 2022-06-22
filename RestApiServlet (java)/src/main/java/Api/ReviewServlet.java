package Api;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
	     response.setStatus(HttpServletResponse.SC_OK	);

		response.setContentType("text/html");
		String mId=request.getParameter("id");
		ArrayList<LinkedHashMap> movies=new ArrayList();
		try{  	
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/moviewdb?useSSL=false","root","Shree#8k8sskncxg");  
			PreparedStatement stmt=con.prepareStatement("select * from movie where movieId=?");
			stmt.setString(1, mId);
			PreparedStatement stmt1=con.prepareStatement("select g.genreName as genre_name\r\n"
					+ "from genres g\r\n"
					+ "join movie_genre mg on mg.genreId = g.genreId\r\n"
					+ "join movie m on m.movieId = mg.movieId\r\n"
					+ "where m.movieId =?");
			stmt1.setString(1, mId);
			PreparedStatement stmt2=con.prepareStatement("\r\n"
					+ "select c.name as actor_name\r\n"
					+ "from crewmember c\r\n"
					+ "join movie_crew mc on mc.cId= c.id\r\n"
					+ "join movie m on m.movieId = mc.mId\r\n"
					+ "where m.movieId = ?");
			stmt2.setString(1, mId);
//			stmt.setString(0, getServletInfo())
			ResultSet rs=stmt.executeQuery();  
			ResultSet rs1=stmt1.executeQuery();
			ResultSet rs2=stmt2.executeQuery();
			String genre="",actors="";
			while(rs.next())  {
				LinkedHashMap<String,String> hm=new LinkedHashMap();
				hm.put("movieId", rs.getString(1));
				hm.put("title", rs.getString(2));
				hm.put("year", rs.getString(3));
				hm.put("language", rs.getString(4));
				hm.put("rating", rs.getString(5));
				hm.put("review", rs.getString(6));
				hm.put("director", rs.getString(7));
				hm.put("musicDirector", rs.getString(8));
				hm.put("img", rs.getString(9));
				hm.put("trailer", rs.getString(10));
				hm.put("ratingCount",rs.getString(11));
				while(rs1.next()) {
					genre+=rs1.getString(1)+" ";
				}
				while(rs2.next()) {
					actors+=rs2.getString(1)+" ";
				}
				hm.put("genre", genre);
				hm.put("actors", actors);
				movies.add(hm); 
	
			}
			
			JSONArray mJs=new JSONArray(movies);
			response.getWriter().print(mJs);
			con.close();  	
			}catch(Exception e){ System.out.println(e);}  
		}


	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
	          throws ServletException, IOException {
	      setAccessControlHeaders(response);
	      response.setStatus(HttpServletResponse.SC_OK	);
	}
	 
	private void setAccessControlHeaders(HttpServletResponse resp) {
	      resp.setHeader("Access-Control-Allow-Origin", "*");
	      resp.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
	      resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
	      
	  }

}
