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

public class StudyJoinListAction implements CommandAction {

	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {

		Class.forName("com.mysql.jdbc.Driver");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		
		Connection conn = null;
		Statement stmt = null;
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

			query = "select * from userstudydb where studynum = '" + num + "'and tag ='" + 0 + "';";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			ArrayList<userstudy> userstudyList = new ArrayList<userstudy>();
			while (rs.next()) {
				userstudy userstudy = new userstudy();
				userstudy.setNum(rs.getInt("num"));
				userstudy.setUserid(rs.getString("userid"));
				userstudy.setStudynum(rs.getString("studynum"));
				userstudy.setTag(rs.getBoolean("tag"));

				userstudyList.add(userstudy);

			}

			request.setAttribute("userstudyList", userstudyList);
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

		return "personalstudyjoinlist.jsp";

	}

}