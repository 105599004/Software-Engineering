package DAO;
import model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Course_sql {
  public static Course getCourse(Connection con) throws SQLException {
    Course course = new Course();
    String sql = "select * from course ";
    PreparedStatement preStmt = null;
    ResultSet rs = null;
    try{
      preStmt = con.prepareStatement(sql);
      rs = preStmt.executeQuery();
      while (rs.next()){
        course.setInfo(rs.getString("courseInfo"));
        course.setName(rs.getString("name"));
      }
    }catch (Exception e){
      System.out.println("exception : "+e);
    }finally {
      if(rs != null) rs.close();
      if(preStmt != null) preStmt.close();
    }
    return course;
  }

  public static boolean updateCourse(Connection con,String name,String courseInfo)
      throws SQLException {
    boolean result = false;
    if(courseInfo.isEmpty()) return result;
    String sql = "UPDATE `pass`.`course` SET courseInfo = ? WHERE  name = ?";

    PreparedStatement preStmt = null ;
    ResultSet rs = null;
    try{
      preStmt = con.prepareStatement(sql);
      preStmt.setString(1,courseInfo);
      preStmt.setString(2,name);
      preStmt.executeUpdate();
      result = true;
    }catch (Exception e){
      System.out.println("exception :"+e.toString());
    }finally {
      if(rs != null) rs.close();
      if(preStmt != null) preStmt.close();
    }
    return result;
  }
}
