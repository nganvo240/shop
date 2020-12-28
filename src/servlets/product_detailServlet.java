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
import beans.product_detail;
import utils.DBproduct;

import utils.MyUtils;

/**
 * Servlet implementation class product_detailServlet
 */
@WebServlet(urlPatterns = { "/product_detail" })
public class product_detailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public product_detailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
               
        String idStr = (String) request.getParameter("id");
        String sizeStr = (String) request.getParameter("itemSize.size");
        System.out.println(idStr+" va "+sizeStr);
        int id = 0;
		/* int size=0; */
        int amountProduct=0;
        List<product_detail> lstsize=null;
        try {
            id = Integer.parseInt(idStr);
			/* size = Integer.parseInt(sizeStr); */
        } catch (Exception e) {
        }
        product p = null;
 
        String errorString = null;
        try {
			p = DBproduct.findProduct(conn, id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
                  
		/*
		 * try { amountProduct = DBproduct.amountProduct(conn, id, size); } catch
		 * (SQLException e1) { // TODO Auto-generated catch block e1.printStackTrace();
		 * }
		 */     
              
        try {
			lstsize = DBproduct.sizeOfProduct(conn, id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        //sửa lỗi tiếng việt
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        // Lưu thông tin vào request attribute trước khi forward sang views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", p);
        request.setAttribute("lstsize", lstsize);
		/* request.setAttribute("amountProduct", amountProduct); */
        
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/views/product_detail.jsp");
        dispatcher.include(request, response);
        
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

    }

}
