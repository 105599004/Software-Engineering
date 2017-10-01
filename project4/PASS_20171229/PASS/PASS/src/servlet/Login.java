package servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import DAO.User_sql;
import config.connectDB;
import model.User;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("test1");
		request.setCharacterEncoding("UTF-8") ;
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String userName = request.getParameter("loginUsername");
		String userPasswd = request.getParameter("loginPassword");
		connectDB con = new connectDB();
		System.out.println(userName+"  "+userPasswd);
		if(User_sql.checkLogin(con.getConnection(), userName, userPasswd))
		{
			User user=User_sql.getUser(con.getConnection(), userName);
			session.setAttribute("role", user);
			response.sendRedirect("HomePage");
			System.out.println(user.getRole());
		}
		else request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

}
