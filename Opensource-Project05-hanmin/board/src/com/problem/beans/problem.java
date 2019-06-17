package com.problem.beans;
import java.sql.Timestamp;
import java.sql.Date;

public class problem {
	
	private int studyNum;
	private int problemNum1;//??ì²? ë¬¸í?? ë²???. priority key
	private int problemNum2;//?¤í?°ë?? ?´ë??????? ë²???.
	private String problemName;//ë¬¸ì?? ??ëª?
	private String problemContent;//ë¬¸ì?? ?´ì??
	private String problemLanguage;//ê´??? ì»´í?¨í?? ?¸ì??
	private String writerName;//???±ì?? ?´ë?
	private Date problemDate;//ê¸°ë? ?¼ì??
	private int commentNum;//?µê? ??

	private String problemInput;
	private String problemOutput;
	private String problemInputEx;
	private String problemOutputEx;
	
	public problem()
	{
		super();
		this.commentNum = 0;
	}
	
	public problem(int studyNum, int problemNum1, int problemNum2, String problemName, String problemLanguage, String writerName, Date problemDate, String problemContent, String problemInput, String problemOutput)
	{
		this.commentNum = 0;
		this.studyNum = studyNum;
		this.problemNum1 = problemNum1;
		this.problemNum2 = problemNum2;
		this.problemName = problemName;
		this.problemLanguage = problemLanguage;
		this.writerName = writerName;
		this.problemDate = problemDate;
		this.problemContent = problemContent;
		this.problemInput = problemInput;
		this.problemOutput = problemOutput;
		this.problemInputEx = problemInputEx;
		this.problemOutputEx = problemOutputEx;
	}
	
	public int getStudyNum() {
		return studyNum;
	}

	public void setStudyNum(int studyNum) {
		this.studyNum = studyNum;
	}

	public int getProblemNum1() {
		return problemNum1;
	}

	public void setProblemNum1(int problemNum1) {
		this.problemNum1 = problemNum1;
	}

	public int getProblemNum2() {
		return problemNum2;
	}

	public void setProblemNum2(int problemNum2) {
		this.problemNum2 = problemNum2;
	}

	public String getProblemName() {
		return problemName;
	}

	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}

	public String getProblemLanguage() {
		return problemLanguage;
	}

	public void setProblemLanguage(String problemLanguage) {
		this.problemLanguage = problemLanguage;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public Date getProblemDate() {
		return problemDate;
	}

	public void setProblemDate(Date problemDate) {
		this.problemDate = problemDate;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	
	public String getProblemContent() {
		return problemContent;
	}
	
	public void setProblemContent(String problemContent) {
		this.problemContent = problemContent;
	}
	
	public String getProblemInput() {
		return problemInput;
	}

	public void setProblemInput(String problemInput) {
		this.problemInput = problemInput;
	}

	public String getProblemOutput() {
		return problemOutput;
	}

	public void setProblemOutput(String problemOutput) {
		this.problemOutput = problemOutput;
	}
	public String getProblemInputEx() {
		return problemInputEx;
	}

	public void setProblemInputEx(String problemInputEx) {
		this.problemInputEx = problemInputEx;
	}

	public String getProblemOutputEx() {
		return problemOutputEx;
	}

	public void setProblemOutputEx(String problemOutputEx) {
		this.problemOutputEx = problemOutputEx;
	}

	
}
