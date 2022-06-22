//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.LinkedHashMap;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.json.JSONObject;
//
///**
// * Servlet implementation class GetLogin
// */
//@WebServlet("/GetLogin")
//public class GetLogin extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public GetLogin() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	
//    	response.setContentType("text/html");  
//		setAccessControlHeaders(response);
//	     response.setStatus(HttpServletResponse.SC_OK);
//	     PrintWriter out=response.getWriter();  
//	     String s,logEmail="",logUser="",logPass="",logSession="",logBtn="";
//	     
//	     try{  
//				Class.forName("com.mysql.cj.jdbc.Driver");  
//				Connection con=DriverManager.getConnection(  
//				"jdbc:mysql://localhost:3306/moviewdb?useSSL=false","root","Shree#8k8sskncxg");  
//				Statement stmt=con.createStatement();  
//				PreparedStatement ps=con.prepareStatement("select * from authentication"); 
//		           
//		            ResultSet rs=ps.executeQuery();  
//		            while(rs.next())  {
//		            	logBtn=rs.getString(1);
//						logEmail=rs.getString(2);
//						logUser=rs.getString(3);
//						logPass=rs.getString(4);
//					}
//  	
//					String ret="{uId:"+logBtn+",name:"+logUser+",status:1,sessionId:"+logSession+"}";
//					System.out.println(ret);
//					JSONObject returnObj = new JSONObject(ret);
//					out.print(returnObj);
//		           				
//				rs.close();
//				ps.close();
//				con.close();  	
//				}catch(Exception e){ System.out.println(e);}  	
//    }
//    
//    
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
