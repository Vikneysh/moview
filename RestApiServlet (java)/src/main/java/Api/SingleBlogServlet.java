package Api;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

@WebServlet("/SingleBlogServlet")
public class SingleBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SingleBlogServlet() {
        super();
        // TODO Auto-generated constructor stub
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
			ResultSet rs=stmt.executeQuery("select * from blogs where id="+request.getParameter("id"));  
		
			while(rs.next())  {
				HashMap<String,String> hm=new HashMap();
				hm.put("title",rs.getString(2));
				hm.put("body",rs.getString(3));
				hm.put("date",rs.getString(4));
				blogs.add(hm); 
			}
			JSONArray bJs=new JSONArray(blogs);
			response.getWriter().print(bJs);
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
