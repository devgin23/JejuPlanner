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
	
	//private int bno;			//임시로 주석처리해놓음 (DB에 없는 필드)
	private int planNo;			//조회 및 정렬용 필드 추가 (DB엔 있는 필드인데 VO에 없었음)(05-18)
	private String userId;
	private Date regDate;		//VO에는 있으나 DB에 없는 필드임 추가 필요함
	private String planTitle;	//필드명 변경 title -> planTitle(05-18)
	private Date startDate; 
	//private String content;    필드 삭제(05-18)
	private int planTotalDay; 	//필드추가(05-18)
	private int planHit;		//필드추가(05-18)
	
	public int getPlanNo() {
		return planNo;
	}
	public void setPlanNo(int planNo) {
		this.planNo = planNo;
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
	public String getPlanTitle() {
		return planTitle;
	}
	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getPlanTotalDay() {
		return planTotalDay;
	}
	public void setPlanTotalDay(int planTotalDay) {
		this.planTotalDay = planTotalDay;
	}
	public int getPlanHit() {
		return planHit;
	}
	public void setPlanHit(int planHit) {
		this.planHit = planHit;
	}
	
	
}
