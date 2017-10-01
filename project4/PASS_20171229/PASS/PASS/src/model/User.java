package model;

public class User {
  private int id;
  private String account;
  private String password;
  private String name;
  private String email;
  private int role;
  private boolean enrollment;

  public int getId() {
    return id;
  }

  public void setId(int i) {
    this.id = i;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setRole(int role) {
    this.role = role;
  }

  public int getRole() {
    return role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(){
    this.email = email;
  }

  public boolean getEnrollment() {
    return enrollment;
  }

  public void setEnrollment(boolean enrollment) {
    this.enrollment = enrollment;
  }

}
