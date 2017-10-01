import DAO.Course_sql;
import DAO.Homework_sql;
import DAO.Record_sql;
import model.Course;
import model.Homework;
import model.Record;
import model.User;
import DAO.User_sql;
import config.connectDB;

import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class main {
  public static void main(String[] args) throws SQLException {
    connectDB con = new connectDB();
    /********************使用者*************************/
    //roleName = 學生(student) 老師(teacher) 助教(TA)

    //登入
    String account = "student4";
    String password ="123123";

    System.out.println("login : "+User_sql.checkLogin(con.getConnection(), "student4", "123123"));

    //取得   使用者資料
    User user = new User_sql().getUser(con.getConnection(), account);
    System.out.println("get user data : " + user.getAccount());
    System.out.println("get user enrollment : " + user.getEnrollment());

    //取得   所有使用者名單
    List<User> us1 = User_sql.getUserList(con.getConnection());
    for (int i = 0; i < us1.size(); i++)
      System.out.println("user list :"+us1.get(i).getAccount());

    //取得   學生(student) 老師(teacher) 助教(TA)名單
    List<User> us2 = User_sql.getUserList(con.getConnection(), "TA");
    for (int i = 0; i < us2.size(); i++)
      System.out.println("student list :"+us2.get(i).getAccount());

    //更新   學生資料
    Map<String,String> dataMap = new HashMap();
    dataMap.put("account","student4");
    dataMap.put("name","賴偉程");
    dataMap.put("password","123123");
    dataMap.put("email","gunchahue@jiji.jije.com");
    dataMap.put("enrollment","1");
    boolean b = User_sql.updateUserData(con.getConnection(),3,dataMap);
    System.out.println("更新使用者資訊 : "+ b);

    //新增   使用者
    Map<String,String> dataMap2 = new HashMap();
    dataMap2.put("account","ta02");
    dataMap2.put("password","22222222");
    dataMap2.put("role","2");
    dataMap2.put("name","助教");
    dataMap2.put("email","gunchahue@jiji.jije.com");
    dataMap2.put("enrollment","1");
    boolean b2 = User_sql.createUser(con.getConnection(),dataMap2);
    User newUser = User_sql.getUser(con.getConnection(), dataMap2.get("account"));
    System.out.println("get user data => user name :" + newUser.getName()); //null表示帳號已存在

    //權限   改變
    boolean b3 = User_sql.changeUserRole(con.getConnection(),newUser.getId(),"TA");
    System.out.println("change user role :"+b3);

    //刪除   使用者(透過userID刪除使用者)
    //boolean b4 = User_sql.deleteUser(con.getConnection(),newUser.getId());
    //System.out.println("delete user : "+b4);

    /********************課程*************************/
    //取得   課程資料
    Course course = Course_sql.getCourse(con.getConnection());
    System.out.println("課程名稱 : "+course.getName()+", 課程資訊 : "+course.getInfo());

    //修改  課程資訊
    System.out.println("修改課程資訊 : "+Course_sql.updateCourse(con.getConnection(),course.getName(),"軟體的工程"));

    //取得   學生(student) 助教(TA)名單在上面

    //取得   作業列表(還沒做)
    System.out.println("~~~~學生作業列表~~~~");
    List<Record> recordList = Record_sql.getRecordListByStudent(con.getConnection(), user.getId());
    for (int i = 0; i < recordList.size(); i++) {
        System.out.println("record id :"+recordList.get(i).getId());
        System.out.println("record score :"+recordList.get(i).getScore());
        User user5 = User_sql.getUserByID(con.getConnection(), recordList.get(i).getStudentID());
        System.out.println("user name :"+user5.getName());
        
    }
    /********************作業*************************/
    System.out.println("-------------------作業-------------------");
    System.out.println("~~~~課程作業列表~~~~");
    List<Record> recordList2 = Record_sql.getRecordListByHomeWork(con.getConnection(),1);
    for (int i = 0; i < recordList2.size(); i++) {
        System.out.println("record id :"+recordList2.get(i).getId());
        System.out.println("record score :"+recordList2.get(i).getScore());
        User user5 = User_sql.getUserByID(con.getConnection(), recordList2.get(i).getStudentID());
        System.out.println("user name :"+user5.getName());
    }
    
    //修改成績
    System.out.println("~~~~修改作業成績~~~~");
    Record record = recordList2.get(0);
    record.setScore(10);
    boolean b5 = Record_sql.updateScore(con.getConnection(), record);
    System.out.println("update score :"+b5);
    
    //新增作業繳交紀錄(沒有判斷作業與學生是否存在)
    System.out.println("~~~~新增作業繳交紀錄~~~~");
    boolean b6 = Record_sql.createRecord(con.getConnection(),1, 15, 55);
    System.out.println("create record :"+b6);
    
    //刪除作業紀錄
    System.out.println("~~~~刪除作業繳交紀錄~~~~");
    boolean b7 = Record_sql.deleteScore(con.getConnection(), 1, 15);
    System.out.println("delete record :"+b7);
    
    //新增作業
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateInString = "1982-05-05 10:20:56";
    try {
		Date date = sdf.parse(dateInString);
	    boolean b8 = Homework_sql.createHomework(con.getConnection(),"作業要交喔", date);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    //boolean b8 = Homework_sql.createHomework(con.getConnection(),"作業要交喔", );

    //取得作業列表
    List<Homework> hwlist2 = Homework_sql.getHomeworkList(con.getConnection());
    for (int i = 0; i < hwlist2.size(); i++) {
        System.out.println("hw id :"+hwlist2.get(i).getId());
        System.out.println("hw description :"+hwlist2.get(i).getDescription());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(hwlist2.get(i).getDate().getTime());

        System.out.println("hw dead_line " + df.format(calendar.getTime()));
    }
  }
}

