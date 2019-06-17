package com.problem.action;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.beans.board;
import com.board.controller.CommandAction;
import com.problem.beans.problem;


public class ProblemListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");

		try {
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			int studyNum = 1;
			if (id == null) {
				return "loginerror.jsp";
			}
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
			String dbUser = "root";
			String dbPass = "";
			String query = null;

			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);

			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			ArrayList<problem> problemList = new ArrayList<problem>();

			query = "select studyNum, problemNum1, problemNum2, problemName, problemLanguage, problemDate, commentNum, writerName, problemContent from problems where studyNum = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, studyNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					problem p = new problem();
					int StudyNum = rs.getInt("studyNum");
					int problemNum1 = rs.getInt("problemNum1");
					int problemNum2 = rs.getInt("problemNum2");
					String problemName = rs.getString("problemName");
					String problemLanguage = rs.getString("problemLanguage");
					String writerName = rs.getString("writerName");
					Date problemDate = rs.getDate("problemDate");
					String problemContent = rs.getString("problemContent");
					int commentNum = rs.getInt("commentNum");
					p.setStudyNum(StudyNum);
					p.setProblemNum1(problemNum1);
					p.setProblemNum2(problemNum2);
					p.setProblemName(problemName);
					p.setProblemLanguage(problemLanguage);
					p.setWriterName(writerName);
					p.setProblemDate(problemDate);
					p.setCommentNum(commentNum);
					p.setProblemContent(problemContent);
					problemList.add(p);
				} while (rs.next());
			}
			request.setAttribute("problemList", problemList);
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
		return "/Problems/ProblemList.jsp";
	}

}