package model;

import java.util.List;

public class Course {
  private String courseInfo;
  private String homework;
  private String courseName;

  public String getName() {
    return courseName;
  }

  public void setName(String courseName) {
    this.courseName = courseName;
  }

  public String getInfo() {
    return courseInfo;
  }

  public void setInfo(String courseInfo) {
    this.courseInfo = courseInfo;
  }
}
