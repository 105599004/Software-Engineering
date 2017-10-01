package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Record;
import model.User;

public class Record_sql {
	 public static boolean createRecord(Connection con , int hw_id,int student_id,int score) throws SQLException {
		 boolean result = false;
		 String sql = "INSERT INTO `record` (`hw_id`, `student_id`, `score`) SELECT * FROM (SELECT ?,?,?) AS tmp WHERE NOT EXISTS (SELECT hw_id FROM record WHERE hw_id = ? and student_id =?) LIMIT 1";
		 PreparedStatement preStmt = null;
		 ResultSet rs = null;
		 try{
			 preStmt = con.prepareStatement(sql);
		     preStmt.setInt(1,hw_id);
		     preStmt.setInt(2,student_id);
		     preStmt.setInt(3,score);
		     preStmt.setInt(4,hw_id);
		     preStmt.setInt(5,student_id);
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
	
	 public static List<Record> getRecordListByHomeWork(Connection con , int homeworkID) throws SQLException {
		 List<Record> recordList = new ArrayList<Record>();
		 String sql = "select * from record where hw_id = ? ";
		 PreparedStatement preStmt = null;
		 ResultSet rs = null;
		 try{
			 preStmt = con.prepareStatement(sql);
		     preStmt.setInt(1,homeworkID);
		     rs = preStmt.executeQuery();
		     while (rs.next()){
		    	 Record record = new Record();
		    	 record.setId(rs.getInt("hw_id"));
		    	 record.setScore(rs.getInt("score"));
		    	 record.setStudentID(rs.getInt("student_id"));
		    	 recordList.add(record);
		     }
		 }catch (Exception e){
			 System.out.println("exception : "+e);
		 }finally {
		     if(rs != null) rs.close();
		     if(preStmt != null) preStmt.close();
		 }
		 return recordList;
	}
	 
	public static List<Record> getRecordListByStudent(Connection con , int studentID) throws SQLException {
		 List<Record> recordList = new ArrayList<Record>();
		 String sql = "select * from record where student_id = ? ";
		 PreparedStatement preStmt = null;
		 ResultSet rs = null;
		 try{
			 preStmt = con.prepareStatement(sql);
		     preStmt.setInt(1,studentID);
		     rs = preStmt.executeQuery();
		     while (rs.next()){
		    	 Record record = new Record();
		    	 record.setId(rs.getInt("hw_id"));
		    	 record.setScore(rs.getInt("score"));
		    	 record.setStudentID(rs.getInt("student_id"));
		    	 recordList.add(record);
		     }
		 }catch (Exception e){
			 System.out.println("exception : "+e);
		 }finally {
		     if(rs != null) rs.close();
		     if(preStmt != null) preStmt.close();
		 }
		 return recordList;
	}
	
	public static boolean updateScore(Connection con , Record record) throws SQLException {
		 boolean result = false;
		 String sql = "UPDATE `pass`.`record` SET score = ? where hw_id = ? and student_id = ?";
		 PreparedStatement preStmt = null;
		 ResultSet rs = null;
		 try{
			 preStmt = con.prepareStatement(sql);
		     preStmt.setInt(1,record.getScore());
		     preStmt.setInt(2,record.getId());
		     preStmt.setInt(3,record.getStudentID());
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
	
	public static boolean deleteScore(Connection con ,int hw_id ,int student_id) throws SQLException {
		 boolean result = false;
		 String sql = "delete FROM `record` WHERE hw_id = ? and student_id = ?";
		 PreparedStatement preStmt = null;
		 ResultSet rs = null;
		 try{
			 preStmt = con.prepareStatement(sql);
		     preStmt.setInt(1,hw_id);
		     preStmt.setInt(2,student_id);
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
}
