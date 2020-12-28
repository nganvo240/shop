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
import utils.DBproduct;
import utils.MyUtils;

/**
 * Servlet implementation class productServlet
 */
@WebServlet("/product")
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request) ;
		String errorString = null;
		List<product> list = null;
		try {
			list = DBproduct.listProduct(conn, "all");
		} catch (SQLException e)
		{
			e.printStackTrace();
			errorString = e.getMessage();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//sửa lỗi tiếng việt
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
		int countProduct= list.size();
		request.setAttribute("countProd", countProduct);
		System.out.println(countProduct+"*************");
		request.setAttribute("ProductListServlet", list);
		
		  RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/product.jsp");
		  dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
