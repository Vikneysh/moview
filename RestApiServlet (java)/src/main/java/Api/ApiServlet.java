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

import org.json.JSONObject;
import org.json.JSONArray;

@WebServlet("/ApiServlet")
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ApiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		setAccessControlHeaders(response);
	     response.setStatus(HttpServletResponse.SC_OK	);

		response.setContentType("text/html");
		ArrayList<LinkedHashMap> users=new ArrayList();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/moviewdb?useSSL=false","root","Shree#8k8sskncxg");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from user");  
		
			while(rs.next())  {
				LinkedHashMap<String,String> hm=new LinkedHashMap();
				hm.put("id",rs.getString(1));
				hm.put("email",rs.getString(2));
				hm.put("name",rs.getString(3));
				hm.put("password",rs.getString(4));
				hm.put("dob",rs.getString(5));
				users.add(hm); 
			}
			JSONArray uJs=new JSONArray(users);
			response.getWriter().print(uJs);
			con.close();  	
			}catch(Exception e){ System.out.println(e);}  
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
			        System.out.println(jSONObject.getString("email"));
				  PreparedStatement ps=con.prepareStatement("insert into user(email,name,password,dob) values (?,?,?,?)"); 
		            ps.setString(1,jSONObject.getString("email"));  
		            ps.setString(2,jSONObject.getString("name"));
		            ps.setString(3,jSONObject.getString("password"));  
		            ps.setString(4,jSONObject.getString("dob"));  
		            status=ps.executeUpdate();  
		          
					ps.close();
				con.close();  	
				}catch(Exception e){ System.out.println(e);}  
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
	          throws ServletException, IOException {
		setAccessControlHeaders(response);
//	    response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("text/html");  
	    try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/moviewdb?useSSL=false","root","Shree#8k8sskncxg");  
			Statement stmt=con.createStatement();  
			stmt.executeUpdate("delete from user where id="+request.getParameter("id")); 
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
	      resp.setHeader("Access-Control-Allow-Methods", "*");
	      resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
	      
	  }

}
