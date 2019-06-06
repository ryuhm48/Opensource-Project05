/**
 * �Խ��� �����ϴ� Action
 */
package com.board.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.controller.CommandAction;

public class DeleteAction implements CommandAction {

	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("euc-kr");
		String jdbc_driver = "com.mysql.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";

		Class.forName("com.mysql.jdbc.Driver");
//    	String url = "jdbc:mysql://127.0.0.1/jspdb";
		String dbUser = "root";
		String dbPass = "";
		int num = Integer.parseInt(request.getParameter("num"));
		int kind;
		try {
			kind = Integer.parseInt(request.getParameter("kind"));// 1= list 2= studylist
		} catch (Exception e) {
			kind=1;
		}
		Statement stmt = null;
		Connection conn = null;
		try {
			HttpSession session = request.getSession();

			if (session.getAttribute("id") == null) {
				return "loginerror.jsp";
			}

			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);
			stmt = conn.createStatement();

			if (kind != 5) {
				String sql = "DELETE FROM board WHERE num=" + num;
				stmt.executeUpdate(sql);
			} 
			else{

				String sql = "DELETE FROM studydb WHERE num=" + num;
				stmt.executeUpdate(sql);
			}

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
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
		if(kind==1)
			return "delete.jsp";
		else if (kind==2) {
			return "delete.jsp";
		}
		else if (kind==3) {
			return "delete.jsp";
		}
		else if (kind==4) {
			return "delete.jsp";
		}
		
		else
			return "personalstudydelete.jsp";

	}

}