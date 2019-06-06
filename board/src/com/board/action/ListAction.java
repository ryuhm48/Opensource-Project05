/**
 * ����Ʈ�� �����ֱ� ���� Action
 */
package com.board.action;

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
import com.study.beans.study;

public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int kind;
		try {
			kind = Integer.parseInt(request.getParameter("kind"));// 1= list 2= studylist
		} catch (Exception e) {
			kind = 1;
		
		}
		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");
		System.out.println("lista2");
		try {
			HttpSession session = request.getSession();
			// �α����� �Ǿ����� ������ �����˾��� �α���ȭ������ �̵�
			String id = (String) session.getAttribute("id");
			if (id == null) {
				return "loginerror.jsp";
			}
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";

//    		String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
			// +
			// "useUnicode=true&characterEncoding = euc-kr";
			String dbUser = "root";
			String dbPass = "";
			String query = null;
			if (kind == 1 || kind == 2 || kind == 3 || kind == 4) {
				if (opt == null) {
					query = "select * from board where boardnum='" + kind + "' order by num";

				} else if (opt.equals("0")) {// 수정
					query = "select * from board where subject like '%" + condition + "%' order by num";
				} else if (opt.equals("1")) {// 수정
					query = "select * from board where content like '%" + condition + "%' order by num";
				} else if (opt.equals("2")) {// 수정
					query = "select * from board where id like '%" + condition + "%' order by num";
				}
			}

			else {
				if (opt == null) {
					query = "select * from studydb order by num";
				} else if (opt.equals("0")) {
					query = "select * from studydb where name like '%" + condition + "%' order by num";
				} else if (opt.equals("1")) {
					query = "select * from studydb where administor like '%" + condition + "%' order by num";
				} else if (opt.equals("2")) {
					query = "select * from studydb where inform like '%" + condition + "%' order by num";
				}
			}
			
			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			ArrayList<board> articleList = new ArrayList<board>();
			ArrayList<study> studyList = new ArrayList<study>();
			while (rs.next()) {
				if (kind < 5) {
					board article = new board();
					article.setNum(rs.getInt("num"));
					article.setSubject(rs.getString("subject"));
					article.setContent(rs.getString("content"));
					article.setId(rs.getString("id"));
					article.setBoarddate(rs.getString("boarddate"));
					article.setScore(rs.getString("score"));
					article.setBoardnum(rs.getInt("boardnum"));
					articleList.add(article);

				} else {
					study study = new study();
					study.setNum(rs.getInt("num"));
					study.setName(rs.getString("name"));
					study.setInform(rs.getString("inform"));
					study.setAdministor(rs.getString("administor"));
					studyList.add(study);

				}
			}
			request.setAttribute("articleList", articleList);
			request.setAttribute("studyList", studyList);
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
		if (kind == 1)
			return "list.jsp";
		else if (kind == 2) {
			return "list.jsp";
		} else if (kind == 3) {
			return "list.jsp";
		} else if (kind == 4) {
			return "list.jsp";
		} else
			return "personalstudylist.jsp";
	}

}