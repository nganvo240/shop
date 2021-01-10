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

import beans.productFromCart;
import utils.DBcart;
import utils.MyUtils;

/**
 * Servlet implementation class cartServlet
 * @param <cart>
 */
@WebServlet(name="cart", urlPatterns= {"/cart"})
public class cartServlet<cart> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request) ;
		String usernameLogin = (String)request.getParameter("usernameLogin");
		System.out.println("cart_teen dang nhap la:"+ usernameLogin);
		String errorString = null;
		List<productFromCart> list = null;
		try {
			list = DBcart.listProductFromCart(conn, usernameLogin);
			System.out.println("ds productFromCart");
		} catch (SQLException e)
		{
			e.printStackTrace();
			errorString = e.getMessage();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		int totalMoney=0;
		try {
			totalMoney = DBcart.TotalMoney(conn, usernameLogin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("productsCart", list);
		request.setAttribute("totalMoney", totalMoney);
		RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/views/cart.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request) ;
		String usernameLogin = (String)request.getParameter("usernameLogin");
		String StrNumRow = (String)request.getParameter("stt");
        String iAction = (String)request.getParameter("action");
        String StrtotalMoney = (String)request.getParameter("totalMoney");
        String Strquantity = (String)request.getParameter("quantity");
        
        int totalMoney=0;
        int NumRow=0;
        int bill_id=0;
        int quantity=0;
        
        try { quantity = Integer.parseInt(Strquantity);
        } catch (Exception e) { }
        
        try { totalMoney = Integer.parseInt(StrtotalMoney);
        } catch (Exception e) { }
        
        try { NumRow = Integer.parseInt(StrNumRow);
        } catch (Exception e) { }
        
        try {
			bill_id = DBcart.getBillID_ByUrname(conn, usernameLogin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("cart_StrNumRow:"+NumRow);
        if (iAction != null && !iAction.equals("")) {
            if (iAction.equals("XÃ³a")) {
            	            	           	
            	try {
					DBcart.delProFromCart(conn, bill_id, NumRow);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
				 response.sendRedirect("cart?usernameLogin="+usernameLogin); 
            	            	
            }
            else if (iAction.equals("Cáº­p nháº­t")) {
            	try {
					DBcart.updateProInCart(conn, quantity, bill_id, NumRow);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	System.out.println("cart_StrNumRow:"+NumRow);
                System.out.println("cart_quantity:"+quantity);      
                System.out.println("cart_iAction:"+iAction);
                response.sendRedirect("cart?usernameLogin="+usernameLogin); 
            }
            else if (iAction.equals("Thanh toÃ¡n")) {
            	try {
					DBcart.updateBill(conn, totalMoney, usernameLogin);
					System.out.println(totalMoney+"******");
					System.out.println(usernameLogin+"******");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	request.setAttribute("testBuy", 1);
            	RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/views/cart.jsp");
        		dispatcher.forward(request, response);
            }
            
        }
        
        request.setAttribute("usernameLogin", usernameLogin);
		/* response.sendRedirect(request.getContextPath() + "/cart"); */
        
	}

}
