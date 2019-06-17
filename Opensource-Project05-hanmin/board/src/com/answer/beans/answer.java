package com.answer.beans;
import java.sql.Timestamp;
import java.sql.Date;

public class answer {

	private int problemNum1;//??ì²? ë¬¸í?? ë²???
	private String answerCode;//???±í?? ì½???
	private String answerLanguage;//???? ì»´í?¨í?? ?¸ì??
	private String writerName;//???±ì?? ?´ë?
	private Boolean problemCorrection;//???? ?¬ë?
	private int answerNum;//??ì¶? ë²???. primary key
	
	public answer()
	{
		super();
	}
	
	public answer(int problemNum1, String answerCode, String answerLanguage, String writerName, Boolean problemCorrection, int answerNum)
	{
		this.problemNum1 = problemNum1;
		this.answerCode = answerCode;
		this.answerLanguage = answerLanguage;
		this.writerName = writerName;
		this.problemCorrection = problemCorrection;
		this.answerNum = answerNum;
	}

	public int getProblemNum1() {
		return problemNum1;
	}

	public void setProblemNum1(int problemNum1) {
		this.problemNum1 = problemNum1;
	}

	public String getAnswerCode() {
		return answerCode;
	}

	public void setAnswerCode(String answerCode) {
		this.answerCode = answerCode;
	}

	public String getAnswerLanguage() {
		return answerLanguage;
	}

	public void setAnswerLanguage(String answerLanguage) {
		this.answerLanguage = answerLanguage;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public Boolean getProblemCorrection() {
		return problemCorrection;
	}

	public void setProblemCorrection(Boolean problemCorrection) {
		this.problemCorrection = problemCorrection;
	}

	public int getAnswerNum() {
		return answerNum;
	}

	public void setAnswerNum(int answerNum) {
		this.answerNum = answerNum;
	}
	
}
