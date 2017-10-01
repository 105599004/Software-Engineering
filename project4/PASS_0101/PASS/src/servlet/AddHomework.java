package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Course_sql;
import DAO.Homework_sql;
import config.connectDB;
import model.Course;
import model.User;
import java.text.ParseException;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/AddHomework")
public class AddHomework extends HttpServlet {
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
		connectDB con = new connectDB();
		try {
			Course course = Course_sql.getCourse(con.getConnection());
			session.setAttribute("course", course);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("AddHomework.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8") ;
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		System.out.println("AddHomework.java post:");
		System.out.println("dateline:" + request.getParameter("dateline"));
		System.out.println("homeworkcontent:" + request.getParameter("homeworkcontent"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String dateInString = "1982-05-05 10:20:56";
	    connectDB con = new connectDB();
	    try {
	    	Date date = sdf.parse(request.getParameter("dateline"));
		    Homework_sql.createHomework(con.getConnection(),request.getParameter("homeworkcontent"), date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ParseException e:" + e.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQLException e:" + e.toString());
		}
	    response.sendRedirect("AddHomework");
	}

}
