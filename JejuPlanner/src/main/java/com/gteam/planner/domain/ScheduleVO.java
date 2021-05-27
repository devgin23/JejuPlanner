package com.gteam.planner.domain;

/* SQL DDL
 CREATE TABLE `schedule` (
	`planNo` INT NOT NULL,
	`userId` VARCHAR(50) NOT NULL,
	`descript` VARCHAR(200) NULL DEFAULT NULL,
	`addr` VARCHAR(50) NOT NULL,
	`planDay` INT NOT NULL,
	`startTime` INT NULL DEFAULT '900',
	`rowNo` INT,
	INDEX `SCHEDULE_FK_SET` (`planNo`, `userId`) USING BTREE,
	CONSTRAINT `SCHEDULE_FK_SET` FOREIGN KEY (`planNo`, `userId`) REFERENCES `project`.`plan` (`planNo`, `userId`) ON UPDATE NO ACTION ON DELETE CASCADE
);
 */

public class ScheduleVO {
	

	
	private int planNo;
	private String userId;
	private String descript;
	private String addr;
	private int planDay;
	
	private int startTime;
//	private int rowNo;
	
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
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getPlanDay() {
		return planDay;
	}
	public void setPlanDay(int planDay) {
		this.planDay = planDay;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
//	public int getRowNo() {
//		return rowNo;
//	}
//	public void setRowNo(int rowNo) {
//		this.rowNo = rowNo;
//	}
	
	@Override
	public String toString() {
		return "ScheduleVO [planNo=" + planNo + ", userId=" + userId + ", descript=" + descript + ", addr=" + addr
				+ ", planDay=" + planDay + ", startTime=" + startTime +  "]";
	}
}
