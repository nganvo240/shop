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
import beans.bill_infor;
import beans.product;
import beans.product_detail;
import beans.user;
import utils.DBcart;
import utils.DBproduct;
import utils.DBuser;
import utils.MyUtils;

/**
 * Servlet implementation class cartServlet
 */
@WebServlet(name="bill", urlPatterns= {"/bill"})
public class billServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public billServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);

        String idPro = (String)request.getParameter("action");
        String Strquantity = (String)request.getParameter("quantity"); 
        
        int customer = 0;
        int totalMoney = 0;
        int quantity = 1;
        
		  int idProduct = 0; try { idProduct = Integer.parseInt(idPro); }//đổi id từ string sang int }
		  catch (Exception e) {}
		  
		  try { quantity = Integer.parseInt(Strquantity); }
		  catch (Exception e) {}
		  
		 
        bill b = new bill( customer, totalMoney );      
        String errorString = null;
        //thêm bill
        try {
            DBcart.insertBill(conn, b);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        int bill_id=0;
		try {
			bill_id = DBcart.maxID(conn);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(bill_id+"********************");
		System.out.println(idProduct+"********************");
		System.out.println(quantity+"********************");
        bill_infor bf = new bill_infor( bill_id, idProduct, quantity );
      //thêm bill_infor
        try {
			DBcart.insertBill_infor(conn, bf);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
        
        // Lưu thông tin vào request attribute trước khi forward sang views.
        request.setAttribute("errorString", errorString);
		/* request.setAttribute("sinhvien", b); */
 
        // Nếu có lỗi forward sang trang edit.
        if (errorString != null) {
        	System.out.println("that bai");
        }
        // Nếu mọi thứ tốt đẹp.
        else {
        	System.out.println("thành công");
        }
		 
	}

}
