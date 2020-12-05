package servlets;

import java.awt.Component;
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
import javax.swing.JFrame;

import beans.user;
import utils.DBUtils;
import utils.MyUtils;

/**
 * Servlet implementation class InsertUser
 */
@WebServlet("/InsertUser")
public class InsertUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
		 
        String username= (String)request.getParameter("username");
        String pass = (String) request.getParameter("password");
        String email = (String) request.getParameter("email");
        String roleStr = "1";//phân quyền người dùng =1
        
        int role = 0;
        try {
        	role = Integer.parseInt(roleStr);//đổi id từ string sang int
        } catch (Exception e) {
        }
        user u = new user(username, pass, email, role);
 
        String errorString = null;
        
        try {
            DBUtils.insertUser(conn, u);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Lưu thông tin vào request attribute trước khi forward sang views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("user", u);
 
        // Nếu có lỗi
        if (errorString != null) {
			
        	System.out.println("thêm thất bại");
        	RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/views/login.jsp");
            dispatcher.forward(request, response);
        	JOptionPane.showMessageDialog(null,"Thực hiện thất bại");
        	
        }
        // Nếu mọi thứ tốt đẹp.
        else {
        	JOptionPane.showMessageDialog(null,"Thực hiện thành công");
        	System.out.println("thêm thành công");
        	RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/views/login.jsp");
            dispatcher.forward(request, response);
        	
        }
	}

}
