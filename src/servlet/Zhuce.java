package servlet;

import java.io.IOException;
import com.User;

import com.Mysql;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Zhuce extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Zhuce() {
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
		HttpSession session=request.getSession(true);
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		Mysql mysql=Mysql.getInstance();
		String name=request.getParameter("name");
		String cla=request.getParameter("class");
		String email=request.getParameter("email");
		String num=request.getParameter("num");
		String pass=request.getParameter("pass");
		//System.out.println(name+cla+email+num+pass);
		
		try {
			mysql.insert("user", "name,class,email,num,password", "'"+name+"','"+cla+"','"+email+"','"+num+"','"+pass+"'");
			User user=new User(num);
			user.setCheck(0);
			user.setGrade(0);
			user.setName(name);
			user.setCla(Integer.parseInt(cla));
			session.setAttribute("user", user);
			response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			out.println(e.getMessage());
			response.sendRedirect("error.html");
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
