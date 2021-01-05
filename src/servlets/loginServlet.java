package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import beans.user;
import utils.DBuser;
import utils.MyUtils;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usernameLogin = (String)request.getParameter("usernameLogin");
		request.setAttribute("usernameLogin", usernameLogin);
		RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/views/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);     
      //Đăng nhập
        String usernameLogin = (String)request.getParameter("usernameLogin");
        String passwordLogin = (String) request.getParameter("passwordLogin");
        
        String errorStringLogin = null;  
        int testLogin = 0;
        try {
        	testLogin = DBuser.testLogin(conn, usernameLogin, passwordLogin);
        } catch (SQLException e) {
            e.printStackTrace();
            errorStringLogin = e.getMessage();
        }
        System.out.println("login_teen dang nhap la:"+ usernameLogin);       
        // Lưu thông tin vào request attribute trước khi forward sang views.
        request.setAttribute("errorStringLogin", errorStringLogin);
        request.setAttribute("usernameLogin", usernameLogin);
        // Nếu có lỗi
        if ( testLogin != 1) {
        	testLogin = 1 ;
        	request.setAttribute("testLogin", testLogin);
        	System.out.println("đăng nhập thất bại");
        	RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/views/login.jsp");
    		dispatcher.forward(request, response);
        }
        // Nếu mọi thứ tốt đẹp.
        else { 
        	testLogin = 2;
        	request.setAttribute("testLogin", testLogin);
        	System.out.println("đăng nhập thành công");
        	RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/home");
    		dispatcher.forward(request, response);
        }
	}

}
