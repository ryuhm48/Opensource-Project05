package com.board.beans;

public class board {
	//��ȣ
	private int num;
	
	//����
	private String subject;
	
	//����
	private String content;
	
	//���̵�
	private String id;
	
	//�̸���
	private String email;
	
	//�ۼ�����
	private String boarddate;
	
	//��ȸ��
	private String score;
	
	//�˻��ɼ�
	public String opt;
	
	//�˻�����
	public String condition;
	
	public String study;
	
	//���͵� �̸�
	public String name;
	
	//���͵� �Ұ�
	public String inform;

	//���͵� ������
	public String administor;

	//���͵� ������
	public String member;

	//�Խ��� ��ȣ
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
