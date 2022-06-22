package Api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/RateServlet")
public class RateServlet extends HttpServlet {
	private static final long seriVersionUID = 1L;

    public RateServlet() {
        super();
       
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
	     response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        int status=0;  
	        String s;
	    	try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/moviewdb?useSSL=false","root","Shree#8k8sskncxg");  
				Statement stmt=con.createStatement();  
				 StringBuilder sb = new StringBuilder();
			        while ((s = request.getReader().readLine()) != null) {
			            sb.append(s);
			        }
			       JSONObject jSONObject = new JSONObject(sb.toString());
			       
			        System.out.println(jSONObject.getString("userId"));
				  PreparedStatement ps=con.prepareStatement("INSERT INTO user_rating\r\n"
				  		+ "  (movieId, userId, rating) \r\n"
				  		+ "VALUES \r\n"
				  		+ "  (?,?,?)\r\n"
				  		+ "ON DUPLICATE KEY UPDATE\r\n"
				  		+ "	rating=?\r\n"
				  		+ "  ");
				  ps.setString(1,jSONObject.getString("movieId"));  
		            ps.setString(2,jSONObject.getString("userId"));  
		            ps.setString(3,jSONObject.getString("rating"));
		            ps.setString(4,jSONObject.getString("rating"));
		            status=ps.executeUpdate();  
		            PreparedStatement ps1=con.prepareStatement("UPDATE movie\r\n"
			    	 		+ "SET rating = (SELECT AVG(rating) AS AvgRating FROM user_rating where movieId=?), ratingCount=(SELECT COUNT(*) FROM user_rating WHERE movieId=?)\r\n"
			    	 		+ "WHERE movieId = ?;"); 
		            ps1.setString(1,jSONObject.getString("movieId")); 
		            ps1.setString(2,jSONObject.getString("movieId")); 
		            ps1.setString(3,jSONObject.getString("movieId"));
		            ps1.executeUpdate();
		        ps.close();
		        ps1.close();
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
