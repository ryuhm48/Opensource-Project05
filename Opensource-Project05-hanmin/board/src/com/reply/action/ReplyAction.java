package com.reply.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.beans.board;
import com.reply.beans.reply;
import com.board.controller.CommandAction;
import java.sql.PreparedStatement;

public class ReplyAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,

			HttpServletResponse response) throws Throwable {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query =null;
		int kind;
		String text = request.getParameter("reply");

		try {
			kind = Integer.parseInt(request.getParameter("kind"));// 1= list 2= studylist
		} catch (Exception e) {
			kind = 1;
		}
		System.out.println(request.getParameter("num"));
		int board = Integer.parseInt(request.getParameter("num"));
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

			pstmt = conn.prepareStatement("insert into replydb value(?,NULL,?,?)");
			pstmt.setString(1, text);
			pstmt.setString(2, id);
			pstmt.setInt(3, board);
			// Äõ¸® ½ÇÇà

			pstmt.executeUpdate();
			request.setAttribute("articlenum", new Integer(board));
			// ArrayList<reply> replyList = new ArrayList<reply>();

			// while (rs.next()) {
			// board reply = new board();
			// reply.setNum(rs.getInt("num"));
			// reply.setText(rs.getString("text"));
			// replyList.add(reply);
			// request.setAttribute("replyList", replyList);
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		System.out.println("1s");
		query="alter table replydb auto_increment=1";
	      try {
	          pstmt=conn.prepareStatement(query);
	          pstmt.executeUpdate();
	       }
	       catch(SQLException e){
	          e.printStackTrace();
	       }
	       finally {
	          
	       }
	      query="set @count=0";
	      try {
	          pstmt=conn.prepareStatement(query);
	          pstmt.executeUpdate();
	       }
	       catch(SQLException e){
	          e.printStackTrace();
	       }
	       finally {
	          
	       }
	      System.out.println("2s");
	      query="update replydb set replydb.num=@count:=@count+1";
	      try {
	          pstmt=conn.prepareStatement(query);
	          pstmt.executeUpdate();
	       }
	       catch(SQLException e){
	          e.printStackTrace();
	       }
	       finally {
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
	      System.out.println("3s");
		return "replyadd.do";

	}

}
