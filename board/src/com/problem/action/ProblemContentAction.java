package com.problem.action;

import java.sql.Connection;
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
import com.study.beans.study;

public class ProblemContentAction implements CommandAction {
	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {

		Class.forName("com.mysql.jdbc.Driver");

		int num = Integer.parseInt(request.getParameter("num"));
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = null;

		int score = 0;

		int problemNum = Integer.parseInt(request.getParameter("problemNum"));

		try {
			// ���� Ȯ���� �α��λ��°� �ƴϸ� �α���â ȣ��
			HttpSession session = request.getSession();
			id = (String) session.getAttribute("id");
			if (id == null) {
				return "loginerror.jsp";
			}

			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
			String dbUser = "root";
			String dbPass = "";
			String query = null;
			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);

			query = "select * from problems where problemNum1 = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, problemNum);
			rs = pstmt.executeQuery();

			int studyNum = -1;
			String problemName = null;
			String problemContent = null;
			String problemInputEx = null;
			String problemOutputEx = null;

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
				p.setStudyNum(studyNum);
				p.setProblemNum1(problemNum);
				p.setProblemName(problemName);
				p.setProblemContent(problemContent);
				p.setProblemInputEx(problemInputEx);
				p.setProblemOutputEx(problemOutputEx);
				problemList.add(p);
				request.setAttribute("problemList", problemList);

			}

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

		return "/Problems/Show.jsp";

	}
}
