package com.answer.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.controller.CommandAction;
import com.problem.beans.problem;

public class AnswerSubmitAction implements CommandAction {
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
		problem p = new problem();
		
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
			String problemInput = null;
			String problemOutput = null;
			if(rs.next())
			{
				if(rs.getString("problemInput")!= null)
					problemInput = rs.getString("problemInput");
				if(rs.getString("problemOutput")!= null)
					problemOutput = rs.getString("problemOutput");
			}
			p.setProblemNum1(problemNum);
			p.setProblemInput(problemInput);
			p.setProblemOutput(problemOutput);
			request.setAttribute("problem", p);
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
	
			return "/Problems/Answer.jsp";
	}

}
