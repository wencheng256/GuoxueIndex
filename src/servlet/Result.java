package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Mysql;
import com.User;

public class Result extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Result() {
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

		response.setContentType("text/html");
		int score=0;
		HttpSession session=request.getSession();
		if(session==null)
		{
			response.sendRedirect("error.html");
			return;
		}
		User user=(User) session.getAttribute("user");
		if(user==null)
		{
			response.sendRedirect("error.html");
			return;
		}
		if(user.getCheck()==1)
		{
			response.sendRedirect("error.html");
			return;
		}else
		{
			user.setCheck(1);
		}
		int[] ans1=(int[]) session.getAttribute("answer");
		PrintWriter out = response.getWriter();
		for(int i=1;i<51;i++)
		{
			String ans=request.getParameter("radio"+i);
			if(ans==null)
				continue;
			else if(Integer.parseInt(ans)==ans1[i])
			{
				score+=2;
			}
		}
		String time=request.getParameter("time");
		user.setTime(Integer.parseInt(time));
		user.setGrade(score);
		Mysql mysql=Mysql.getInstance();
		mysql.saveScore(user.getNum(), score, Integer.parseInt(time));
		response.sendRedirect("result.jsp");
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
