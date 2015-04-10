package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Email;
import com.Mysql;

public class Find extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Find() {
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
		String random="";
		Random rand=new Random();
		String num=request.getParameter("num");
		//System.out.println(num);
		for(int i=0;i<6;i++)
		{
			random+=rand.nextInt(9)+1;
		}
		HttpSession session=request.getSession(true);
		session.setAttribute("verify",random);
		Email mail=Email.getInstance();
		Mysql mysql=Mysql.getInstance();
		String to=mysql.getEmail(num);
		//System.out.println(to);
		int status=mail.sendMail(to, "山东大学（威海）国学达人密码重置邮件", "您好，您的密码修改验证码为"+random+"<br/>(请勿将验证码告诉他人，系统邮件请勿回复！如非亲自操作，请忽略此邮件)");
		if(status==1)
		{
			response.sendRedirect("chongshe.html");
		}else
		{
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
