package com.gteam.planner.domain;

import java.util.Date;

public class PlanVO {
    
	/*
	CREATE TABLE prj_board 
	 (bno INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	  userId VARCHAR(20) NOT NULL,
	  regDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	  title VARCHAR(50) NOT NULL,
	  content TEXT NOT NULL
	  );*/
	private int bno;
	private String userId;
	private Date regDate;
	private String title;
	private String content;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
