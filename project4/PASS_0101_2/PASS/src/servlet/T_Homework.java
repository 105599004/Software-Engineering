package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
import model.Homework;
import model.User;

import java.util.ArrayList;
import java.util.List;

@WebServlet("/T_Homework")
public class T_Homework extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
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
		try {
			List<Homework> homework = new ArrayList<Homework>();
			homework = Homework_sql.getHomeworkList(con.getConnection());
			session.setAttribute("homework", homework);
			System.out.println(homework.get(0).getId());
			System.out.println(homework.get(0).getDate());
			System.out.println(homework.get(0).getDescription());
			System.out.println(homework.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("T_Homework.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
