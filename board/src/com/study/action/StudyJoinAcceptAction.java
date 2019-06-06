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

public class StudyJoinAcceptAction implements CommandAction {

	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {

		Class.forName("com.mysql.jdbc.Driver");
		// ��ȣ�� �Է¹޾ƿ� ������ ����
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		
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
			 
			query = "UPDATE userstudydb SET tag='" + true + "'WHERE num=" + num;
			stmt = conn.createStatement();
			stmt.executeQuery(query);


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

		return "studyjoinlist.do";

	}

}