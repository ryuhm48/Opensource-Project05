/**
 * ï¿½Ô½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ö´ï¿½ Action
 */
package com.study.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.controller.CommandAction;

public class CompareMemberAction implements CommandAction {

	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {

		Class.forName("com.mysql.jdbc.Driver");
		// ï¿½ï¿½È£ï¿½ï¿½ ï¿½Ô·Â¹Þ¾Æ¿ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		int num = Integer.parseInt(request.getParameter("studynum"));
		System.out.println(num);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String admin = null;
		String id = null;
		String administor =null;
		//0 ºñÈ¸¿ø 1 È¸¿ø 2 °ü¸®ÀÚ
		int membercheck = 0;

		// ï¿½ï¿½È¸ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		int score = 0;

		try {
			// ï¿½ï¿½ï¿½ï¿½ È®ï¿½ï¿½ï¿½ï¿½ ï¿½Î±ï¿½ï¿½Î»ï¿½ï¿½Â°ï¿½ ï¿½Æ´Ï¸ï¿½ ï¿½Î±ï¿½ï¿½ï¿½Ã¢ È£ï¿½ï¿½
			HttpSession session = request.getSession();
			id = (String) session.getAttribute("id");
			administor=request.getParameter("administor");
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

			query = "select * from userstudydb where studynum = " + num + "and tag =" + true + ";";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (id.equals(rs.getString("userid"))) {
					membercheck = 1;
					break;
				}
			}
			if (membercheck==1){
				query = "select administor from studydb where administor = ? and num = ? ";
				pstmt.setString(1, administor);
				pstmt.setInt(2, num);
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					membercheck=2;
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
		if(membercheck==0)
			return "personalstudycontent.jsp";
		else if(membercheck==1)
			return "personalstudycontent_member.jsp";
		else if(membercheck==2)
			return "personalstudycontent_admin.jsp";
		else//¿¡·¯ 
			return "loginerror.jsp";
	}

}