package Api;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SearchServlet() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 setAccessControlHeaders(response);
		String s="";
		ArrayList<LinkedHashMap> movies=new ArrayList();
		 int status=0;  
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
	       String queryStr="select * from ratings where title like\'"+jSONObject.getString("searchStr")+"\'";
			ResultSet rs=stmt.executeQuery("select * from movie where title like\'%"+jSONObject.getString("searchStr")+"%\'");  
			System.out.println(queryStr);
		
			while(rs.next())  {
				LinkedHashMap<String,String> hm=new LinkedHashMap();
				hm.put("id", rs.getString(1));
				hm.put("title", rs.getString(2));
				hm.put("genre", rs.getString(3));
				hm.put("year", rs.getString(4));
				hm.put("rating", rs.getString(5));
				movies.add(hm); 
				System.out.println(rs.getString(2));
			}
			JSONArray mJs=new JSONArray(movies);
			response.getWriter().print(mJs);
			stmt.close();
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
