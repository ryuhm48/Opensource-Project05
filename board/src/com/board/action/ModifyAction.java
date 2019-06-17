/**
 * ï¿½Ô½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï´ï¿½ Action
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

public class ModifyAction implements CommandAction {

	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {

		// Class.forName("com.mysql.jdbc.Driver");
		String jdbc_driver = "com.mysql.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		int kind;
		int num=0;
		try {
			kind = Integer.parseInt(request.getParameter("kind"));// 1= list 2= studylist
		} catch (Exception e) {
			kind = 3;
		}
		 num = Integer.parseInt(request.getParameter("num"));
		
		// String url = "jdbc:mysql://127.0.0.1/jspdb";
		String dbUser = "root";
		String dbPass = "";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(jdbc_driver);
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
				return "loginerror.jsp";
			}
			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);
			
			stmt = conn.createStatement();
			String sql = null;
			
			if (kind == 1 || kind == 2 || kind == 4) {
				 num = Integer.parseInt(request.getParameter("num"));
				String subject = request.getParameter("subject");
				String content = request.getParameter("content");
				
				sql = "UPDATE board SET subject='" + subject + "' ,content='" + content + "' WHERE num='" + num + "';";

			} else if (kind == 3) {
				 num = Integer.parseInt(request.getParameter("num"));
				String subject = request.getParameter("subject");
				String content = request.getParameter("content");
				sql = "UPDATE board SET subject='" + subject + "' ,content='" + content + "' WHERE num='" + num + "';";
				// ÆÄÀÏÃß°¡
			} else {
				 num = Integer.parseInt(request.getParameter("num"));
				String inform = request.getParameter("inform");
				String name = request.getParameter("name");
				sql = "UPDATE studydb SET name='" + name + "' ,inform='" + inform + "' WHERE num='" + num + "';";
			}
			stmt.executeUpdate(sql);
			
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
		if (kind == 1) {
			System.out.println(2);
			return "content.do?&kind=${1}";
			
		}
		else if (kind == 2)
			return "content.do?&kind=${2}";
		else if (kind == 3)
			return "content.do?&kind=${3}";
		else if (kind == 4)
			return "content.do?&kind=${4}";
		else if (kind == 5)
			return "content.do?&kind=${5}";
		else
			return "content.do?&kind=${6}";
	}

}