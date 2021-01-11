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

import beans.product;
import beans.type;
import utils.DBcategory;
import utils.DBproduct;
import utils.MyUtils;

/**
 * Servlet implementation class categoryServlet
 */
@WebServlet("/categoryServlet")
public class categoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request) ;
		String StrusernameLogin = (String)request.getParameter("usernameLogin");
		String btnType = (String) request.getParameter("btnType");
		String btnRadioPrice = (String) request.getParameter("btnRadioPrice");
		System.out.println("cate:"+StrusernameLogin);
		String errorString = null;
		List<type> listType = null;
		try {
			listType = DBcategory.listType(conn);	
		} catch (SQLException e)
		{
			
			e.printStackTrace();
			errorString = e.getMessage();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		request.setAttribute("usernameLogin", StrusernameLogin);
		request.setAttribute("TypetListServlet", listType);
		request.setAttribute("x", btnType);
		request.setAttribute("btnRadioPrice", btnRadioPrice);
		
		  RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/category.jsp");
		  dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
