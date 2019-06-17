/**
 * ï¿½Ô½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ö´ï¿½ Action
 */
package com.study.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.controller.CommandAction;
import com.study.beans.study;

public class CompareMemberAction implements CommandAction {

	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {

		Class.forName("com.mysql.jdbc.Driver");
		// ï¿½ï¿½È£ï¿½ï¿½ ï¿½Ô·Â¹Þ¾Æ¿ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		System.out.println(request.getAttribute("studyList"));
		ArrayList<study> sl =(ArrayList<study>)request.getAttribute("studyList");
		study laststudy = sl.get(sl.size()-1);
		int num = laststudy.getNum();
		

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = null;
		String administor =null;
		//0 ºñÈ¸¿ø 1 È¸¿ø 2 °ü¸®ÀÚ
		int membercheck = 0;

		try {
			HttpSession session = request.getSession();
			id = (String) session.getAttribute("id");
			administor=laststudy.getAdministor();
			System.out.println("admin"+administor);
			System.out.println("studynum"+num);
			if (id == null) {
				return "loginerror.jsp";
			}

			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";

			String dbUser = "root";
			String dbPass = "";
			String query = null;
			conn = DriverManager.getConnection(jdbc_url, dbUser, dbPass);

			query = "select tag from userstudydb where userid = '"+id+"' and studynum = '" + num + "'and (tag ='" + 1 + "' or tag = '"+2+"');";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			System.out.println("id "+id+" num: "+num );
			while (rs.next()) {
				membercheck = rs.getInt("tag");
				System.out.println("tag "+membercheck );
			
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
		System.out.println(membercheck);
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