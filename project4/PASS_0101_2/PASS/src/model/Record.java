package model;

public class Record {
	private int id;
	private int student_id;
	private int score;
	
	 public int getId() {
		return id;
	 }

	 public void setId(int i) {
		this.id = i;
	 }
	 
	 public int getStudentID() {
		return student_id;
	 }

	 public void setStudentID(int id) {
		this.student_id = id;
	 }
	 
	 public void setScore(int score) {
		this.score = score;
	 }
	 
	 public int getScore() {
		return score;
	 }
}
