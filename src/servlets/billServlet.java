package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
@WebServlet("/bill")
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

	/* @SuppressWarnings("null") */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
		String errorString = null;
        String idPro = (String)request.getParameter("id");
        String Strquantity = (String)request.getParameter("quantity"); 
        String Strsize = (String)request.getParameter("options"); 
        String StrusernameLogin = (String)request.getParameter("usernameLogin");
        String iAction = request.getParameter("action");
        System.out.println("bill_tendnhap: "+StrusernameLogin);
        
        if (iAction != null && !iAction.equals("")) {//khi nhấn submit thêm giỏ hàng
        	if (StrusernameLogin == null || StrusernameLogin.equals("")) {
        		//cho phép mua hàng khi đã đăng nhập, nếu chưa thì chuyển đến trang đăng ký/đăng nhập
        		RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/views/login.jsp");
        		dispatcher.forward(request, response);
        	}else {//xử lý bill+bill_inf
        			int idProduct = 0;
        		 	int customer = 0;
			        int totalMoney = 0;
			        int quantity = 0;
			        int size = 0;
			        
			     try {
			    	 customer = DBcart.IDcustomer(conn, StrusernameLogin);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}			        
			     System.out.println("bill_idcustomer: "+customer);
			        
					  try { idProduct = Integer.parseInt(idPro); }//đổi id từ string sang int 
					  catch (Exception e) {}
					  
					  try { quantity = Integer.parseInt(Strquantity); }
					  catch (Exception e) {}
					  
					  try { size = Integer.parseInt(Strsize); }
					  catch (Exception e) {}
					  
					  
					 //kiểm tra tài khoản đã có giỏ hàng sẵn chưa 
					 int temp = 0;
					 try {
						temp = DBcart.IDBIll_AlreadyExist(conn, StrusernameLogin);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					 System.out.println("bill_idbill: "+temp);
					if (temp==0) {//nếu chưa có giỏ thì insert
						bill b = new bill( customer, totalMoney );      
				        
				        //*******thêm bill**********
				        try {
				            DBcart.insertBill(conn, b);
				        } catch (SQLException e) {
				            e.printStackTrace();
				            errorString = e.getMessage();
				        }
					}		        
			        
			        int bill_id=0;
					try {
						bill_id = DBcart.maxID(conn,StrusernameLogin);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					System.out.println("bill_id:"+bill_id);
					System.out.println("idProduct:"+idProduct);
					System.out.println("quantity:"+quantity+"********************");
					System.out.println("size:"+size+"********************");
			        bill_infor bf = new bill_infor( bill_id, idProduct, quantity, size );
			      //**********thêm bill_infor**********
			        
			        try {
						DBcart.insertBill_infor(conn, bf);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						errorString = e.getMessage();
					}
			    			        
			        // Lưu thông tin vào request attribute trước khi forward sang views.
			        request.setAttribute("errorString", errorString);
			 			        
			        //số lượng sản phẩm trong giỏ hàng
			        //xử lý chuyển trang tùy vào nơi bấm thêm giỏ hàng(cần sửa lại: giữ nguyên trang),
			        RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/product");
					dispatcher.forward(request, response);
        		}
        }
        
	}

}
