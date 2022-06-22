package Api;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
// @WebFilter(asyncSupported = true, urlPatterns = { "/*" }) 
public class CORSFilter implements Filter {
 

  public CORSFilter() {
    
  }
 
  public void destroy() {
    
  }
 
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
      throws IOException, ServletException {
 
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    System.out.println("CORSFilter HTTP Request: " + request.getMethod());
 
    ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
    ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, PUT, POST, DELETE");
 
    HttpServletResponse resp = (HttpServletResponse) servletResponse;

    if (request.getMethod().equals("OPTIONS")) {
      resp.setStatus(HttpServletResponse.SC_ACCEPTED);
      ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
      ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, PUT, POST, DELETE");
      return;
    }
 
    // pass the request along the filter chain
    chain.doFilter(request, servletResponse);
  }

  public void init(FilterConfig fConfig) throws ServletException {
    // TODO Auto-generated method stub
  }
 
}