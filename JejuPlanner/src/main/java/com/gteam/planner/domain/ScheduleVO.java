package com.gteam.planner.domain;

public class ScheduleVO {
	
/*
CREATE TABLE `schedule` (
	`planNo` INT NOT NULL,
	`userId` VARCHAR(50) NOT NULL,
	`descript` VARCHAR(200) NULL DEFAULT NULL,
	`place` VARCHAR(50) NOT NULL, 
	`addr` VARCHAR(50) NOT NULL,
	`planDay` INT NOT NULL DEFAULT '0',
	`startTime` INT NULL DEFAULT '900',
	`rowNo` INT DEFAULT '0',
	INDEX `SCHEDULE_FK_SET` (`planNo`, `userId`) USING BTREE,
	CONSTRAINT `SCHEDULE_FK_SET` FOREIGN KEY (`planNo`, `userId`) REFERENCES `project`.`plan` (`planNo`, `userId`) ON UPDATE NO ACTION ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 */
	
	private int planNo;
	private String userId;
	private String descript;
	private String place;
	private String addr;
	private double longitude;
	private double latitude;
	private int planDay;
	private int startTime;
	private int rowNo;
	
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
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
	
	public int getRowNo() {
		return rowNo;
	}
	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}
	@Override
	public String toString() {
		return "ScheduleVO [planNo=" + planNo + ", userId=" + userId + ", descript=" + descript + ", place=" + place
				+ ", addr=" + addr + ", longitude=" + longitude + ", latitude=" + latitude + ", planDay=" + planDay
				+ ", startTime=" + startTime + ", rowNo=" + rowNo + "]";
	}
	
	
	
}
