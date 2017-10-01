package DAO;

import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User_sql {
  public static Map<String , Integer> ROLEMAP = new HashMap<String, Integer>(){{
    put("admin",0);
    put("teacher",1);
    put("TA",2);
    put("student",3);
  }};

  public static User getUser(Connection con,String account){
    User user = new User();
    String sql = "select * from user where account =  ? ";
    PreparedStatement preStmt = null;
    ResultSet rs = null;
    try{
      preStmt = con.prepareStatement(sql);
      preStmt.setString(1,account);
      rs = preStmt.executeQuery();
      while (rs.next()){
        user.setId(rs.getInt("id"));
        user.setAccount(rs.getString("account"));
        user.setName(rs.getString("name"));
        user.setEnrollment((rs.getInt("enrollment")==0)? false:true);
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getInt("role"));
        user.setEmail(rs.getString("email"));
      }
      rs.close();
      preStmt.close();
    }catch (Exception e){
        System.out.println("exception : "+e);
    }
    return user;
  }
  
  public static User getUserByID(Connection con,int id){
	    User user = new User();
	    String sql = "select * from user where id = ?";
	    PreparedStatement preStmt = null;
	    ResultSet rs = null;
	    try{
	      preStmt = con.prepareStatement(sql);
	      preStmt.setInt(1,id);
	      rs = preStmt.executeQuery();
	      while (rs.next()){
	        user.setId(rs.getInt("id"));
	        user.setAccount(rs.getString("account"));
	        user.setName(rs.getString("name"));
	        user.setEnrollment((rs.getInt("enrollment")==0)? false:true);
	        user.setPassword(rs.getString("password"));
	        user.setRole(rs.getInt("role"));
	        user.setEmail(rs.getString("email"));
	      }
	      rs.close();
	      preStmt.close();
	    }catch (Exception e){
	        System.out.println("exception : "+e);
	    }
	    return user;
	  }

  public static boolean createUser(Connection con,Map<String,String> data) throws SQLException {
    boolean result = false;
    User user = new User();
    String sql = "INSERT INTO `pass`.`user` (`account`, `password`, `role`, `name`,  `email` , `enrollment`) SELECT * FROM (SELECT ?,?,?,?,?,?) AS tmp WHERE NOT EXISTS (SELECT account FROM user WHERE account = ?) LIMIT 1";

    PreparedStatement preStmt = null;
    try{
      preStmt = con.prepareStatement(sql);
      preStmt.setString(1,data.get("account"));
      preStmt.setString(2,data.get("password"));
      preStmt.setInt(3,Integer.parseInt(data.get("role")));
      preStmt.setString(4,data.get("name"));
      preStmt.setString(5,data.get("email"));
      preStmt.setInt(6,Integer.parseInt(data.get("enrollment")));
      preStmt.setString(7,data.get("account"));
      preStmt.executeUpdate();
      result = true;
    }catch (Exception e){
      System.out.println("create user exception : "+e);
    }finally {
      if(preStmt !=null) preStmt.close();
    }
    return result;
  }

  public static boolean checkLogin(Connection con,String account,String password){
    boolean result = false;
    String sql = "select * from user where account = ? ";
    PreparedStatement preStmt = null ;
    ResultSet rs = null;
    try{
      preStmt = con.prepareStatement(sql);
      preStmt.setString(1,account);
      rs = preStmt.executeQuery();
      if(rs.next()){
        String pw = rs.getString("password");
        if(pw.equals(password)){
          result = true;
        }
      }
      rs.close();
      preStmt.close();
    }catch (Exception e){
        System.out.println("exception :"+e);
    }
    return result;
  }

  public static List<User> getUserList(Connection con){return getUserList(con,"all");}
  public static List<User> getUserList(Connection con,String roleName){
    List<User> list = new ArrayList<User>();
    String sql = "select * from user";
    if(roleName != "all"){
      sql += " where role = "+ROLEMAP.get(roleName);
    }
    PreparedStatement preStmt = null;
    try {
      preStmt = con.prepareStatement(sql);
      ResultSet rs = preStmt.executeQuery();
      while (rs.next()) {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setAccount(rs.getString("account"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setRole(rs.getInt("role"));
        user.setEmail(rs.getString("email"));
        user.setEnrollment(((rs.getInt("enrollment")==0)?false:true));
        list.add(user);
      }
      rs.close();
      preStmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return  list;
  }

  public static boolean updateUserData(Connection con,int userID,Map<String,String> data)
      throws SQLException {
    boolean result = false;
    if(data.isEmpty()) return result;

    String[] dataKeyArray = data.keySet().toArray(new String[0]);
    String sql = "UPDATE `pass`.`user` SET ";
    String updateSql = " ";
    for(int i=0; i < dataKeyArray.length; i++){
      updateSql += dataKeyArray[i]+"= '"+data.get(dataKeyArray[i])+"' ";
      if(i < dataKeyArray.length-1) updateSql +=" , ";
    }
    sql += updateSql+" WHERE `id`="+userID;

    PreparedStatement preStmt = null ;
    ResultSet rs = null;
    try{
      preStmt = con.prepareStatement(sql);
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

  public static boolean changeUserRole(Connection con,int userID,String roleName)
      throws SQLException {
    boolean result = false;
    String sql = "UPDATE `pass`.`user` SET role = ? WHERE id = ? ";
    PreparedStatement preStmt = null;
    try {
      preStmt = con.prepareStatement(sql);
      preStmt.setInt(1, ROLEMAP.get(roleName));
      preStmt.setInt(2, userID);
      preStmt.executeUpdate();
      result = true;
    } catch (Exception e) {
      System.out.println("exception :" + e.toString());
    } finally {
      if (preStmt != null)
        preStmt.close();
    }
    return result;
  }

  public static boolean deleteUser(Connection con,int userID)
      throws SQLException {
    boolean result = false;
    String sql = "DELETE FROM `pass`.`user` WHERE `id`= ?";
    PreparedStatement preStmt = null;
    try {
      preStmt = con.prepareStatement(sql);
      preStmt.setInt(1, userID);
      preStmt.executeUpdate();
      result = true;
    } catch (Exception e) {
      System.out.println("exception :" + e.toString());
    } finally {
      if (preStmt != null)
        preStmt.close();
    }
    return result;
  }

}

