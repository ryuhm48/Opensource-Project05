/**
 * �Խ��� ������ �����ִ� Action
 */
package com.board.action;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import com.board.beans.board;

import com.board.controller.CommandAction;

public class ContentAction implements CommandAction {

	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {

		Class.forName("com.mysql.jdbc.Driver");
		// ��ȣ�� �Է¹޾ƿ� ������ ����
		int num = Integer.parseInt(request.getParameter("num"));
		int kind;
		try {
			kind = Integer.parseInt(request.getParameter("kind"));// 1= list 2= studylist
		} catch (Exception e) {
			kind=1;
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// ��ȸ�� ������ ���� ���� ����
		int score = 0;

		try {
			// ���� Ȯ���� �α��λ��°� �ƴϸ� �α���â ȣ��
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
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
			if (kind == 1) {
				query = "select * from board where num = " + num;
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
			} else {
				query = "select * from studydb where num = " + num;

				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
			
			}
			// ��ȸ�� ����Ʈ�� �޾ƿ�
			ArrayList<board> articleList = new ArrayList<board>();
			ArrayList<board> studyList = new ArrayList<board>();
			while (rs.next()) {
				if (kind == 1) {
					board article = new board();
					article.setNum(rs.getInt("num"));
					article.setSubject(rs.getString("subject"));
					article.setContent(rs.getString("content"));
					article.setId(rs.getString("id"));
					article.setBoarddate(rs.getString("boarddate"));
					score = Integer.parseInt(rs.getString("score")) + 1;
					article.setScore(String.valueOf(score));
					article.setEmail(rs.getString("email"));
					articleList.add(article);
					request.setAttribute("articleList", articleList);
					String query2 = "UPDATE board SET score='" + score + "' WHERE num=" + num;
					stmt.executeUpdate(query2);
				} else {
					board study = new board();
					study.setNum(rs.getInt("num"));
					study.setName(rs.getString("name"));
					study.setInform(rs.getString("inform"));
					study.setAdministor(rs.getString("administor"));
					//, ���� ã��
				
					study.setMember("member");
					studyList.add(study);
					request.setAttribute("studyList", studyList);
				}
			}

		} catch (SQLException ex) {

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
		if (kind == 1) {
			return "content.jsp";
		} else {
			return "personalstudycontent.jsp";
		}
	}

}