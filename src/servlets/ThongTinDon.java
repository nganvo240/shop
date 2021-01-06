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
import beans.product;
import beans.product_detail;
import utils.DBproduct;
import utils.MyUtils;

/**
 * Servlet implementation class ThongTinDon
 */
@WebServlet("/ThongTinDon")
public class ThongTinDon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinDon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);

		List<bill> list_donHang = null; 
		try { list_donHang = DBproduct.ThongTinDon_list(conn); }
		  catch (Exception e) {}
		
		System.out.println("hello tgn, gôdbye tgn");
		request.setAttribute("danhSachDonHang", list_donHang);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/ThongTinDon.jsp");
	       dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/ThongTinDon.jsp");
	       dispatcher.forward(request, response);
	}

}
