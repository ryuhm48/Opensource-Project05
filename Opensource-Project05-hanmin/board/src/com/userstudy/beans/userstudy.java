package com.userstudy.beans;

public class userstudy {
	private int num;
	//스터디 이름
	private String userid;
	
	//스터디 소개
	private String studynum;

	private boolean tag;
	
	public int getNum() {
		return num;
		
	}
	public void setNum(int num) {
		this.num=num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getStudynum() {
		return studynum;
	}
	public void setStudynum(String studynum) {
		this.studynum = studynum;
	}
	public boolean getTag() {
		return tag;
	}
	public void setTag(boolean tag) {
		this.tag = tag;
	}
	
}
