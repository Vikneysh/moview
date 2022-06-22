package Api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

@WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Authentication() {
        super();  
        
    }
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	response.setContentType("text/html");  
		setAccessControlHeaders(response);
	     response.setStatus(HttpServletResponse.SC_OK);
	     PrintWriter out=response.getWriter();  
	     String s,logEmail="",logUser="",logSession="",logBtn="";
	     
	     try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/moviewdb?useSSL=false","root","Shree#8k8sskncxg");  
				Statement stmt=con.createStatement();  
				PreparedStatement ps=con.prepareStatement("select * from authentication"); 
		           
		            ResultSet rs=ps.executeQuery();  
		            while(rs.next())  {
		            	logBtn=rs.getString(2);
						logEmail=rs.getString(2);
						logUser=rs.getString(3);
						logSession=rs.getString(4);
					}
  	
					String ret="{uId:"+logBtn+",name:"+logUser+",status:1,sessionId:"+logSession+"}";
					System.out.println(ret);
					JSONObject returnObj = new JSONObject(ret);
					out.print(returnObj);
		           				
				rs.close();
				ps.close();
				con.close();  	
				}catch(Exception e){ System.out.println(e);}  	
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		setAccessControlHeaders(response);
	     response.setStatus(HttpServletResponse.SC_OK);
		
	        PrintWriter out=response.getWriter();  
	        int status=0;  
	        String s,logEmail="",logUser="",logPass="",logSession="",logBtn="";
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
				  PreparedStatement ps=con.prepareStatement("select * from user where email=? and password=?"); 
		            ps.setString(1,jSONObject.getString("email"));  
		            ps.setString(2,jSONObject.getString("password"));  
		            ResultSet rs=ps.executeQuery();  
		            while(rs.next())  {
		            	logBtn=rs.getString(1);
						logEmail=rs.getString(2);
						logUser=rs.getString(3);
						logPass=rs.getString(4);
					}
					System.out.println(logUser);
				if(jSONObject.getString("password").equals(logPass)){
				
					HttpSession session=request.getSession();
					session.setAttribute("name",logUser);
					logSession=session.getId();
					System.out.println(logSession);
					
					PreparedStatement ps1=con.prepareStatement("INSERT INTO authentication (userId,userName, sessionId)\r\n"
							+ "SELECT * FROM (SELECT ?,?,?) AS tmp\r\n"
							+ "WHERE NOT EXISTS (\r\n"
							+ "    SELECT sessionId FROM authentication WHERE sessionId = ?\r\n"
							+ ") LIMIT 1;");
					ps1.setString(1,logBtn); 
					System.out.println(logBtn);
					ps1.setString(2,logUser);  
		            ps1.setString(3,logSession);
//		            ps1.setString(3,Long.toString(session.getLastAccessedTime()));  
//		            ps1.setString(4,Long.toString(session.getCreationTime()));  
		            ps1.setString(4,logSession);
		            ps1.executeUpdate();
		            ps1.close();
		        	
					String ret="{uId:"+logBtn+",name:"+logUser+",status:1,sessionId:"+logSession+"}";
					
					JSONObject returnObj = new JSONObject(ret);
					out.print(returnObj);
						
		            if(logBtn=="Logout") {
		            	session.invalidate();
		            	System.out.println("id"+session.getId());
		            }
					}
				else {
					out.print("invalid");
				}
				rs.close();
				ps.close();
				con.close();  	
				}catch(Exception e){ System.out.println(e);}  	
	}
	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
	          throws ServletException, IOException {	
	      setAccessControlHeaders(response);
	      response.setStatus(HttpServletResponse.SC_OK);
	}
	 
	private void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
	      resp.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
	      resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,xsrf-token");
	      resp.setHeader("Access-Control-Max-Age", "3600");
	      resp.setHeader("Access-Control-Allow-Credentials","true");
	   
	        resp.addHeader("Access-Control-Expose-Headers", "xsrf-token");
	  }
}
