package utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;

public class MyUtils {
	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	
	private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
			// \wu trat Connection vao attribute cua request.
			// Thong tin luu tro nay chi ton tad trong thoi gian yéu cau (request)
			// cho tdi khi di liéu duge tra vé trinh duyét nguei dung.
	public static void storeConnection(ServletRequest request, Connection conn) {
			request.setAttribute(ATT_NAME_CONNECTION, conn);

			}

			// Lay 46i tugng Connection da duge luu tri trong attribute cla request.

	public static Connection getStoredConnection(ServletRequest request) {
			Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION) ;
			return conn;
			}
}
