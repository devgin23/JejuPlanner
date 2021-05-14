package com.gteam.domain;

import java.util.Date;

/* SQL DDL
 * CREATE TABLE member(
userId VARCHAR(30) NOT NULL,
userPw VARCHAR(100) NOT NULL,
userNo INT PRIMARY KEY AUTO_INCREMENT,
userNickname VARCHAR(30) NOT NULL,
userGender VARCHAR(2) NOT NULL,
userAge INT(3) NOT NULL,
userMail VARCHAR(30) NOT NULL,
regDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
unique(userNickname)
);*/

public class MemberVO {

	private String userId;
	private String userPw;
	private int userNo;
	private String userNickname;
	private String userGender;
	private String userMail;
	private int userAge;
	private Date regDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getuserNickname() {
		return userNickname;
	}
	public void setuserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public String toStringLogin() {
		return "MemberVO [userId=" + userId + ", userPw=" + userPw + "]";
	}
}
