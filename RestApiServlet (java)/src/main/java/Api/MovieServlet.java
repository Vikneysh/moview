package Api;

import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.sql.*;

import org.json.JSONArray;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
	     response.setStatus(HttpServletResponse.SC_OK	);

		response.setContentType("text/html");
	
		ArrayList<LinkedHashMap> movies=new ArrayList();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/moviewdb?useSSL=false","root","Shree#8k8sskncxg");  
			PreparedStatement stmt=con.prepareStatement("select * from movie");
			ResultSet rs=stmt.executeQuery("select * from movie");  
		
			while(rs.next())  {
				LinkedHashMap<String,String> hm=new LinkedHashMap();
				hm.put("movieId", rs.getString(1));
				hm.put("title", rs.getString(2));
				hm.put("year", rs.getString(3));
				
				hm.put("rating", rs.getString(5));
				movies.add(hm); 
			
			}
			JSONArray mJs=new JSONArray(movies);
			response.getWriter().print(mJs);
			rs.close();
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
