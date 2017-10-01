package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.User_sql;
import config.connectDB;
import model.User;

/**
 * Servlet implementation class Infromation
 */
@WebServlet("/Information")
public class Information extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8") ;
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		User user=(User) session.getAttribute("role");
		if (user == null) {
			response.sendRedirect("Login");
			return;
		}
		request.getRequestDispatcher("information.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8") ;
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		System.out.println("Information_POST password=" + userPassword);
		System.out.println("Information_POST email=" + request.getParameter("email"));
		/*
		do update DB here
		 */
		User user=(User) session.getAttribute("role");
		user.setPassword(userPassword);
		user.setEmail(userEmail);
		Map<String,String> data = new HashMap<String,String>();
		data.put("password", userPassword);
		data.put("email", userEmail);
		connectDB con = new connectDB();
		try {
			User_sql.updateUserData(con.getConnection(),user.getId(),data);
			System.out.println("information.java updateUserData");;
		} 
		catch (SQLException e) {
			System.out.println(e.toString());;
		}
		response.sendRedirect("Information");
	}

}
