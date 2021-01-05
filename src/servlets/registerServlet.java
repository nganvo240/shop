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

import beans.customer;
import beans.user;
import utils.DBuser;
import utils.MyUtils;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
		//Đăng ký
        String usernameRegister = (String)request.getParameter("usernameRegister");
        String passRegister = (String) request.getParameter("passwordRegister");
        String email = (String) request.getParameter("emailRegister");
        String roleStr = "1";//phân quyền người dùng =1
        int testRegister = 0;
        String name="";
        String address="";
        String tel="";
        
        int role = 0;       
        try {
        	role = Integer.parseInt(roleStr);//đổi id từ string sang int
        } 
        catch (Exception e) {
        }        
        user u = new user(usernameRegister, passRegister, email, role);
        customer c = new customer(name, address, tel, usernameRegister);
        String errorStringRegister = null;        
        try {
            DBuser.insertUser(conn, u);
        } catch (SQLException e) {
            e.printStackTrace();
            errorStringRegister = e.getMessage();
        }
        try {
			DBuser.insertCustomser(conn, c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
        // Lưu thông tin vào request attribute trước khi forward sang views.
        request.setAttribute("errorStringRegister", errorStringRegister);
        request.setAttribute("user", u);
 
        // Nếu có lỗi
        if (errorStringRegister != null) {
        	testRegister = 1;
        	request.setAttribute("testRegister", testRegister);
        	System.out.println("thêm user thất bại");
      	
        }
        // Nếu mọi thứ tốt đẹp.
        else { 
        	testRegister = 2;
        	request.setAttribute("testRegister", testRegister);
        	System.out.println("thêm user thành công");
   
        }
        RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/views/login.jsp");
		dispatcher.forward(request, response);
	}

}
