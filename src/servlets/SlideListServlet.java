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

import beans.slide;
import utils.DBslide;
import utils.DBuser;
import utils.MyUtils;

/**
 * Servlet implementation class SlideListServlet
 */
 @WebServlet("/SlideListServlet") 
/* @WebServlet(name="SlideListServlet", urlPatterns= {"/SlideListServlet"}) */
public class SlideListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**     * @see HttpServlet#HttpServlet()
     */
    public SlideListServlet() {
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
		List<slide> list = null;
		try {
			list = DBslide.listSlide(conn);
		} catch (SQLException e)
		{
			e.printStackTrace();
			errorString = e.getMessage();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		request.setAttribute("SlideListServlet", list);
		
		  RequestDispatcher dispatcher =
		  request.getServletContext().getRequestDispatcher("/views/slider.jsp");
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
