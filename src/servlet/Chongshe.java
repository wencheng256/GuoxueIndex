package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Mysql;

public class Chongshe extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Chongshe() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num=request.getParameter("num");
		String verify =request.getParameter("verify");
		String pass=request.getParameter("pass");
		
		HttpSession session=request.getSession(true);
		String ver=(String) session.getAttribute("verify");
		//System.out.println(ver);
		if(ver==null)
		{
			response.sendRedirect("error.html");
			return;
		}
		if(ver.equals(verify))
		{
			String sql="UPDATE user SET password='"+pass+"' WHERE num="+num;
			Mysql mysql=Mysql.getInstance();
			try {
				mysql.update(sql);
				response.sendRedirect("index.jsp");
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				response.sendRedirect("error.html");
			}
		}		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
