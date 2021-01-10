package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.customer;
import utils.DBcustomer;
import utils.MyUtils;

/**
 * Servlet implementation class accountServlet
 */
@WebServlet(name="account", urlPatterns= {"/account"})
public class accountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public accountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request) ;
		String StrusernameLogin = (String)request.getParameter("usernameLogin");
		
		customer c = null;
		try {
			c = DBcustomer.displayCustomer(conn, StrusernameLogin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("detailsCustomer", c);
		//sửa lỗi tiếng việt
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/account.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
		//sửa lỗi tiếng việt
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String usernameLogin = (String)request.getParameter("usernameLogin");
        String name = (String)request.getParameter("name");
        String addr = (String)request.getParameter("address");
        String tel = (String)request.getParameter("tel");
                
        String errorString = null;
        int status = -1;
 
        try {
            DBcustomer.updateCustomer(conn, name, addr, tel, usernameLogin);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Lưu thông tin vào request attribute trước khi forward sang views.
        request.setAttribute("errorString", errorString);
        
        // Nếu có lỗi 
        if (errorString != null) {
        	status=0;
        	System.out.println("sao ki");
        }
        // Nếu mọi thứ tốt đẹp.
        else {
        	status=1;
        	String someMessage = "Error !";
        	PrintWriter out = response.getWriter();
        	out.print("<html><head>");
        	out.print("<script type=\"text/javascript\">alert(" + someMessage + ");</script>");
        	out.print("</head><body></body></html>");
        	
			/* out.println("alert('Cập nhật thành công')"); */
        }
        request.setAttribute("status", status);
        System.out.println("status:"+status);
		response.sendRedirect("account?usernameLogin="+usernameLogin); 

	}

}
