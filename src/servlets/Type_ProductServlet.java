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
 * Servlet implementation class nam_ProductServlet
 */
@WebServlet("/type_ProductServlet")
public class Type_ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Type_ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request) ;
		String nameType = (String) request.getParameter("btnRadio");
		String price = (String) request.getParameter("btnRadioPrice");
		
		String errorString = null;
		List<product> list = null;
		//sửa lỗi tiếng việt
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
		if (nameType.equals("Nam")) {		
			try {
				list = DBproduct.listProduct_Nam(conn,price);
			} catch (SQLException e)
			{
				e.printStackTrace();
				errorString = e.getMessage();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			int countProduct= list.size();
			request.setAttribute("countProd", countProduct);		
			request.setAttribute("ProductListServlet", list);
			
			  RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/Nam_product.jsp");
			  dispatcher.forward(request, response);
		}
		else if (nameType.equals("Nữ")){
			try {
				list = DBproduct.listProduct_Nu(conn,price);
			} catch (SQLException e)
			{
				e.printStackTrace();
				errorString = e.getMessage();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			int countProduct= list.size();
			request.setAttribute("countProd", countProduct);	
			request.setAttribute("ProductListServlet", list);
			request.setAttribute("price", price);
			
			  RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/Nu_product.jsp");
			  dispatcher.include(request, response);
		}
		else {
			try {
				list = DBproduct.listProduct(conn,price);
			} catch (SQLException e)
			{
				e.printStackTrace();
				errorString = e.getMessage();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			int countProduct= list.size();
			request.setAttribute("countProd", countProduct);			
			request.setAttribute("ProductListServlet", list);
			request.setAttribute("ProductListServlet", list);
			
			  RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/product.jsp");
			  dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
