package model;

import java.sql.Date;

public class Homework {
	private int id;
	private String description;
	private Date dead_line;
	
	public int getId() {
		return id;
	 }

	 public void setId(int i) {
		this.id = i;
	 }
	 
	 public String getDescription() {
		return description;
	 }

	 public void setDescription(String description) {
		this.description = description;
	 }
	 
	 public void setDate(Date dead_line) {
		this.dead_line = dead_line;
	 }
	 
	 public Date getDate() {
		return dead_line;
	 }
}
