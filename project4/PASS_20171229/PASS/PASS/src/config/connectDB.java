package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectDB {
  private String schema = "sais_default";
  private Connection con = null;
  private String myUID = "root";
  private String myPassword = "root";
  private String jdbcName = "com.mysql.jdbc.Driver";

  public connectDB() {}
  public Connection getConnection() {
    if (this.con == null) {
      try {
        BuildConnection();
      } catch (Exception ex) {}
    }
    return this.con;
  }

  public void BuildConnection() throws Exception {
    try {
      if (this.con != null) {
        this.con.close();
      }
      Class.forName(jdbcName);
      this.con = DriverManager.getConnection("jdbc:mysql://140.124.181.10:3306/pass","root", "root");
    } catch (Exception ex) {
        ex.printStackTrace();
      throw ex;
    }
  }

  public void closeCon() {
    try {
      if (this.con != null) {
        this.con.close();
      }
      this.con = null;
    } catch (Exception sex) {
    } finally {
      this.con = null;
    }
  }
}
