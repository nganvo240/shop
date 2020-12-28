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
 * Servlet implementation class searchResultsServlet
 */
@WebServlet("/searchResultsServlet")
public class searchResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchResultsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		  Connection conn = MyUtils.getStoredConnection(request) ;
		  String key = (String ) request.getParameter("search");
		  System.out.println(key+" ***********");
		  String errorString = null; 
		  List<product> list = null; 
		  try { 
			  list = DBproduct.listProduct_search(conn, key); 
		}
		  catch (SQLException e) { 
			  e.printStackTrace(); 
			  errorString = e.getMessage(); 
		}
		  catch (ClassNotFoundException e) { 
			  // TODO Auto-generated catch block
		  e.printStackTrace(); 
		  } 
		  
		  int countProduct= list.size();
		  request.setAttribute("countProd", countProduct);		  
		  request.setAttribute("ProductListServlet", list);		 
		  request.setAttribute("search_word", key);
		  
		  RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/views/searchResults.jsp");
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
