package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Course_sql;
import DAO.Record_sql;
import config.connectDB;
import model.Course;
import model.Record;
import model.User;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/Submitstatus")
public class Submitstatus extends HttpServlet {
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
		List<Record> record = new ArrayList<Record>();
		try{
			record = Record_sql.getRecordListByHomeWork(con.getConnection(),1);
			session.setAttribute("record", record);
		}
		catch(SQLException e){
			System.out.println("Submitstatus GET SQLException:" + e.toString());
		}
		request.getRequestDispatcher("Submitstatus.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
