/**
 * ï¿½Ô½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ Ç¥ï¿½ï¿½ï¿½Ï´ï¿½ Action
 */
package com.board.action;

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

public class ModifyformAction implements CommandAction {

	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {

		Class.forName("com.mysql.jdbc.Driver");
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";

		String dbUser = "root";
		String dbPass = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int kind;
		try {
			kind = Integer.parseInt(request.getParameter("kind"));// 1= list 2= studylist
		} catch (Exception e) {
			kind=1;
		}
		try {

			HttpSession session = request.getSession();

			if (session.getAttribute("id") == null) {
				return "loginerror.jsp";
			}
			String num = request.getParameter("num");

			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);
			String query = null;
			if (kind <5) {
				query = "select * from board where num = " + num;

			} else {
				query = "select * from studydb where num = " + num;

			}
			ArrayList<board> articleList = new ArrayList<board>();
			ArrayList<study> studyList = new ArrayList<study>();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				if (kind == 1) {//¼öÁ¤ÇÊ¿ä
					board article = new board();
					article.setNum(rs.getInt("num"));
					article.setSubject(rs.getString("subject"));
					article.setContent(rs.getString("content"));
					article.setId(rs.getString("id"));
					article.setBoarddate(rs.getString("boarddate"));
					article.setEmail(rs.getString("email"));
					article.setBoardnum(rs.getInt("boardnum"));
					articleList.add(article);
					request.setAttribute("articleList", articleList);
					request.setAttribute("num", num);
				} else {
					study study = new study();
					study.setNum(rs.getInt("num"));
					study.setName(rs.getString("name"));
					study.setInform(rs.getString("inform"));
					study.setAdministor(rs.getString("administor"));
					studyList.add(study);
					request.setAttribute("studyList", studyList);
				}
			}

			stmt.close();
			conn.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
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
		if (kind == 1)
			return "modifyform.jsp";
		else if(kind==2)
			return "modifyform.jsp";
		else if(kind==3)
			return "modifyform.jsp";
		else if(kind==4)
			return "modifyform.jsp";
		else
			return "personalstudymodifyform.jsp";

	}

}