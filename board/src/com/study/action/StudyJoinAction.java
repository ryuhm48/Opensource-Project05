/**
 * �Խ��� ������ �����ִ� Action
 */
package com.study.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.beans.board;
import com.board.controller.CommandAction;
import com.study.beans.study;
import com.userstudy.beans.userstudy;

public class StudyJoinAction implements CommandAction {

	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {

		Class.forName("com.mysql.jdbc.Driver");
		// ��ȣ�� �Է¹޾ƿ� ������ ����
		int studynum = Integer.parseInt(request.getParameter("studynum"));
		
		System.out.println(studynum);
		int kind;
		try {
			kind = Integer.parseInt(request.getParameter("kind"));// 1= list 2= studylist
		} catch (Exception e) {
			kind = 1;
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String admin = null;
		String id = null;

		// ��ȸ�� ������ ���� ���� ����
		int score = 0;

		try {
			// ���� Ȯ���� �α��λ��°� �ƴϸ� �α���â ȣ��
			HttpSession session = request.getSession();
			id = (String) session.getAttribute("id");
			if (id == null) {
				return "loginerror.jsp";
			}

			String jdbc_driver = "com.mysql.jdbc.Driver";
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";

			// String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";

			// +
			// "useUnicode=true&characterEncoding = euc-kr";
			String dbUser = "root";
			String dbPass = "";
			String query = null;
			String query3 = null;
			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);

			query = "select * from userstudydb where studynum = " + studynum + "and userid =" + id + ";";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if (rs != null)
				return "studyjoinerror.jsp";
			else {
				query = "insert into userstudydb values(NULL,NULL,false,NULL)";

				stmt = conn.createStatement();
				stmt.executeQuery(query);
			}
		} catch (

		SQLException ex) {

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException ex) {
				}

			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}

		return "content.do?num=${study.num}&kind=${5 }";

	}

}