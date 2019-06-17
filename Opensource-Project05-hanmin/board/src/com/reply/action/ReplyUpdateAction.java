package com.reply.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.controller.CommandAction;
import com.reply.beans.reply;

public class ReplyUpdateAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		int num = Integer.parseInt(request.getParameter("num"));
		int kind;
		try {
			kind = Integer.parseInt(request.getParameter("kind"));// 1= list 5= studylist
		} catch (Exception e) {
			kind = 1;
		}
		
		
		try {
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			if (id == null) {
				return "loginerror.jsp";
			}

			String jdbc_driver = "com.mysql.jdbc.Driver";
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";

//    		String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
			// +
			// "useUnicode=true&characterEncoding = euc-kr";
			String dbUser = "root";
			String dbPass = "";

			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);

			String query = "UPDATE replydb SET text=? where num=?";
			pstmt.setString(1, request.getParameter("text"));
			pstmt.setInt(2,num);
			pstmt.executeUpdate();
			// pstmt = conn.prepareStatement(query);
			// pstmt.setString(1, text);
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
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
		return "replyadd.do";

	}
}