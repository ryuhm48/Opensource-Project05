package com.reply.beans;

public class reply {	
	//사용자 아이디
	private String Id;
	
	//댓글내용
	private String text;
	
	//글 번호
	private int board;
	
	//댓글번호
	private int num;	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getBoard() {
		return board;
	}
	public void setBoard(int board) {
		this.board = board;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		num = num;
	}
}
