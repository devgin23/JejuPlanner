package com.gteam.planner.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class PlanVO {
    
	/*
CREATE TABLE `plan` (
	`planNo` INT(10) NOT NULL AUTO_INCREMENT,
	`userId` VARCHAR(50) NOT NULL,
	`regDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`planTitle` VARCHAR(200) NOT NULL,
	`startDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`planTotalDay` INT NOT NULL,
	PRIMARY KEY (`planNo`, `userId`) USING BTREE,
	INDEX `PLAN_FK_SET` (`userId`) USING BTREE,
	CONSTRAINT `PLAN_FK_SET` FOREIGN KEY (`userId`) REFERENCES `project`.`member` (`userId`) ON UPDATE NO ACTION ON DELETE CASCADE
);
*/
	
	private int planNo;			//AUTO_INCREMENT
	private String userId;		//(planNo + userId 기본키)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regDate;		
	private String planTitle;
	//Date type mismatch 에러 해결
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	private int planTotalDay;
	//쿼리로 조인할 VO
	private List<ScheduleVO> scheduleVOList;
	
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
	public List<ScheduleVO> getScheduleVOList() {
		return scheduleVOList;
	}
	public void setScheduleVO(List<ScheduleVO> scheduleVOList) {
		this.scheduleVOList = scheduleVOList;
	}
	
	@Override
	public String toString() {
		return "PlanVO [planNo=" + planNo + ", userId=" + userId + ", regDate=" + regDate + ", planTitle=" + planTitle
				+ ", startDate=" + startDate + ", planTotalDay=" + planTotalDay + ", planHit=" + "]";
	}
	
	
}
