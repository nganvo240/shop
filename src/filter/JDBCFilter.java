package filter;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import conn.DBConnection;
import utils.MyUtils;

/**
 * Servlet Filter implementation class JDBCFilter
 */
@WebFilter(filterName="JDBCFilter", urlPatterns= {"/*"})
public class JDBCFilter implements Filter {

    /**
     * Default constructor. 
     */
    public JDBCFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		if (this.needJDBC(req)) {	 
            System.out.println("Open Connection for: " + req.getServletPath());
 
            Connection conn = null;
            try {
                // Tạo đối tượng Connection kết nối database.
                conn = DBConnection.getConnection();
                // Sét tự động commit false, để chủ động điều khiển.
                conn.setAutoCommit(false);
 
                // Lưu trữ đối tượng Connection vào attribute của request.
                MyUtils.storeConnection(request, conn);
 
                // Cho phép request đi tiếp.
                // (Đi tới Filter tiếp theo hoặc đi tới mục tiêu).
                chain.doFilter(request, response);
 
                // Gọi phương thức commit() để hoàn thành giao dịch với DB.
                conn.commit();
            } catch (Exception e) {
                e.printStackTrace();              
				 throw new ServletException(); 
            } finally {
               
            }
        }
        // Với các request thông thường (image,css,html,..)
        // không cần mở connection.
        else {
            // Cho phép request đi tiếp.
            // (Đi tới Filter tiếp theo hoặc đi tới mục tiêu).
			 chain.doFilter(request, response); 
        }
	}
		private boolean needJDBC(HttpServletRequest request) {
	        System.out.println("JDBC Filter");
	        // Servlet Url-pattern: /spath/*
	        // => /spath
	        String servletPath = request.getServletPath();
	        // => /abc/mnp
	        String pathInfo = request.getPathInfo(); 
	        String urlPattern = servletPath; 
	        if (pathInfo != null) {
	            // => /spath/*
	            urlPattern = servletPath + "/*";
	        } 
	        // Key: servletName.
	        // Value: ServletRegistration
	        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext()
	                .getServletRegistrations();
	 
	        // Tập hợp tất cả các Servlet trong WebApp của bạn.
	        Collection<? extends ServletRegistration> values = servletRegistrations.values();
	        for (ServletRegistration sr : values) {
	            Collection<String> mappings = sr.getMappings();
	            if (mappings.contains(urlPattern)) {
	                return true;
	            }
	        }
	        return false;
	    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}