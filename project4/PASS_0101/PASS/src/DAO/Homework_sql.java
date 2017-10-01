package DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Homework;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Homework_sql {
	public static boolean createHomework(Connection con ,String description,Date dead_line) throws SQLException {
		 boolean result = false;
		 String sql = "INSERT INTO `homework` (`description`, `dead_line`) VALUES (?,?);";
		 PreparedStatement preStmt = null;
		 ResultSet rs = null;
		 try{
			 java.sql.Date sqlDate = new java.sql.Date(dead_line.getTime());
			 preStmt = con.prepareStatement(sql);
		     preStmt.setString(1,description);
		     preStmt.setDate(2, sqlDate);
		     preStmt.executeUpdate();
		     result = true;
		 }catch (Exception e){
			 System.out.println("exception : "+e);
		 }finally {
		     if(rs != null) rs.close();
		     if(preStmt != null) preStmt.close();
		 }
		 return result;
	 }
	
	public static List<Homework> getHomeworkList(Connection con) throws SQLException {
		 List<Homework> hw_list = new ArrayList<Homework>();
		 String sql = "SELECT * FROM homework;";
		 PreparedStatement preStmt = null;
		 preStmt = con.prepareStatement(sql);
		 ResultSet rs = preStmt.executeQuery();
		 while (rs.next()) {
			 Homework hw = new Homework();
			 hw.setId(rs.getInt("id"));
			 hw.setDate(rs.getDate("dead_line"));
			 hw.setDescription(rs.getString("description"));
		     hw_list.add(hw);
		 }
		 if(rs != null) rs.close();
		 if(preStmt != null) preStmt.close();
		 return hw_list;
	 }
}
