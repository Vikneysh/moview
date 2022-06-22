package Api;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.json.JSONObject;


@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MessageServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
	     response.setStatus(HttpServletResponse.SC_OK	);
		response.setContentType("text/html");
		ArrayList<LinkedHashMap> msgs=new ArrayList();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/moviewdb?useSSL=false","root","Shree#8k8sskncxg");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from messages");  
		
			while(rs.next())  {
				LinkedHashMap<String,String> hm=new LinkedHashMap();
				hm.put("uname",rs.getString(2));
				hm.put("email",rs.getString(3));
				hm.put("message",rs.getString(4));
				msgs.add(hm); 
			}
			JSONArray msgJs=new JSONArray(msgs);
			response.getWriter().print(msgJs);
			stmt.close();
			rs.close();
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

				  PreparedStatement ps=con.prepareStatement("insert into messages(uname,email,message) values (?,?,?)"); 
			
		            ps.setString(1,jSONObject.getString("uname"));  
		            ps.setString(2,jSONObject.getString("email"));  
		            ps.setString(3,jSONObject.getString("message"));  
		            status=ps.executeUpdate();  
		        ps.close();
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
