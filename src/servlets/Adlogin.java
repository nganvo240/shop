package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.bill;
import utils.DBproduct;
import utils.DBuser;
import utils.MyUtils;
import beans.ad;

/**
 * Servlet implementation class adLogin
 */
@WebServlet("/Adlogin")
public class Adlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/views/AdminLogin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);     
	      //Ä�Äƒng nháº­p
	        String usernameLogin = (String)request.getParameter("useradLogin");
	        String passwordLogin = (String)request.getParameter("passwordLogin");
	        String errorStringLogin = null;  
	        int testLogin = 0;
    		
	        try {
	        	testLogin = DBuser.testLoginAdmin(conn, usernameLogin, passwordLogin);
	        	System.out.println("test");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorStringLogin = e.getMessage();
	        }
	               
	        
	        // LÆ°u thÃ´ng tin vÃ o request attribute trÆ°á»›c khi forward sang views.
	        request.setAttribute("errorStringLogin", errorStringLogin);
	        request.setAttribute("usernameLogin", usernameLogin);
	        // Náº¿u cÃ³ lá»—i
	        if ( testLogin != 1) {
	        	testLogin = 1 ;
	        	request.setAttribute("testLogin", testLogin);
	        	System.out.println("danh nhap trang admin that bai");
	        	RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/views/AdminLogin.jsp");
	    		dispatcher.forward(request, response);
	        }
	        // Náº¿u má»�i thá»© tá»‘t Ä‘áº¹p.
	        else { 
	        	testLogin = 2;
	        	request.setAttribute("testLogin", testLogin);
	        	System.out.println("dang nhap trang admin thanh cong");
	        	List<bill> list_donHang = null; 
	    		try { list_donHang = DBproduct.ThongTinDon_list(conn); }
	    		catch (Exception e) {}
	    		request.setAttribute("danhSachDonHang", list_donHang);
	        	RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/views/ThongTinDon.jsp"); // ThongTinDon
	    		dispatcher.forward(request, response);
	        }
	}

}
