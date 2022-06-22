package Api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/BlogServlet")
public class BlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BlogServlet() {
        super();
    }
        

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
	     response.setStatus(HttpServletResponse.SC_OK	);
		response.setContentType("text/html");
		ArrayList<HashMap> blogs=new ArrayList();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/moviewdb?useSSL=false","root","Shree#8k8sskncxg");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from blogs");  
		
			while(rs.next())  {
				HashMap<String,String> hm=new HashMap();
				hm.put("title",rs.getString(2));
				hm.put("body",rs.getString(3));
				hm.put("date",rs.getString(4));
				hm.put("img",rs.getString(5));
				blogs.add(hm); 
			}
			JSONArray bJs=new JSONArray(blogs);
			response.getWriter().print(bJs);
			con.close();  	
			}catch(Exception e){ System.out.println(e);}  
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 setAccessControlHeaders(response);
	     response.setStatus(HttpServletResponse.SC_OK	);
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

				  PreparedStatement ps=con.prepareStatement("insert into blogs(title,body,date) values (?,?,?)"); 
			
		            ps.setString(1,jSONObject.getString("title"));  
		            ps.setString(2,jSONObject.getString("body"));  
		            ps.setString(3,jSONObject.getString("date"));  
		            status=ps.executeUpdate();  
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