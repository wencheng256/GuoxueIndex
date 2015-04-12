package servlet;

import java.io.IOException;

import com.*;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Mysql;

public class Login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Login() {
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
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		//System.out.println(name+pass);
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession(true);
		
		if(name==""&&pass=="")
		{
			response.sendRedirect("index.jsp");
			return;
		}
		User user=new User(name);
		Mysql mysql=Mysql.getInstance();
		String sql="SELECT a.name,a.class,c.score,c.time from user as a,grade as c WHERE c.user=a.num AND a.num='"+name+"'";
		String sql1="SELECT a.name,a.class from user as a WHERE a.num='"+name+"'";
		switch(mysql.getCheck(name, pass)){
		case 1:
			try {
				ResultSet rs=mysql.query(sql);
				rs.next();
				user.setCheck(1);
				user.setCla(rs.getInt(2));
				user.setGrade(rs.getInt(3));
				user.setName(rs.getString(1));
				user.setTime(rs.getInt(4));
				session.setAttribute("user",user);
				response.sendRedirect("result.jsp");
				break;
			} catch (SQLException e) {
				// TODO �Զ���ɵ� catch ��
				Logger.getLogger("log").log(Level.WARNING,e.getMessage());
				response.sendRedirect("exist.html");
				break;
			}
		case 0:
			try {
				ResultSet rs=mysql.query(sql1);
				rs.next();
				user.setCheck(0);
				user.setCla(rs.getInt(2));
				user.setName(rs.getString(1));
				session.setAttribute("user",user);
				response.sendRedirect("start.html");
				break;
			} catch (SQLException e) {
				// TODO �Զ���ɵ� catch ��
				Logger.getLogger("log").log(Level.WARNING,e.getMessage());
				response.sendRedirect("error.html");
				break;
			}
		default:
			response.sendRedirect("exist.html");
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
