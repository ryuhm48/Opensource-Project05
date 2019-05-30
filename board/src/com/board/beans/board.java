package com.board.beans;

public class board {
	//번호
	private int num;
	
	//제목
	private String subject;
	
	//내용
	private String content;
	
	//아이디
	private String id;
	
	//이메일
	private String email;
	
	//작성일자
	private String boarddate;
	
	//조회수
	private String score;
	
	//검색옵션
	public String opt;
	
	//검색내용
	public String condition;
	
	public String study;
	
	//스터디 이름
	public String name;
	
	//스터디 소개
	public String inform;

	//스터디 관리자
	public String administor;

	//스터디 구성원
	public String member;

	//게시판 번호
	public int boardnum1;

	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBoarddate() {
		return boarddate;
	}
	public void setBoarddate(String boarddate) {
		this.boarddate = boarddate;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInform() {
		return inform;
	}
	public void setInform(String inform) {
		this.inform = inform;
	}
	public String getAdministor() {
		return administor;
	}
	public void setAdministor(String administor) {
		this.administor = administor;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public int getBoardnum1() {
		return boardnum1;
	}
	public void setBoardnum1(int boardnum1) {
		this.boardnum1 = boardnum1;
	}
	public String getStudy() {
		return study;
	}
	public void setStudy(String study) {
		this.study = study;
	}
	
	//replay
	private String text;
	
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text=text;
	}
	
	
}
