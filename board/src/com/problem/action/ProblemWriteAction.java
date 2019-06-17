package com.problem.action;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.controller.CommandAction;

public class ProblemWriteAction implements CommandAction {

	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {
		// 제목과 내용을 입력 받아 변수에 저장
		String administor = null;
		int studyNum = Integer.parseInt(request.getParameter("studyNum"));
		int problemNum2 = Integer.parseInt(request.getParameter("problemNum2"));
		String problemName = request.getParameter("problemName");
		String problemLanguage = request.getParameter("problemLanguage");
		String writerName = request.getParameter("writerName");
		String problemContent = request.getParameter("problemContent");
		String problemInput = request.getParameter("problemInput");
		String problemOutput = request.getParameter("problemOutput");
		String problemInputEx = request.getParameter("problemInputEx");
		String problemOutputEx = request.getParameter("problemOutputEx");

		String id = null;
		String jdbc_driver = "com.mysql.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String query = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rd = null;
		try {
			HttpSession session = request.getSession();
			// 세션을 읽어 로그인 상태가 아니면 로그인 창으로 이동
			id = (String) session.getAttribute("id");
			administor = id;
			if (id == null) {
				return "loginerror.jsp";
			}
			int size = 0;

			query = "select count(*) from problems";
			rs = pstmt.executeQuery(query);
			rd = rs.getMetaData();
			size = rd.getColumnCount();
			java.util.Date UDate = new java.util.Date();
			Date problemDate = new Date(UDate.getTime());
			int problemNum1 = size + 1;

			Class.forName(jdbc_driver);

			String dbUser = "root";
			String dbPass = "";

			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);

			pstmt = conn.prepareStatement(

					"insert into Problems(studyNum, problemNum1, problemNum2, problemName, problemLanguage, problemDate, writerName, problemContent) values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, studyNum);
			pstmt.setInt(2, problemNum1);
			pstmt.setInt(3, problemNum2 + 1);
			pstmt.setString(4, problemName);
			pstmt.setString(5, problemLanguage);
			pstmt.setDate(6, problemDate);
			pstmt.setString(7, writerName);
			pstmt.setString(8, problemContent);
			pstmt.executeUpdate();
			// 쿼리 실행
			pstmt.executeUpdate();

		} catch (SQLException ex) {

		} finally {
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

		return "problemlist.do";

	}

}
