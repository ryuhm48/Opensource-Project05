/**
 * �Խ��� ������ �����ִ� Action
 */
package com.study.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.controller.CommandAction;

public class StudyJoinAction implements CommandAction {

	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {

		Class.forName("com.mysql.jdbc.Driver");
		int studynum = Integer.parseInt(request.getParameter("num"));

		System.out.println(studynum);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = null;

		try {
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

			query = "select * from userstudydb where studynum = '" + studynum + "'and userid ='" + id + "';";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery(query);
			

			if (rs.next()) {

			}

			else {
				query = "insert into userstudydb values(NULL,?,?,0)";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, id);
				pstmt.setInt(2, studynum);
				
				pstmt.executeUpdate();
			}
		} catch (

		SQLException ex) {

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
		System.out.println("return front");
		return "content.do?num=" + studynum + "&kind=${5 }";

	}

}