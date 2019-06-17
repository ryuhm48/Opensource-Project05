package com.answer.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.answer.beans.answer;
import com.board.beans.board;
import com.board.controller.CommandAction;
import com.problem.beans.problem;
import com.study.beans.study;


public class AnswerListAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rd = null;
		String query = null;
		
		int problemNum = Integer.parseInt(request.getParameter("problemNum"));
		String answerCode = request.getParameter("source");
		String ansOutput = request.getParameter("sourceOutput");
		String language = request.getParameter("answerLanguage");
		String writerName = request.getParameter("writerName");
		Boolean problemCorrection = false;
		ArrayList<answer> answerList = new ArrayList<answer>();
		int studyNum = -1;
		String problemName = null;
		String problemContent = null;
		String problemInputEx = null;
		String problemOutputEx = null;
		String output = null;
		
		try {
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			if (id == null) {
				return "loginerror.jsp";
			}
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
			String dbUser = "root";
			String dbPass = "";
			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);
			
			query = "select * from problems where problemNum1 = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, problemNum);
			rs = pstmt.executeQuery();

			ArrayList<problem> problemList = new ArrayList<problem>();

			while (rs.next()) {

				problem p = new problem();
				if (rs.getString("problemName") != null)
					problemName = rs.getString("problemName");
				if (rs.getString("problemContent") != null)
					problemContent = rs.getString("problemContent");
				if (rs.getInt("studyNum") != -1)
					studyNum = rs.getInt("studyNum");
				if (rs.getString("problemInputEx") != null)
					problemInputEx = rs.getString("problemInputEx");
				if (rs.getString("problemOutputEx") != null)
					problemOutputEx = rs.getString("problemOutputEx");
				if (rs.getString("problemOutput") != null)
					output = rs.getString("problemOutput");
				
				p.setStudyNum(studyNum);
				p.setProblemNum1(problemNum);
				p.setProblemName(problemName);
				p.setProblemContent(problemContent);
				p.setProblemInputEx(problemInputEx);
				p.setProblemOutputEx(problemOutputEx);
				problemList.add(p);
			}
			
			int size = 0;

			query = "select count(*) from Answers";
				
				rs = pstmt.executeQuery(query);
				rd = rs.getMetaData();
				size = rd.getColumnCount();
				int answerNum = size + 1;
				
			if(output.equals(ansOutput))
				problemCorrection = true;
			
			query = "insert into problems(problemNum1, answerCode, answerLanguage, writerName, problemCorrection, answerNum) values(?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, problemNum);
				pstmt.setString(2,answerCode);
				pstmt.setString(3, language);
				pstmt.setString(4, writerName);
				pstmt.setBoolean(5, problemCorrection);
				pstmt.setInt(6,answerNum);
				pstmt.executeUpdate();
			
				query = "select problemNum1, answerLanguage, writerName, answerCode, problemCorrection, answerNum from problems where problemNum1 = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, problemNum);
				rs = pstmt.executeQuery();
				if(rs.next())
				{do
				{
					answer a = new answer();
					a.setAnswerLanguage(rs.getString("answerLanguage"));
					a.setProblemNum1(problemNum);
					a.setWriterName(rs.getString("writerName"));
					a.setAnswerCode(rs.getString("answerCode"));
					a.setProblemCorrection(rs.getBoolean("problemCorrection"));
					a.setAnswerNum(rs.getInt("answerNum"));
					answerList.add(a);
				}
				while(rs.next());
				}
			
			request.setAttribute("answerList", answerList);
		} catch (SQLException ex) {

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}

			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	
			return "/Problems/AnswerList.jsp";
	}
	

}
