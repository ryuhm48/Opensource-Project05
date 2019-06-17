/**
 * ï¿½Ô½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ö´ï¿½ Action
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

public class ContentAction implements CommandAction {

	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {

		Class.forName("com.mysql.jdbc.Driver");
		// ï¿½ï¿½È£ï¿½ï¿½ ï¿½Ô·Â¹Þ¾Æ¿ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		int num=0;
		int kind;
		try {
			num = Integer.parseInt(request.getParameter("num"));
			kind = Integer.parseInt(request.getParameter("kind"));// 1= list 2= studylist
		} catch (Exception e) {
			kind = 1;
			
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String id = null;

		// ï¿½ï¿½È¸ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		int score = 0;

		try {
			// ï¿½ï¿½ï¿½ï¿½ È®ï¿½ï¿½ï¿½ï¿½ ï¿½Î±ï¿½ï¿½Î»ï¿½ï¿½Â°ï¿½ ï¿½Æ´Ï¸ï¿½ ï¿½Î±ï¿½ï¿½ï¿½Ã¢ È£ï¿½ï¿½
			HttpSession session = request.getSession();
			id = (String) session.getAttribute("id");
			if (id == null) {
				return "loginerror.jsp";
			}

			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";

			// String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";

			// +
			// "useUnicode=true&characterEncoding = euc-kr";
			String dbUser = "root";
			String dbPass = "";
			String query = null;
			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);
			if (kind == 1 || kind == 2 || kind == 3 || kind == 4) {
				query = "select * from board where num = " + num;
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
			} else {
				query = "select * from studydb where num = " + num;
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				// query3 = "select * MID(SUBSTRING(member,LOCATE(',',member)+1)"
				// + ",LOCATE(',',member),LOCATE(',',SUBSTRING(member,LOCATE(',',member)+1))-1)
				// "
				// + "from userdb where num = " + num;
				// stmt = conn.createStatement();
				// stmt.executeQuery(query3);
			}
			// ï¿½ï¿½È¸ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½Æ®ï¿½ï¿½ ï¿½Þ¾Æ¿ï¿½
			ArrayList<board> articleList = new ArrayList<board>();
			ArrayList<study> studyList = new ArrayList<study>();
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
					article.setBoardnum(rs.getInt("boardnum"));
					articleList.add(article);
					String query2 = "UPDATE board SET score='" + score + "' WHERE num='" + num + "';";
					stmt.executeUpdate(query2);
					request.setAttribute("articleList", articleList);
				} else if (kind == 2) {
					board article = new board();
					article.setNum(rs.getInt("num"));
					article.setSubject(rs.getString("subject"));
					article.setContent(rs.getString("content"));
					article.setId(rs.getString("id"));
					article.setBoarddate(rs.getString("boarddate"));
					score = Integer.parseInt(rs.getString("score")) + 1;
					article.setScore(String.valueOf(score));
					article.setEmail(rs.getString("email"));
					article.setBoardnum(rs.getInt("boardnum"));
					articleList.add(article);
					String query2 = "UPDATE board SET score='" + score + "' WHERE num='" + num + "';";
					stmt.executeUpdate(query2);
				} else if (kind == 3) {// ÀÚ·á°Ô½ÃÆÇ ÆÄÀÏÃß°¡
					board article = new board();
					article.setNum(rs.getInt("num"));
					article.setSubject(rs.getString("subject"));
					article.setContent(rs.getString("content"));
					article.setId(rs.getString("id"));
					article.setBoarddate(rs.getString("boarddate"));
					score = Integer.parseInt(rs.getString("score")) + 1;
					article.setScore(String.valueOf(score));
					article.setEmail(rs.getString("email"));
					article.setBoardnum(rs.getInt("boardnum"));
					articleList.add(article);
					request.setAttribute("articleList", articleList);
					request.setAttribute("articlenum", new Integer(num));
					String query2 = "UPDATE board SET score='" + score + "' WHERE num='" + num + "';";
					stmt.executeUpdate(query2);
				} else if (kind == 4) {
					board article = new board();
					article.setNum(rs.getInt("num"));
					article.setSubject(rs.getString("subject"));
					article.setContent(rs.getString("content"));
					article.setId(rs.getString("id"));
					article.setBoarddate(rs.getString("boarddate"));
					score = Integer.parseInt(rs.getString("score")) + 1;
					article.setScore(String.valueOf(score));
					article.setEmail(rs.getString("email"));
					article.setBoardnum(rs.getInt("boardnum"));
					articleList.add(article);
					request.setAttribute("articleList", articleList);
					request.setAttribute("articlenum", new Integer(num));
					String query2 = "UPDATE board SET score='" + score + "' WHERE num='" + num + "';";
					stmt.executeUpdate(query2);
				} else {

					study study = new study();
					study.setNum(rs.getInt("num"));
					study.setName(rs.getString("name"));
					study.setInform(rs.getString("inform"));
					study.setAdministor(rs.getString("administor"));
					studyList.add(study);
					request.setAttribute("studyList", studyList);
					request.setAttribute("articlenum", new Integer(num));
				}
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
		if (kind == 1) {// kindº°·Î ¼öÁ¤
			return "content.jsp";
		} else if (kind == 2) {
			return "content.jsp";
		} else if (kind == 3) {
			return"content.jsp";
		} else if (kind == 4) {
			return "content.jsp";
		} else {
			return "comparemember.do";
		}
	}

}