package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.bill;
import utils.DBproduct;
import utils.MyUtils;
import beans.bill_infor;

/**
 * Servlet implementation class billinf
 */
@WebServlet("/billinf")
public class billinf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public billinf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);

		List<bill_infor> list_donHang = null; 
		try { list_donHang = DBproduct.ThongTinDonBILL_list(conn); }
		  catch (Exception e) {}
		
		System.out.println("hello tgn, gôdbye tgn");
		request.setAttribute("danhSachTTDonHang", list_donHang);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/DonHang.jsp");
	       dispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/DonHang.jsp");
	       dispatcher.forward(request, response);
	}

}
